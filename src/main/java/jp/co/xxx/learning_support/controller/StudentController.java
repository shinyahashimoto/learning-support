package jp.co.xxx.learning_support.controller;



import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.form.DailyReportForm;

/**
 * 受講生情報を操作するコントローラークラス.
 * 
 * @author hiraokayuri
 *
 */
@Controller
@RequestMapping("")
public class StudentController {
	@ModelAttribute
	public DailyReportForm setUpDailyReportForm() {
		return new DailyReportForm();
	}
	
	/**
	 * 日付を取得してから、日報登録のページに遷移する.
	 * 
	 * @return studante_register_daily_report.html 日報記入ページ.
	 */
	public String showDaily(Model model) {
		Date date = new Date();
		model.addAttribute("date", date);
		
		return "studante_register_daily_report";
		
	}
	
	public String registerDaily(DailyReportForm form, Date date) {
		

}

}