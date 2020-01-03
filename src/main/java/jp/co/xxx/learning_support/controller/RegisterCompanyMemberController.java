package jp.co.xxx.learning_support.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	 * @return 登録ページ
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
		// エラーチェックを行ってください

		if (result.hasErrors()) {
			return "redirect:toRegisterCompanyMemberPage";
		}

		CompanyMember companyMember = new CompanyMember();
		BeanUtils.copyProperties(form, companyMember);
		// 下記の処理は必要ないのでは？
		companyMember.setCompanyId(form.getCompanyId());
		service.registerCompanyMember(companyMember);

		// 仮でこのパスに遷移している
		// 本来は一覧表示するコントローラにforwardしてあげる。
		return "admin/company_list";
	}

	/**
	 * 登録されているか確認するページに遷移します.
	 * 
	 * @return 確認ページ
	 */
	@RequestMapping("/toConfirmAccountPage")
	public String toConfirmAccountPage() {
		return "company/company_confirm_account";
	}

	/**
	 * 登録されているEメールとパスワードで企業担当者を取得します.
	 * 
	 * @param form   Eメールとパスワード
	 * @param result
	 * @return 入力されたEメールとパスワードに該当する企業担当者情報
	 */
	@RequestMapping("/confirmAccontOfCompanyMember")
	public String confirmAccontOfCompanyMember(@Validated CompanyMemberForm form, BindingResult result) {
		// 必要であればエラーチェックを追加してください

		if (result.hasErrors()) {
			return "redirect:/admin/toRegisterCompanyMemberPage";
		}

		CompanyMember companyMember = new CompanyMember();
		BeanUtils.copyProperties(form, companyMember);
		CompanyMember companyMemberAccount = service.findCompanyMember(companyMember);

		if (companyMemberAccount == null) {
			// エラー表示をして、遷移元に遷移してください
			return "company/company_confirm_account";
		}

		form.setEmail(companyMemberAccount.getEmail());
		return "company/company_change_password";

	}

	/**
	 * パスワードを変更します.
	 * 
	 * @param form   入力されたパスワード・確認用パスワード
	 * @param result
	 * @return ログイン画面
	 */
	@RequestMapping("/changePasswordOfCompanyMember")
	public String changePasswordOfCompanyMember(@Validated CompanyMemberForm form, BindingResult result) {
		// 必要であればエラーチェックを追加してください

		if (!(form.getPassword().equals(form.getConfirmPassword()))) {
			result.rejectValue("confirmPassword", "", "*入力されたパスワードと異なります");
		}

		if (result.hasErrors()) {
			return "redirect:/admin/toRegisterCompanyMemberPage";
		}

		CompanyMember companyMember = new CompanyMember();
		BeanUtils.copyProperties(form, companyMember);
		service.changePassWord(companyMember);

		return "company/company_login";
	}
}
