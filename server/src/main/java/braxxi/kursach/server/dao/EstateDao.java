package braxxi.kursach.server.dao;

import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.DictionaryItem;
import braxxi.kursach.commons.model.SearchEstate;
import braxxi.kursach.commons.model.SystemDictionary;
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

		addSimpleCondition("district_id", searchEstate.getDistrictId(), parameterSource, where);
		addFromTo("total_area", searchEstate.getTotalAreaFrom(), searchEstate.getTotalAreaTo(), parameterSource, where);
		addFromTo("living_area", searchEstate.getLivingAreaFrom(), searchEstate.getLivingAreaTo(), parameterSource, where);
		addFromTo("kitchen_area", searchEstate.getKitchenAreaFrom(), searchEstate.getKitchenAreaTo(), parameterSource, where);
		addFromTo("floor", searchEstate.getFloorFrom(), searchEstate.getFloorTo(), parameterSource, where);
		addFromTo("rooms", searchEstate.getRoomsFrom(), searchEstate.getRoomsTo(), parameterSource, where);

		String whereString = where.isEmpty() ? "" : where.insert(0, " WHERE ").toString();
		return getNamedParameterJdbcTemplate().query("SELECT * FROM estates" + whereString,
				parameterSource,
				ESTATE_ROW_MAPPER);
	}

	private void addFromTo(String field, Object fromValue, Object toValue, MapSqlParameterSource parameterSource, StrBuilder where) {
		if (fromValue != null) {
			if (!where.isEmpty()) {
				where.append(" AND ");
			}
			addCondition(field, fromValue, "_from", ">=", parameterSource, where);
		}
		if (toValue != null) {
			if (!where.isEmpty()) {
				where.append(" AND ");
			}
			addCondition(field, toValue, "_to", "<=", parameterSource, where);
		}
//		where.append(")");
	}

	private void addSimpleCondition(String field, Object value, MapSqlParameterSource parameterSource, StrBuilder where) {
		if (value != null) {
			if (!where.isEmpty()) {
				where.append(" AND ");
			}
			addCondition(field, value, "", "=", parameterSource, where);
		}
	}

	private void addCondition(String field, Object value, String suffix, String operator, MapSqlParameterSource parameterSource, StrBuilder where) {
		final String paramName = field + suffix;
		parameterSource.addValue(paramName, value);
		where.append(field).append(operator).append(":").append(paramName);
	}

	public Long addEstate(EstateEntity estate) {
		final MapSqlParameterSource sqlParameterSource = getMapSqlParameterSource(estate);
		final GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(
				"INSERT INTO estates " +
						"(estate_id, " +
						"district_id, total_area, living_area, kitchen_area, " +
						"floor, floors, distance_to_metro, " +
						"description, rooms, contacts, user_id)" +
						" VALUES " +
						"(:estate_id, :district_id, :total_area, :living_area, :kitchen_area, :floor, :floors, :distance_to_metro, :description, :rooms, :contacts, :user_id)",
				sqlParameterSource, generatedKeyHolder);
		return generatedKeyHolder.getKey().longValue();
	}

	public void updateEstate(EstateEntity estate) {
		final MapSqlParameterSource sqlParameterSource = getMapSqlParameterSource(estate);
		getNamedParameterJdbcTemplate().update(
				"UPDATE estates SET " +
						"district_id=:district_id, total_area=:total_area, living_area=:living_area, kitchen_area=:kitchen_area, " +
						"floor=:floor, floors=:floors, distance_to_metro=:distance_to_metro, " +
						"description=:description, rooms=:rooms, contacts=:contacts" +
						//", user_id=:user_id" +
						" WHERE estate_id=:estate_id",
				sqlParameterSource);
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
					.addValue("user_id", estate.getUserId());
	}

	public EstateEntity getEstate(Long estateId) {
		return getNamedParameterJdbcTemplate().queryForObject(
				"SELECT * FROM estates WHERE estate_id=:estate_id"
				, new MapSqlParameterSource("estate_id", estateId)
				, ESTATE_ROW_MAPPER);
	}

	public SystemDictionary getDistricts() {
		final List<DictionaryItem> districtList = getNamedParameterJdbcTemplate().query("select * from districts", DICTRICT_ROW_MAPPER);
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
}
