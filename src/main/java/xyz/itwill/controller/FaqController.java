package xyz.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill.service.FaqService;


@Controller
public class FaqController {
	@Autowired
	private FaqService faqService;
	
	@RequestMapping("/faq")
	public String faq(@RequestParam(defaultValue = "1") int index, Model model) {
//		String category = findCategory(index);
		String category = null;
		
		switch (index) {
		case 1:
			category = "all";
			break;
		case 2:
			category = "���å";
			break;
		case 3:
			category = "����";
			break;
		case 4:
			category = "�ŷ�ǰ��";
			break;
		case 5:
			category = "�̿�����";
			break;
		case 6:
			category = "��������";
			break;
		case 7:
			category = "��Ÿ";
			break;
		default:
			category = "all";
		}
		
		if (category == "all") {
			model.addAttribute("faqList", faqService.getFaqList());
		} else {
			model.addAttribute("faqList", faqService.getFaqListCategory(category));
		}
		model.addAttribute("index", index);
		return "faq/faq_list";
	}
	/*
	public String findCategory(int idx) {
		String category = null;
		
		switch (idx) {
			case 1:
				category = "all";
				break;
			case 2:
				category = "���å";
				break;
			case 3:
				category = "����";
				break;
			case 4:
				category = "�ŷ�ǰ��";
				break;
			case 5:
				category = "�̿�����";
				break;
			case 6:
				category = "��������";
				break;
			case 7:
				category = "��Ÿ";
				break;
			default:
				category = "all";
		}

		return category;
	}
	*/
}
