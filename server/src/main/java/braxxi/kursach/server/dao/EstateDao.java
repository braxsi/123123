package braxxi.kursach.server.dao;

import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.*;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StrBuilder;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EstateDao extends BaseDao {

	public List<EstateEntity> search(SearchEstate searchEstate) {
		final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		StrBuilder where = new StrBuilder();

		DaoUtils.addSimpleCondition("district_id", searchEstate.getDistrictId(), parameterSource, where);
		DaoUtils.addFromTo("total_area", searchEstate.getTotalAreaFrom(), searchEstate.getTotalAreaTo(), parameterSource, where);
		DaoUtils.addFromTo("living_area", searchEstate.getLivingAreaFrom(), searchEstate.getLivingAreaTo(), parameterSource, where);
		DaoUtils.addFromTo("kitchen_area", searchEstate.getKitchenAreaFrom(), searchEstate.getKitchenAreaTo(), parameterSource, where);
		DaoUtils.addFromTo("floor", searchEstate.getFloorFrom(), searchEstate.getFloorTo(), parameterSource, where);
		DaoUtils.addFromTo("rooms", searchEstate.getRoomsFrom(), searchEstate.getRoomsTo(), parameterSource, where);
		DaoUtils.addFromTo("price", searchEstate.getPriceFrom(), searchEstate.getPriceTo(), parameterSource, where);

		String whereString = where.isEmpty() ? "" : where.insert(0, " WHERE ").toString();
		return getNamedParameterJdbcTemplate().query("SELECT * FROM estates" + whereString,
				parameterSource,
				ESTATE_ROW_MAPPER);
	}

	public Long addEstate(EstateEntity estate) {
		final MapSqlParameterSource sqlParameterSource = getMapSqlParameterSource(estate);
		final GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(
				"INSERT INTO estates " +
						"(estate_id, " +
						"district_id, total_area, living_area, kitchen_area, " +
						"floor, floors, distance_to_metro, " +
						"description, rooms, contacts, price,  user_id)" +
						" VALUES " +
						"(:estate_id, :district_id, :total_area, :living_area, :kitchen_area, :floor, :floors, :distance_to_metro, :description, :rooms, :contacts, :price, :user_id)",
				sqlParameterSource, generatedKeyHolder);
		return generatedKeyHolder.getKey().longValue();
	}

	public void updateEstate(EstateEntity estate) {
		final MapSqlParameterSource sqlParameterSource = getMapSqlParameterSource(estate);
		getNamedParameterJdbcTemplate().update(
				"UPDATE estates SET " +
						"district_id=:district_id, total_area=:total_area, living_area=:living_area, kitchen_area=:kitchen_area, " +
						"floor=:floor, floors=:floors, distance_to_metro=:distance_to_metro, " +
						"description=:description, rooms=:rooms, price=:price, contacts=:contacts" +
						//", user_id=:user_id" +
						" WHERE estate_id=:estate_id",
				sqlParameterSource);
	}

	public void deleteEstate(Long estateId) {
		int count = getNamedParameterJdbcTemplate().update(
				"DELETE FROM estates WHERE estate_id=:estate_id"
				, new MapSqlParameterSource("estate_id", estateId));
		Preconditions.checkState(count == 1, "Count should be 1 but " + count);
	}

	private MapSqlParameterSource getMapSqlParameterSource(EstateEntity estate) {
		return new MapSqlParameterSource()
				.addValue("estate_id", estate.getId())
				.addValue("district_id", estate.getDistrictId())
				.addValue("total_area", estate.getTotalArea())
				.addValue("living_area", estate.getLivingArea())
				.addValue("kitchen_area", estate.getKitchenArea())
				.addValue("floor", estate.getFloor())
				.addValue("floors", estate.getFloors())
				.addValue("distance_to_metro", estate.getDistanceToMetro())
				.addValue("description", StringUtils.trimToNull(estate.getDescription()))
				.addValue("rooms", estate.getRooms())
				.addValue("contacts", StringUtils.trimToNull(estate.getContacts()))
				.addValue("price", estate.getPrice())
				.addValue("user_id", estate.getUserId());
	}

	public EstateEntity getEstate(Long estateId) {
		return getNamedParameterJdbcTemplate().queryForObject(
				"SELECT * FROM estates WHERE estate_id=:estate_id"
				, new MapSqlParameterSource("estate_id", estateId)
				, ESTATE_ROW_MAPPER);
	}

	public EstimateEstateResponse estimateEstate(EstateEntity entity) {
		final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		StrBuilder where = new StrBuilder();

		DaoUtils.addSimpleCondition("district_id", entity.getDistrictId(), parameterSource, where);
		DaoUtils.addFromToWithCoeff("total_area", entity.getTotalArea(), parameterSource, where);
		DaoUtils.addFromToWithCoeff("living_area", entity.getLivingArea(), parameterSource, where);
		DaoUtils.addFromToWithCoeff("kitchen_area", entity.getKitchenArea(), parameterSource, where);

		//addFromToWithCoeff("floor", entity.get(), parameterSource, where);
		//addFromToWithCoeff("floors", entity.get(), parameterSource, where);
		//addFromToWithCoeff("distance_to_metro", entity.get(), parameterSource, where);

		DaoUtils.addSimpleCondition("rooms", entity.getRooms(), parameterSource, where);

		String whereString = where.isEmpty() ? "" : where.insert(0, " WHERE ").toString();
		return getNamedParameterJdbcTemplate().queryForObject("SELECT min(price) min, avg(price) avg, max(price) max FROM estates " + whereString,
				parameterSource,
				ESTIMATE_ROW_MAPPER);
	}

	public SystemDictionary getDistricts() {
		final List<DictionaryItem> districtList = getNamedParameterJdbcTemplate().query("SELECT * FROM districts", DICTRICT_ROW_MAPPER);
		final Map<Integer, DictionaryItem> itemMap = districtList.stream().collect(Collectors.toMap(DictionaryItem::getId, Function.identity()));
		return new SystemDictionary("districts", itemMap);
	}

	public static final RowMapper<EstateEntity> ESTATE_ROW_MAPPER = new RowMapper<EstateEntity>() {
		@Override
		public EstateEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			EstateEntity estateEntity = new EstateEntity();
			estateEntity.setId(rs.getLong("estate_id"));
			estateEntity.setDistrictId(rs.getInt("district_id"));
			estateEntity.setTotalArea(rs.getBigDecimal("total_area"));
			estateEntity.setLivingArea(rs.getBigDecimal("living_area"));
			estateEntity.setKitchenArea(rs.getBigDecimal("kitchen_area"));
			estateEntity.setFloor(rs.getInt("floor"));
			estateEntity.setFloors(rs.getInt("floors"));
			estateEntity.setDistanceToMetro(rs.getInt("distance_to_metro"));
			estateEntity.setDescription(rs.getString("description"));
			estateEntity.setRooms(rs.getInt("rooms"));
			estateEntity.setContacts(rs.getString("contacts"));
			estateEntity.setPrice(rs.getBigDecimal("price"));
			estateEntity.setUserId(rs.getLong("user_id"));
			return estateEntity;
		}
	};

	public static final RowMapper<DictionaryItem> DICTRICT_ROW_MAPPER = new RowMapper<DictionaryItem>() {
		@Override
		public DictionaryItem mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DictionaryItem(rs.getInt("district_id"), rs.getString("name"));
		}
	};

	public static final RowMapper<EstimateEstateResponse> ESTIMATE_ROW_MAPPER = new RowMapper<EstimateEstateResponse>() {
		@Override
		public EstimateEstateResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new EstimateEstateResponse(
					rs.getBigDecimal("min"),
					rs.getBigDecimal("avg"),
					rs.getBigDecimal("max")
			);
		}
	};

	public void generateEstate(GenerateEstatesRequest request) {
		int count = request.getCount();

		for (int i = 0; i < count; i++) {
			final EstateEntity estateEntity = EstateEntity.generateRandom(null);
			addEstate(estateEntity);
		}
	}
}
