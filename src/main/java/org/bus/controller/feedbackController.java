package org.bus.controller;

import java.util.List;

import org.bus.model.FeedBack;
import org.bus.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/feedback")
public class feedbackController {
	
	@Autowired
	private IFeedBackService feedbackservice;
	
//	@GetMapping("/feedbackservice")
//	public String feedBackService(Model model) {
//		FeedBack feedback = new FeedBack();
//		model.addAttribute("feedback", feedback);
//		return "feedbackfolder/feedbackService";
//	}
	
	@GetMapping("/addfeedback")
	public String addFeedBack(Model model) {
		FeedBack feedback = new FeedBack();
		model.addAttribute("feedback", feedback);
		return "feedbackfolder/addfeedback";
	}
	@PostMapping("/addfeeedbackprocess")
	public String addFeedBackProcess(@ModelAttribute("feedback") FeedBack feedback) {
		FeedBack feedback1 = feedbackservice.addFeedBack(feedback);
		if(feedback1 == null) {
			return "feedbackfolder/addsuccessfull";
		}
		else
			return "feedbackfolder/addsuccessfull";
	}
	
	@GetMapping("/updatefeedback")
	public String updateFeedBack(Model model) {
		FeedBack feedback = new FeedBack();
		model.addAttribute("feedback", feedback);
		return "feedbackfolder/updatefeedback";
	}
	@PostMapping("/updatefetch")
	public String updateFetch(@ModelAttribute("feedback") FeedBack feedback, Model model) {
		feedback = feedbackservice.viewFeedBack(feedback.getFeedBackId());
		if(feedback == null){
			return "feedbackfolder/feedbacknotfound";
		}
		else
			model.addAttribute("feedback", feedback);
			return "feedbackfolder/feedbackfound";
	}
	@PostMapping("/updateprocess")
	public String updateProcess(@ModelAttribute("feedback") FeedBack feedback) {
		if(feedbackservice.updateFeedBack(feedback) == null) {
			return "feedbackfolder/updateunsuccessfull";
		}
		else
			return "feedbackfolder/updatesuccessfull";
	}
	@GetMapping("/viewfeedback")
	public String viewRoute(Model model) {
		FeedBack feedback = new FeedBack();
		model.addAttribute("feedback", feedback);
		return "feedbackfolder/viewfeedback";
	}
	@PostMapping("/viewprocess")
	public String viewRouteProcess(@ModelAttribute("feedback") FeedBack feedback, Model model) {
		feedback = feedbackservice.viewFeedBack(feedback.getFeedBackId());
		if(feedback == null) {
			return "feedbackfolder/feedbacknotfound";
		}
		else
			model.addAttribute("feedback", feedback);
			return "feedbackfolder/feedbackfound1";
	}
	
	@GetMapping("/listfeedback")
	public String listFeedback(Model model) {
		List<FeedBack> listfeedback = feedbackservice.viewAllFeedBack();
		model.addAttribute("feedbacks", listfeedback);
		return "feedbackfolder/listfeedback";
	}
	@GetMapping("/viewfeedbackbutton")
	public String viewfeedbackbutton(@RequestParam("feedBackId") Integer feedBackId, Model model) {
		FeedBack feedback = feedbackservice.viewFeedBack(feedBackId);
		if(feedback == null) {
			return"feedbackfolder/notfoundfeedback";
		}
		else
			return "feedbackfolder/foundfeedback";
	}
	@GetMapping("/givefeedback")
	public String giveFeedback(@RequestParam("feedBackId") Integer feedBackId, Model model) {
		FeedBack feedback = feedbackservice.viewFeedBack(feedBackId);
		if(feedback == null) {
			return"feedbackfolder/notfoundfeedback";
		}
		else
			return "feedbackfolder/addfeedback";
	}
	
}
