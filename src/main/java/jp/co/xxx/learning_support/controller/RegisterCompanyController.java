package jp.co.xxx.learning_support.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.domain.Company;
import jp.co.xxx.learning_support.form.CompanyForm;
import jp.co.xxx.learning_support.service.CompanyService;

@Controller
@RequestMapping("/admin")
public class RegisterCompanyController {

	@ModelAttribute
	public CompanyForm setUpCompanyForm() {
		return new CompanyForm();
	}
	
	@Autowired
	private CompanyService service;

	/**
	 * 企業情報を登録するページに遷移します.
	 * 
	 * @return
	 */
	@RequestMapping("/toRegisterCompanyPage")
	public String toRegisterCompanyPage() {
		return "admin/company_detail";
	}

	@RequestMapping("/registerCompany")
	public String registerCompany(@Validated CompanyForm form, BindingResult result) {
		//エラーチェックを行ってください
		
		//企業名は一意なので、企業名で検索をかけて、もし取得できたのなら、エラーを表示してください
		
		if(result.hasErrors()) {
			return "redirect:toRegisterCompanyPage";
		}
		Company company = new Company();
		BeanUtils.copyProperties(form, company);
		service.registerCompany(company);
		
		// 仮でこのパスに遷移している
		// 本来は一覧表示するコントローラにforwardしてあげる。
		return "admin/company_list";
	}
}
