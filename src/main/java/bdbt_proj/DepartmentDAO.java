package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DepartmentDAO(JdbcTemplate jdbcTeamplate) {
		super();
		this.jdbcTemplate = jdbcTeamplate;
	}

	public List<Department> list() {

		String sqlQuery = "SELECT * FROM ODDZIALY ORDER BY ID_ODDZIALU";
		List<Department> list = jdbcTemplate.query(sqlQuery, BeanPropertyRowMapper.newInstance(Department.class));

		return list;
	}

	public void save(Department department) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("oddzialy").usingColumns("id_oddzialu", "numer_telefonu", "czas_otwarcia",
				"czas_zamkniecia", "id_operatora", "id_adresu");
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(department);
		insertActor.execute(parameterSource);
	}

	public Department get(int id) {
		Object[] args = { id };
		String sqcQuery = "SELECT * FROM ODDZIALY WHERE ID_ODDZIALU = " + args[0];
		Department department = jdbcTemplate.queryForObject(sqcQuery,
				BeanPropertyRowMapper.newInstance(Department.class));

		return department;
	}

	public void update(Department department) {
		String sqlQuery = "UPDATE ODDZIALY SET numer_telefonu=:numer_telefonu, czas_otwarcia=:czas_otwarcia, czas_zamkniecia=:czas_zamkniecia, id_operatora=:id_operatora, id_adresu=:id_adresu WHERE id_oddzialu=:id_oddzialu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(department);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sqlQuery, param);
	}

	public void delete(int id) {
		String sqlQuery = "DELETE FROM ODDZIALY WHERE ID_ODDZIALU = ?";
		jdbcTemplate.update(sqlQuery, id);
	}
}
