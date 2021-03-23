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
public class AntennaTypeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AntennaTypeDAO(JdbcTemplate jdbcTeamplate) {
		super();
		this.jdbcTemplate = jdbcTeamplate;
	}
	
	public List<AntennaType> list() {

		String sqlQuery = "SELECT * FROM TYPY_ANTEN";
		List<AntennaType> list = jdbcTemplate.query(sqlQuery, BeanPropertyRowMapper.newInstance(AntennaType.class));

		return list;
	}
	
	public void save(AntennaType antennaType) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("typy_anten").usingColumns("id_typu_anteny", "zysk_energetyczny", "temperatura_szumowa", "wspolczynnik_szumow");
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(antennaType);
		insertActor.execute(parameterSource);
	}
	
	public AntennaType get(int id) {
		Object[] args = { id };
		String sqcQuery = "SELECT * FROM TYPY_ANTEN WHERE id_typu_anteny = " + args[0];
		AntennaType department = jdbcTemplate.queryForObject(sqcQuery,
				BeanPropertyRowMapper.newInstance(AntennaType.class));

		return department;
	}
	
	public void update(AntennaType antennaType) {
		String sqlQuery = "UPDATE TYPY_ANTEN SET zysk_energetyczny=:zysk_energetyczny, temperatura_szumowa=:temperatura_szumowa, wspolczynnik_szumow=:wspolczynnik_szumow WHERE id_typu_anteny=:id_typu_anteny";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(antennaType);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sqlQuery, param);
	}
	
	public void delete(int id) {
		String sqlQuery = "DELETE FROM TYPY_ANTEN WHERE id_typu_anteny = ?";
		jdbcTemplate.update(sqlQuery, id);
	}
}
