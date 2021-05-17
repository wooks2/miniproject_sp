package net.developia.prj.controllers;

import java.sql.SQLException;
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
import net.developia.prj.services.ArticleService;

@Controller
public class ArticleManager {
	@Autowired private ArticleService articleService;
	@Autowired private ArticleCFDAO articleCFDAO;

	@RequestMapping(value="/articleManager")
	public ModelAndView viewArticleList_manager(HttpServletRequest request, HttpServletResponse response) {
		
		long cfNo = Long.parseLong(request.getParameter("cfSelect") == null ? "0" : request.getParameter("cfSelect"));
		ModelAndView mav = new ModelAndView();
		List<ArticleDTO> articleList = null;
		List<ArticleCFDTO> cfList = null;
	
		try {
			cfList = articleCFDAO.getArticleCFList();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		if(cfNo == 0) {
			try {
				articleList = articleService.getArticleList();
				mav.setViewName("list_manager");
				mav.addObject("articleList", articleList);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else { 
			try {
				articleList = articleService.getArticleListForCF(cfNo);
				mav.setViewName("list_manager");
				mav.addObject("articleList", articleList);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		mav.addObject("cfList", cfList);
		mav.addObject("selectedCF", cfNo);
		return mav;
	}
}
