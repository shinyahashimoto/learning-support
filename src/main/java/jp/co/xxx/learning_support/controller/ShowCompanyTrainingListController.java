package jp.co.xxx.learning_support.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.xxx.learning_support.domain.LoginCompanyMember;
import jp.co.xxx.learning_support.domain.Training;
import jp.co.xxx.learning_support.repository.TrainingRepository;

@Controller
@RequestMapping("/company")
public class ShowCompanyTrainingListController {

	@Autowired
	private TrainingRepository trainingRepository;
	
	@RequestMapping("/showCompanyTrainingList")
	public String showCompanyTrainingList(@AuthenticationPrincipal LoginCompanyMember loginCompanyMember, Model model) {
		List<Training> trainingList = trainingRepository.findAll(loginCompanyMember.getCompanyMember().getCompanyId());
		
		model.addAttribute("trainingList", trainingList);
		return "/company/company_training_list";
	}
}
