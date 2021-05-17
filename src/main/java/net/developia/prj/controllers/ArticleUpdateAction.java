package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.ArticleCFDTO;
import net.developia.prj.models.ArticleDTO;
import net.developia.prj.models.GradeDTO;
import net.developia.prj.models.MemberDTO;
import net.developia.prj.services.ArticleService;

@Controller
public class ArticleUpdateAction {
	@Autowired ArticleService articleService;
	
	@RequestMapping(value="/updateAction")
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if(session == null) {
			mav.setViewName("result");
			mav.addObject("msg", "세션이 만료되었습니다");
			mav.addObject("url", "login");
		} else {
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
			System.out.println(memberDTO.getPw());
			long no = Long.parseLong(request.getParameter("no"));
			
			long grade_no = Long.parseLong(request.getParameter("gradeSelect"));
			String grade_name = request.getParameter("gradeTextId");
			long cf_no = Long.parseLong(request.getParameter("cfSelect"));
			String cf_name = request.getParameter("cfTextId");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String pw = request.getParameter("password");
			System.out.println("받아오는pw : " + pw);
			String content = request.getParameter("content");
			
			ArticleDTO articleDTO = new ArticleDTO();
			ArticleCFDTO articleCFDTO = new ArticleCFDTO();
			GradeDTO gradeDTO = new GradeDTO();
			
			articleCFDTO.setArticleCFNo(cf_no);
			articleCFDTO.setCf_name(cf_name);
			gradeDTO.setGradeNo(grade_no);
			gradeDTO.setGrade(grade_name);
			
			articleDTO.setArticleNo(no);
			articleDTO.setTitle(title);
			articleDTO.setContent(content);
			articleDTO.setBoardCF(articleCFDTO);
			articleDTO.setReadgrade(gradeDTO);
			
			System.out.println(memberDTO.getId());
			System.out.println("받아오는 id : " + writer);
			if(memberDTO.getGrade().getGrade().equals("admin") 
				|| (memberDTO.getId().equals(writer) && memberDTO.getPw().equals(pw))) {
				try {
					articleService.updateArticle(articleDTO);
					mav.setViewName("result");
					mav.addObject("msg", "게시물이 수정되었습니다.");
					mav.addObject("url", "detail?no=" + articleDTO.getArticleNo());
				} catch (Exception e) {
					e.printStackTrace();
					mav.setViewName("result");
					mav.addObject("msg", "글이 없거나 비밀번호가 틀립니다.");
					mav.addObject("url", "javascript:history.back();");
				}
			} else {
				mav.setViewName("result");
				mav.addObject("msg", "나의글이 아니거나 비밀번호가 틀렸습니다");
				mav.addObject("url", "detail?no=" + articleDTO.getArticleNo());
			}
		}
		
		

		return mav;
	}

}
