package bdbt_proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class SalesDAOTest {

	private DepartmentDAO departmentDAO;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl2");
		dataSource.setUsername("ADAMSERO");
		dataSource.setPassword("jebacpofe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

		departmentDAO = new DepartmentDAO(new JdbcTemplate(dataSource));
	}

	@Test
	void testList() {
		List<Department> list = departmentDAO.list();
		assertTrue(!list.isEmpty());
	}

	@Test
	void testSave() {
		Department department = new Department(8, "123456789", "2021-01-01 08:00:00", "2021-01-01 19:30:00", 1, 15);
		departmentDAO.save(department);
	}

	@Test
	void testGet() {
		int id = 5;
		Department department = departmentDAO.get(id);
		System.out.println(department);

		assertNotNull(department);
	}

	@Test
	void testUpdate() {
		Department department = new Department(10, "987654321", "2021-01-01 08:00:00", "2021-01-01 19:30:00", 1, 4);
		departmentDAO.update(department);
	}

	@Test
	void testDelete() {
		int id = 11;
		departmentDAO.delete(id);
	}

}
