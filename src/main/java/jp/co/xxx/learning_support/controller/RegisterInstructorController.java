package jp.co.xxx.learning_support.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.domain.Instructor;
import jp.co.xxx.learning_support.form.InstructorForm;
import jp.co.xxx.learning_support.service.InstructorService;

@Controller
@RequestMapping("/admin")
public class RegisterInstructorController {

	@Autowired
	private InstructorService service;

	@ModelAttribute
	public InstructorForm setUpInstructorForm() {
		return new InstructorForm();
	}

	/**
	 * 講師情報の登録ページに遷移します.
	 * 
	 * @return 講師情報の登録ページ
	 */
	@RequestMapping("/toRegisterInstructorPage")
	public String toRegisterInstructorPage() {
		return "admin/instructor_detail";
	}

	/**
	 * 講師情報を登録します.
	 * 
	 * @param form   入力値
	 * @param result エラーチェック
	 * @return 講師一覧画面
	 */
	@RequestMapping("/registerInstructor")
	public String registerInstructor(@Validated InstructorForm form, BindingResult result) {
		// エラーチェックを行ってください

		if (result.hasErrors()) {
			return "redirect:toRegisterCompanyMemberPage";
		}

		Instructor instructor = new Instructor();
		BeanUtils.copyProperties(form, instructor);
		service.register(instructor);

		return "admin/admin_training_list";

	}

	/**
	 * 登録されているか確認するページに遷移します.
	 * 
	 * @return 確認ページ
	 */
	@RequestMapping("/toConfirmInstructorAccountPage")
	public String toConfirmAccountPage() {
		return "admin/instructor_confirm_account";
	}

	/**
	 * 登録されているEメールとパスワードで講師情報を取得します.
	 * 
	 * @param form   Eメールとパスワード
	 * @param result
	 * @return 入力されたEメールとパスワードに該当する講師情報
	 */
	@RequestMapping("/confirmAccountOfInstructor")
	public String confirmAccountOfInstructor(@Validated InstructorForm form, BindingResult result) {
		// 必要であればエラーチェックを追加してください

		if (result.hasErrors()) {
			return "";
		}

		Instructor instructor = new Instructor();
		BeanUtils.copyProperties(form, instructor);
		Instructor instructorAccount = service.findInstructor(instructor);

		if (instructorAccount == null) {
			// エラー表示をして、遷移元に遷移してください
			return "admin/instructor_confirm_account";
		}

		form.setEmail(instructorAccount.getEmail());
		return "admin/instructor_change_password";
	}

	/**
	 * パスワードを変更します.
	 * 
	 * @param form   入力されたパスワード・確認用パスワード
	 * @param result
	 * @return ログイン画面
	 */
	@RequestMapping("/changePasswordOfInstructor")
	public String changePasswordOfInstructor(@Validated InstructorForm form, BindingResult result) {
		// 必要であればエラーチェックを追加してください

		if (!(form.getPassword().equals(form.getConfirmPassword()))) {
			result.rejectValue("confirmPassword", "", "*入力されたパスワードと異なります");
		}

		if (result.hasErrors()) {
			return "redirect:/instructor/toRegisterInstructorPage";
		}

		Instructor instructor = new Instructor();
		BeanUtils.copyProperties(form, instructor);
		service.changePassWord(instructor);

		return "admin/instructor_login";
	}
}
