package jp.co.xxx.learning_support.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.domain.Company;
import jp.co.xxx.learning_support.service.CompanyService;

@Controller
@RequestMapping("/admin")
public class ShowCompanyListController {
	
	@Autowired
	private CompanyService service;
	
	
	@RequestMapping("/showCompanyList")
	public String showCompanyList(Model model) {		
		List<Company> companyList = service.showCompanyList();
		model.addAttribute("companyList", companyList);
		return "admin/company_list";
	}

}
