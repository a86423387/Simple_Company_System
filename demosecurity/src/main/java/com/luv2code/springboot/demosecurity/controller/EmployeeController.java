package com.luv2code.springboot.demosecurity.controller;

import java.util.List;

import com.luv2code.springboot.demosecurity.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springboot.demosecurity.entity.Employee;


// @RequestMapping("/employees"): 指定所有這個控制器中方法的基本路徑。
// 通過構造函數注入 EmployeeService，這是依賴注入的一種形式，使得控制器不需要自己創建 EmployeeService 實例。
@Controller
@RequestMapping("/employees")/* 具體指出request的類別*/
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// 新增映射 "/list"
	// Model theModel: Spring MVC 中用於在控制器和視圖之間傳遞資料的容器。
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// 從資料庫取得員工
		List<Employee> theEmployees = employeeService.findAll();

		// 添加到spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	// 新增員工表單,為新增操作提供一個空的員工對象。
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// 建立模型屬性來綁定表單數據
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/showAdmin")
	public String showAdmin() {

		return "employees/employeesSystem";
	}

	// 更新員工表單
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {

		// 搜尋員工ID
		Employee theEmployee = employeeService.findById(theId);

		// 將員工設定為模型屬性以預先填入表單
		theModel.addAttribute("employee", theEmployee);

		// 發送至我們的表格
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// 儲存員工
		employeeService.save(theEmployee);

		//使用重新定向來防止重複提交
		return "redirect:/employees/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// 刪除員工
		employeeService.deleteById(theId);

		// 重新定向到 /employees/list
		return "redirect:/employees/list";

	}
}









