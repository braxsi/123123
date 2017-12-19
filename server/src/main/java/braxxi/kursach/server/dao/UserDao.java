package braxxi.kursach.server.dao;

import braxxi.kursach.commons.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserDao extends BaseDao {

	public UserEntity getUser(String login, String password) {
		final SqlParameterSource parameterSource = new MapSqlParameterSource()
				.addValue("login", login)
				.addValue("password", password);
		return queryForOptionalObject("SELECT * FROM users WHERE login=:login AND password=:password",
				parameterSource,
				USER_ROW_MAPPER);
	}

	public static final RowMapper<UserEntity> USER_ROW_MAPPER = new RowMapper<UserEntity>() {
		@Override
		public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserEntity userEntity = new UserEntity();
			userEntity.setId(rs.getLong("user_id"));
			userEntity.setLogin(rs.getString("login"));
			userEntity.setPassword(rs.getString("password"));
			userEntity.setEmail(rs.getString("email"));
			userEntity.setAdmin(rs.getBoolean("is_admin"));
			return userEntity;
		}
	};
}
