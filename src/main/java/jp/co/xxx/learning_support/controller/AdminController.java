package jp.co.xxx.learning_support.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.form.AdminForm;
import jp.co.xxx.learning_support.service.AdminService;

@Controller
@RequestMapping("")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@ModelAttribute
	public AdminForm setUpAdminForm() {
		return new AdminForm();
	}
	
	
	@RequestMapping("")
	public String index() {
		return "admin/admin_login";
	}
	
	@RequestMapping("show-training-list")
	public String showTrainingList() {
		
		
		
		return "admin/admin_training_list";
	}
	
}
