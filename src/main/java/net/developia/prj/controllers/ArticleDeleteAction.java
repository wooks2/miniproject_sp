package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.ArticleDTO;
import net.developia.prj.models.MemberDTO;
import net.developia.prj.services.ArticleService;
import net.developia.prj.services.MemberService;

@Controller
public class ArticleDeleteAction {
	@Autowired ArticleService articleService;
	@Autowired MemberService memberService;

	@RequestMapping(value="/deleteAction")
	public ModelAndView deleteArticleAction(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		Long articleNo = Long.parseLong(request.getParameter("no"));
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null) { 
			mav.setViewName("result");
			mav.addObject("msg", "세션이 만료되었습니다. 로그인하세요");
			mav.addObject("url", "login");
			return mav;
		} else {
			ArticleDTO articleDTO = null;
			MemberDTO memberDTO = null;
			try {
				articleDTO = articleService.getDetail(articleNo);
				memberDTO = (MemberDTO)session.getAttribute("memberDTO");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if(memberDTO.getGrade().getGrade().equals("admin") 
					|| memberDTO.getId().equals(articleDTO.getWriter()) && memberDTO.getPw().equals(password)) {
				try {
					articleService.deleteArticle(articleDTO);
					mav.setViewName("result");
					mav.addObject("msg", "게시물이 삭제되었습니다.");
					mav.addObject("url", "list");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				mav.setViewName("result");
				mav.addObject("msg", "자신의 글이 아니거나 비밀번호가 틀렸습니다");
				mav.addObject("url", "list");
			}
		}
		
	
		
		
		

		
		return mav;
	}
}
