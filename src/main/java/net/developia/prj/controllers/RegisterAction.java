package net.developia.prj.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.prj.models.MemberDTO;
import net.developia.prj.services.MemberService;

@Slf4j
@Controller
public class RegisterAction {
	@Autowired private MemberService memberService;

	@RequestMapping(value="/RegisterAction")
	public ModelAndView loginAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Boolean isAdmin = Boolean.parseBoolean(request.getParameter("manager"));
		
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("id", id);
		loginInfo.put("pw", pw);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(isAdmin);
		ModelAndView mav = null;
		try {
			MemberDTO memberDTO = memberService.getCurrentMember(loginInfo);
			log.info("현재 로그인 정보 불러오기 완료");
			HttpSession session = request.getSession(true);
			session.setAttribute("memberDTO", memberDTO);
			log.info("현재 로그인 정보 세션등록 완료");
			session.setMaxInactiveInterval(1800);
			
			if(isAdmin) {
				if(memberDTO.getGrade().getGrade().equals("admin")) {
					mav = new ModelAndView("redirect:mainManager");
				} else {
					mav = new ModelAndView("result");
					mav.addObject("msg", "관리자가 아닙니다");
					mav.addObject("url", "login");
				}
				
			} else {
				mav = new ModelAndView("redirect:main");
			}

		} catch(Exception e) {
			//e.printStackTrace();
			mav = new ModelAndView("result");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "login");
		}
		
		
		return mav;
		
	}
}
