package braxxi.kursach.server.dao;

import org.apache.commons.text.StrBuilder;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import static org.junit.Assert.assertThat;

public class DaoUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addFrom() {
		checkAddFromTo("field1", "value1", "value2", 2, "field1>=:field1_from AND field1<=:field1_to");
		checkAddFromTo("field1", "value1", null, 1, "field1>=:field1_from");
		checkAddFromTo("field1", null, "value2", 1, "field1<=:field1_to");
		checkAddFromTo("field1", null, null, 0, "");
	}

	private void checkAddFromTo(String fieldName, Object from, Object to, int expectedParams, String expectedWhere) {
		final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		final StrBuilder where = new StrBuilder();

		DaoUtils.addFromTo(fieldName, from, to, parameterSource, where);

		checkParam(fieldName + "_from", from, parameterSource);
		checkParam(fieldName + "_to", to, parameterSource);
		assertThat(parameterSource.getValues().size(), Matchers.is(expectedParams));

		assertThat(where.toString(), Matchers.is(expectedWhere));
	}

	private void checkParam(String paramName, Object value, MapSqlParameterSource parameterSource) {
		if (value == null) {
			assertThat(parameterSource.hasValue(paramName), Matchers.is(false));
		} else {
			assertThat(parameterSource.getValue(paramName), Matchers.is(value));
		}
	}

	@Test
	public void addSimpleCondition() {
		checkAddSimpleCondition("field1", "value1", 1, "field1=:field1");
		checkAddSimpleCondition("field1", null, 0, "");
	}

	private void checkAddSimpleCondition(String fieldName, Object value, int expectedParams, String expectedWhere) {
		final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		final StrBuilder where = new StrBuilder();

		DaoUtils.addSimpleCondition(fieldName, value, parameterSource, where);

		checkParam(fieldName, value, parameterSource);
		assertThat(parameterSource.getValues().size(), Matchers.is(expectedParams));

		assertThat(where.toString(), Matchers.is(expectedWhere));
	}

}