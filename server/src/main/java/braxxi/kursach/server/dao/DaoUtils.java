package braxxi.kursach.server.dao;

import org.apache.commons.text.StrBuilder;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.math.BigDecimal;

public class DaoUtils {

	public static final BigDecimal LESSER_COEFF = new BigDecimal("0.9");
	public static final BigDecimal BIGGER_COEFF = new BigDecimal("1.1");

	public static void addFromTo(String field, Object fromValue, Object toValue, MapSqlParameterSource parameterSource, StrBuilder where) {
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
	}

	public static void addSimpleCondition(String field, Object value, MapSqlParameterSource parameterSource, StrBuilder where) {
		if (value != null) {
			if (!where.isEmpty()) {
				where.append(" AND ");
			}
			addCondition(field, value, "", "=", parameterSource, where);
		}
	}

	public static void addCondition(String field, Object value, String suffix, String operator, MapSqlParameterSource parameterSource, StrBuilder where) {
		final String paramName = field + suffix;
		parameterSource.addValue(paramName, value);
		where.append(field).append(operator).append(":").append(paramName);
	}

	public static void addFromToWithCoeff(String field, BigDecimal value, MapSqlParameterSource parameterSource, StrBuilder where) {
		if (value != null) {
			addFromTo(field, LESSER_COEFF.multiply(value), BIGGER_COEFF.multiply(value), parameterSource, where);
		}
	}

	public static void addFromToWithCoeff(String field, Integer value, MapSqlParameterSource parameterSource, StrBuilder where) {
		if (value != null) {
			addFromToWithCoeff(field, BigDecimal.valueOf(value), parameterSource, where);
		}
	}
}
