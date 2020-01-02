package jp.co.xxx.learning_support.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.domain.CompanyMember;
import jp.co.xxx.learning_support.form.CompanyMemberForm;
import jp.co.xxx.learning_support.service.CompanyMemberService;

@Controller
@RequestMapping("/admin")
public class RegisterCompanyMemberController {

	@Autowired
	private CompanyMemberService service;

	@ModelAttribute
	public CompanyMemberForm setUpCompanyMemberForm() {
		return new CompanyMemberForm();
	}

	/**
	 * 企業担当者の登録ページに遷移します.
	 * 
	 * @return
	 */
	@RequestMapping("/toRegisterCompanyMemberPage")
	public String toRegisterCompanyMemberPage(Integer companyId, CompanyMemberForm form) {
		form.setCompanyId(companyId);
		return "admin/company_register_charge";
	}

	/**
	 * 企業担当者を登録します.
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping("/registerCompanyMember")
	public String registerCompanyMember(@Validated CompanyMemberForm form, BindingResult result) {
		//エラーチェックを行ってください
		
		if(result.hasErrors()) {
			return "redirect:toRegisterCompanyMemberPage";
		}
		
		CompanyMember companyMember = new CompanyMember();
		BeanUtils.copyProperties(form, companyMember);
		companyMember.setCompanyId(form.getCompanyId());
		service.registerCompanyMember(companyMember);

		// 仮でこのパスに遷移している
		// 本来は一覧表示するコントローラにforwardしてあげる。
		return "admin/company_list";
	}
}
