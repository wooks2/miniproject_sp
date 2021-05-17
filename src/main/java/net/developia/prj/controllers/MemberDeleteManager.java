package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.services.MemberService;

@Controller
public class MemberDeleteManager {
	@Autowired private MemberService memberService;
	
	@RequestMapping(value="/memberDeleteManager")
	public ModelAndView deleteMember_manager(HttpServletRequest request, HttpServletResponse response) {
		String[] checkedMember = request.getParameterValues("memberNo");
		String selectedGrade = request.getParameter("gradeSelect") == null 
				? "0" : request.getParameter("gradeSelect");
		ModelAndView mav = new ModelAndView();
		System.out.println("체크된 회원번호: " + checkedMember);
		for(int idx=0; idx<checkedMember.length; idx++) {
			try {
				memberService.deleteMember(Long.parseLong(checkedMember[idx]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("result");
		mav.addObject("msg", "회원이 삭제되었습니다.");
		mav.addObject("url", "memberManager?gradeSelect=" + selectedGrade);
		return mav;
	}

}
