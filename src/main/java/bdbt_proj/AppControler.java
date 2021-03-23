package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppControler {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private AntennaTypeDAO antennaTypeDAO;

	@RequestMapping("/")
	public String viewHomePage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getName();
		return "index_" + role;
	}
	
	@RequestMapping("/user/showDepartments")
	public String showDepartmentsUser(Model model) {
		List<Department> departments = departmentDAO.list();

		model.addAttribute("departments", departments);
		return "show_departments_user";
	}
	
	@RequestMapping("/user/showAntennaTypes")
	public String showAntennaTypesUser(Model model) {
		List<AntennaType> antennaTypes = antennaTypeDAO.list();

		model.addAttribute("antennaTypes", antennaTypes);
		return "show_antenna_types_user";
	}

	@RequestMapping("/admin/showDepartments")
	public String showDepartmentsAdmin(Model model) {
		List<Department> departments = departmentDAO.list();

		model.addAttribute("departments", departments);
		return "show_departments_admin";
	}
	
	@RequestMapping("/admin/showAntennaTypes")
	public String showAntennaTypesAdmin(Model model) {
		List<AntennaType> antennaTypes = antennaTypeDAO.list();

		model.addAttribute("antennaTypes", antennaTypes);
		return "show_antenna_types_admin";
	}

	@RequestMapping("/admin/newDepartment")
	public String showNewDepartment(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);

		return "new_department";
	}
	
	@RequestMapping("/admin/newAntennaType")
	public String showNewAntennaType(Model model) {
		AntennaType antennaType = new AntennaType();
		model.addAttribute("antennaType", antennaType);

		return "new_antenna_type";
	}

	@RequestMapping(value = "/admin/saveDepartment", method = RequestMethod.POST)
	public String saveDepartment(@ModelAttribute("department") Department department) {
		departmentDAO.save(department);
		return "redirect:/admin/showDepartments";
	}
	
	@RequestMapping(value = "/admin/saveAntennaType", method = RequestMethod.POST)
	public String saveAntennaType(@ModelAttribute("antennaType") AntennaType antennaType) {
		antennaTypeDAO.save(antennaType);
		return "redirect:/admin/showAntennaTypes";
	}

	@RequestMapping("/admin/editDepartment/{id_oddzialu}")
	public ModelAndView showEditDepartment(@PathVariable(name = "id_oddzialu") int id_oddzialu) {
		ModelAndView mav = new ModelAndView("edit_department");
		Department department = departmentDAO.get(id_oddzialu);
		mav.addObject("department", department);

		return mav;
	}
	
	@RequestMapping("/admin/editAntennaType/{id_typu_anteny}")
	public ModelAndView showEditAntennaType(@PathVariable(name = "id_typu_anteny") int id_typu_anteny) {
		ModelAndView mav = new ModelAndView("edit_antenna_type");
		AntennaType antennaType = antennaTypeDAO.get(id_typu_anteny);
		mav.addObject("antennaType", antennaType);

		return mav;
	}

	@RequestMapping(value = "/admin/updateDepartment", method = RequestMethod.POST)
	public String updateDepartment(@ModelAttribute("department") Department department) {
		departmentDAO.update(department);

		return "redirect:/admin/showDepartments";
	}
	
	@RequestMapping(value = "/admin/updateAntennaType", method = RequestMethod.POST)
	public String updateAntennaType(@ModelAttribute("antennaType") AntennaType antennaType) {
		antennaTypeDAO.update(antennaType);

		return "redirect:/admin/showAntennaTypes";
	}

	@RequestMapping("/admin/deleteDepartment/{id_oddzialu}")
	public String deleteDepartment(@PathVariable(name = "id_oddzialu") int id_oddzialu) {
		departmentDAO.delete(id_oddzialu);

		return "redirect:/admin/showDepartments";
	}
	
	@RequestMapping("/admin/deleteAntennaType/{id_typu_anteny}")
	public String deleteAntennaType(@PathVariable(name = "id_typu_anteny") int id_typu_anteny) {
		antennaTypeDAO.delete(id_typu_anteny);

		return "redirect:/admin/showAntennaTypes";
	}
}