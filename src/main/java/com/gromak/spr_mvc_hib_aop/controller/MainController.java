package com.gromak.spr_mvc_hib_aop.controller;

import com.gromak.spr_mvc_hib_aop.entity.Employee;
import com.gromak.spr_mvc_hib_aop.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private EmployeeService employeeService;

    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String showMain(Model model) {
        var empls = employeeService.getAllEmployees();
        model.addAttribute("empls", empls);
        return "all-employees";
    }

    @RequestMapping("/add")
    public String add(Model model) {

        model.addAttribute("newEmp", new Employee());
        return "empl-info";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute("newEmp") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("empId") int id, Model model) {
        var emp = employeeService.getEmployeeById(id);
        model.addAttribute("newEmp", emp);
        return "empl-info";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("empId") int id, Model model) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }


}
