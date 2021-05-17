package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.services.ArticleService;

@Controller
public class ArticleDeleteManager {
	
	@Autowired ArticleService articleService;
	
	@RequestMapping(value="/articleDeleteManager")
	public ModelAndView deleteArticle_manager(HttpServletRequest request, HttpServletResponse response) {
		String[] checkedArticle = request.getParameterValues("articleNo");
		String selectedCF = request.getParameter("cfSelect") == null ? "0" : request.getParameter("gradeSelect");
		ModelAndView mav = new ModelAndView();
		
		System.out.println("선택된 게시글 : " + checkedArticle);
		for(int idx=0; idx<checkedArticle.length; idx++) {
			try {
				articleService.deleteArticleForNo(Long.parseLong(checkedArticle[idx]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mav.setViewName("result");
		mav.addObject("msg", "게시물이 삭제되었습니다.");
		mav.addObject("url", "memberManager?gradeSelect=" + selectedCF);
		return mav;
	}
}

