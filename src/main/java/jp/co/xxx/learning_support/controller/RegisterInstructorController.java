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
import jp.co.xxx.learning_support.repository.InstructorRepository;
import jp.co.xxx.learning_support.service.InstructorService;

@Controller
@RequestMapping("/admin")
public class RegisterInstructorController {

	@Autowired
	private InstructorService service;
	
	@ModelAttribute
	public InstructorForm setUpInstructorForm(){
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
}
