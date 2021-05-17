package net.developia.prj.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.ArticleCFDAO;

@Controller
public class ArticleCFAddManager {
	
	@Autowired
	ArticleCFDAO articleCFDAO;

	@RequestMapping(value="/articleCFAddManager")
	public ModelAndView addArticleCF_manager(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String[] addedCF = request.getParameterValues("addedCF");
		try {
			for(String s : addedCF) {
				articleCFDAO.insertArticleCF(s);
			}
			
			mav.setViewName("result");
			mav.addObject("msg", "카테고리가 추가 되었습니다.");
			mav.addObject("url", "articleCFManager");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return mav;
	}

}
