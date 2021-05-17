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

@Controller
public class ArticleCFManager {
	
	@Autowired
	ArticleCFDAO articleCFDAO;
	
	@RequestMapping(value="/articleCFManager")
	public ModelAndView viewArticleCF(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		try {
			List<ArticleCFDTO> cfList = articleCFDAO.getArticleCFList();
			mav.setViewName("list_cf_manager");
			mav.addObject("cfList", cfList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return mav;
	}

}
