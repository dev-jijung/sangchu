package xyz.itwill.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill.dto.Member;
import xyz.itwill.exception.LoginAuthFailException;
import xyz.itwill.exception.UserinfoExistsException;
import xyz.itwill.exception.UserinfoNotFoundException;
import xyz.itwill.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberSerivce;
	
	//�α���
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		return "member/login";
	}
	
	//�α��� ����ó��
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(@ModelAttribute Member member, HttpSession session) throws LoginAuthFailException, UserinfoNotFoundException {
		memberSerivce.loginAuth(member);
		session.setAttribute("loginMember", memberSerivce.getMember(member.getId()));
		return "redirect:/";
	}
	
	//�α׾ƿ�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}
	
	
	//ȸ������
	@RequestMapping(value = "/join", method =  RequestMethod.GET) 
		public String join() {
			return "member/join";
		}
	
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {

		try {
			memberSerivce.addMember(member);
		} catch (UserinfoExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		return "redirect:/login";
	}
	
	
	//���̵�ã��
	@RequestMapping("/find_id")
	public String findId() {
		return "member/find_id";
	}
	
	//��й�ȣ ã��
	@RequestMapping("/find_password")
	public String findPasswd() {
		
		
		return "member/find_passwd";
	}
	
//	@RequestMapping(value = "/find_password", method = RequestMethod.POST)
//	public String findPasswd(@ModelAttribute Member member, Model model) {
//		model.addAttribute("id", 1������������ ���޹��� ���̵�);
//		model.addAttribute("name", 1������������ ���޹��� �̸�);
//		model.addAttribute("phone", 1������������ ���޹��� ��ȭ��ȣ);
//		
//		memberSerivce.modifyPayPw(member);
//		
//		return "member/find_passwd";
//	}
	
	
	//����ó�� ������̼�
	@ExceptionHandler(value = UserinfoExistsException.class)
	public String exceptionHandler(UserinfoExistsException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("member", exception.getMember());
		return "member/login";
	}
	
	@ExceptionHandler(value = LoginAuthFailException.class)
	public String excptionHandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("id", exception.getId());
		return "member/login";
	}

}
