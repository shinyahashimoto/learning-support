package jp.co.xxx.learning_support.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.domain.Student;
import jp.co.xxx.learning_support.form.DailyReportForm;
import jp.co.xxx.learning_support.service.StudentService;

/**
 * 受講生情報を操作するコントローラークラス.
 * 
 * @author hiraokayuri
 *
 */
@Controller
@RequestMapping("")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@ModelAttribute
	public DailyReportForm setUpDailyReportForm() {
		return new DailyReportForm();
	}
	
	/**
	 * 日付を取得してから、日報登録のページに遷移する.
	 * 
	 * @return studante_register_daily_report.html 日報記入ページ.
	 */
	@RequestMapping("/registerDaily")
	public String registerDaily(Model model) {
		Date date = new Date();
		model.addAttribute("date", date);
		
		return "studante_register_daily_report";
		
	}
	
	/**
	 * 日報情報を登録する.
	 * 
	 * @param form 日報情報
	 * 
	 * @return　student_training_list.html 研修一覧情報に戻る
	 */
	@RequestMapping("/registerDaily")
	public String registerDaily(DailyReportForm form , Student student) {
		service.insertDailyReport(form ,student);
		
		return "student_training_list";
		
		
		

}

}