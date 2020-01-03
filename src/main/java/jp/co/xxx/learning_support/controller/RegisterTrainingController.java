package jp.co.xxx.learning_support.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.domain.Instructor;
import jp.co.xxx.learning_support.domain.Training;
import jp.co.xxx.learning_support.form.TrainingForm;
import jp.co.xxx.learning_support.service.TrainingService;

@Controller
@RequestMapping("/admin")
public class RegisterTrainingController {

	@Autowired
	private TrainingService service;
	
	@ModelAttribute
	public TrainingForm setUpTrainingForm() {
		return new TrainingForm();
	}
	
	@RequestMapping("/toRegisterTrainingPage")
	public String toRegisterTrainingPage(Model model) {
		List<Instructor> instructorList = service.findAllInstructor();
		
		//optionのデフォルト値を「選択してください」にしてほしい
		
		
		model.addAttribute("instructorList", instructorList);
		return "/admin/admin_training_detail";
	}
	
	
	@RequestMapping("/registerTraining")
	public String registerTraining(
			@Validated TrainingForm form,
			BindingResult result,
			Integer subInstructorId1) {
		//エラーチェックを行ってください
		
		if(result.hasErrors()) {
			return "redirect:toRegisterCompanyMemberPage";
		}

		Training training = new Training();
		BeanUtils.copyProperties(form, training);
		String stardDate = form.getStartDate().replaceAll("-", "/");
		String endDate = form.getEndDate().replaceAll("-", "/");
			
		training.setStartDate(LocalDate.parse(stardDate, DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		training.setEndDate(LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		
		Training insertTraining = service.insertTraining(training);
		Integer trainingId = insertTraining.getId();
		if(!form.getStudentIdList().isEmpty()) {
			for (Integer studentId : form.getStudentIdList()) {
				service.insertTrainingStudent(trainingId, studentId);
			}
		}
		
		return "admin/admin_training_list";
	}
}
