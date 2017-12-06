package braxxi.kursach.server.dao;

import braxxi.kursach.commons.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;

import static org.springframework.dao.support.DataAccessUtils.singleResult;

public class BaseDao extends NamedParameterJdbcDaoSupport {


	@Autowired
	public void setAutowiredDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	protected UserEntity queryForOptionalObject(String sql, RowMapper<UserEntity> rowMapper) {
		return singleResult(getNamedParameterJdbcTemplate().query(sql, rowMapper));
	}

	protected UserEntity queryForOptionalObject(String sql, SqlParameterSource sqlParameterSource, RowMapper<UserEntity> rowMapper) {
		return singleResult(getNamedParameterJdbcTemplate().query(sql, sqlParameterSource, rowMapper));
	}

}
