package jp.co.xxx.learning_support.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class ToCompanyLoginPageController {

	@RequestMapping("/toCompanyLoginPage")
	public String toCompanyLoginPage() {
		return "company/company_login";
	}
	
}
