package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.developia.prj.models.ArticleDTO;
import net.developia.prj.models.MemberDTO;
import net.developia.prj.services.ArticleService;

@Controller
public class ArticleDetail extends AbstractController {
	
	@Autowired private ArticleService articleService;
	
	@RequestMapping(value="/detail")
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		if(session == null) {
			mav.setViewName("result");
			mav.addObject("msg", "세션이 만료되었습니다");
			mav.addObject("url", "login");
		} else {
			try {
				System.out.println("현재 선택한 게시글 : " + no);
				ArticleDTO articleDTO = articleService.getDetail(no, false);
				MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
				
				System.out.println("글작성자 : " + articleDTO.getWriter());
				System.out.println("현재접속자 : " + memberDTO.getId());
				if(articleDTO.getReadgrade().getGradeNo() <= memberDTO.getGrade().getGradeNo() || 
						articleDTO.getWriter().equals(memberDTO.getId())) {
					articleService.updateReadCount(no);
					mav.setViewName("detail");
					mav.addObject("articleDTO", articleDTO);
				} else {
					mav.setViewName("result");
					mav.addObject("msg", articleDTO.getReadgrade().getGrade() + "이상 등급만 읽을 수 있습니다!!");
					mav.addObject("url", "list");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				mav.setViewName("result");
				mav.addObject("msg", e.getMessage());
				mav.addObject("url", "list");
				return mav;
			}
		}
		
		return mav;
		
	}
}
