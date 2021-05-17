package net.developia.prj.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.prj.models.ArticleCFDAO;
import net.developia.prj.models.ArticleCFDTO;

@Slf4j
@Controller
public class MainWindow {
	
	@Autowired private ArticleCFDAO articleCFDAO;
	
	@RequestMapping(value="/main")
	public ModelAndView viewMainWindow(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		try {
			
			log.info("게시판 불러오기 시작...");
			List<ArticleCFDTO> cfList = articleCFDAO.getArticleCFList();
			log.info("게시판 불러오기 완료...");
			
			mav.setViewName("main");
			mav.addObject("cfList", cfList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mav;
	}
}



