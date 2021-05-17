package net.developia.prj.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.ArticleCFDAO;
import net.developia.prj.models.ArticleCFDTO;
import net.developia.prj.models.ArticleDTO;
import net.developia.prj.models.GradeDAO;
import net.developia.prj.models.GradeDTO;
import net.developia.prj.services.ArticleService;

@Controller
public class ArticleUpdate {
	@Autowired private ArticleService articleService;
	@Autowired ArticleCFDAO articleCFDAO;
	@Autowired GradeDAO gradeDAO;
	
	@RequestMapping(value="/update")
	public ModelAndView updateArticle(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		ModelAndView mav = new ModelAndView();
		try {
			ArticleDTO articleDTO = articleService.getDetail(no, false);
	
			
			
			List<ArticleCFDTO> cfList = articleCFDAO.getArticleCFList();
			List<GradeDTO> gradeList = gradeDAO.getMemberGradeList();
			
			mav.setViewName("update");
			mav.addObject("cfList", cfList);
			mav.addObject("gradeList", gradeList);
			mav.addObject("articleDTO", articleDTO);
			return mav; 
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}

}
