package net.developia.prj.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.GradeDAO;
import net.developia.prj.models.GradeDTO;
import net.developia.prj.models.MemberDTO;
import net.developia.prj.services.MemberService;

@Controller
public class MemberManager {
	@Autowired private MemberService memberService;
	@Autowired private GradeDAO gradeDAO;
	
	@RequestMapping("/memberManager")
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberManager loaded");
		
		long gradeNo = Long.parseLong(request.getParameter("gradeSelect") == null ? "0" : request.getParameter("gradeSelect"));
		System.out.println(gradeNo);
		List<MemberDTO> memberList = null;
		List<GradeDTO> gradeList = null;
		ModelAndView mav = new ModelAndView();
		
		try {
			gradeList = gradeDAO.getMemberGradeList();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		if(gradeNo == 0) {
			try {
				memberList = memberService.getMembers();
				mav.setViewName("member_manager");
				mav.addObject("memberList", memberList);
				mav.addObject("gradeList", gradeList);
				mav.addObject("selectedGrade", gradeNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				memberList = memberService.getMembersForGradeNo(gradeNo);
				mav.setViewName("member_manager");
				mav.addObject("memberList", memberList);
				mav.addObject("gradeList", gradeList);
				mav.addObject("selectedGrade", gradeNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mav;
	}

	
}
