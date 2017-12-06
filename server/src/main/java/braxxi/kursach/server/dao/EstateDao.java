package braxxi.kursach.server.dao;

import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.SearchEstate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EstateDao extends BaseDao {

	public List<EstateEntity> search(SearchEstate searchEstate) {
		final SqlParameterSource parameterSource = new MapSqlParameterSource();
		return getNamedParameterJdbcTemplate().query("SELECT * FROM apartments",
				parameterSource,
				ESTATE_ROW_MAPPER);
	}

	public Long addEstate(EstateEntity estate) {
		final MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("estateId", estate.getId())
				.addValue("totalArea", estate.getTotalArea())
				.addValue("description", estate.getDescription())
//				.addValue("", estate.get)
				;
		final GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(
				"INSERT INTO apartments " +
						"(idapartments, total_area, description)" +
						" VALUES " +
						"(:estateId, :totalArea, :description)",
				sqlParameterSource, generatedKeyHolder);
		return generatedKeyHolder.getKey().longValue();
	}

	public void updateEstate(EstateEntity estate) {
		final MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("estateId", estate.getId())
				.addValue("totalArea", estate.getTotalArea())
				.addValue("description", estate.getDescription())
//				.addValue("", estate.get)
				;
		getNamedParameterJdbcTemplate().update(
				"UPDATE apartments SET " +
						"total_area=:totalArea, description=:description " +
						"WHERE idapartments=:estateId",
				sqlParameterSource);
	}

	public EstateEntity getEstate(Long estateId) {
		return getNamedParameterJdbcTemplate().queryForObject(
				"SELECT * FROM apartments WHERE idapartments=:estateId"
				, new MapSqlParameterSource("estateId", estateId)
				, ESTATE_ROW_MAPPER);
	}

	public static final RowMapper<EstateEntity> ESTATE_ROW_MAPPER = new RowMapper<EstateEntity>() {
		@Override
		public EstateEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			EstateEntity estateEntity = new EstateEntity();
			estateEntity.setId(rs.getLong("idapartments"));
			estateEntity.setUserId(rs.getLong("user_id"));
			// todo
//			estateEntity.setLogin(rs.getString("login"));
//			estateEntity.setPassword(rs.getString("password"));
//			estateEntity.setEmail(rs.getString("email"));
			return estateEntity;
		}
	};
}
