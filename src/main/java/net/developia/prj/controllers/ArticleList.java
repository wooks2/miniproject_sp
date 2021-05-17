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
import net.developia.prj.models.ArticleDTO;
import net.developia.prj.services.ArticleService;

@Slf4j
@Controller
public class ArticleList {
	@Autowired private ArticleService articleService;
	// private static Logger logger = Logger.getLogger(ArticleList.class);
	//private static Logger logger = LoggerFactory.getLogger(ArticleList.class);

	@RequestMapping(value="/list")
	public ModelAndView viewArticleList(HttpServletRequest request, HttpServletResponse response) {
		long cfNo = Long.parseLong(request.getParameter("cf") == null ? "0" : request.getParameter("cf"));

		List<ArticleDTO> list = null;
		ModelAndView mav = new ModelAndView();
		// logger.info("slf4j test");
		if (cfNo == 0) {
			try {
			
				log.info("게시글 불러오기 시작...");
				list = articleService.getArticleList();
				log.info("게시글 불러오기 완료...");
				
				for (ArticleDTO dto : list) { 
					System.out.println(dto);
				}
				mav.setViewName("list");
				mav.addObject("list", list);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				list = articleService.getArticleListForCF(cfNo);
				/*
				 * for (ArticleDTO dto : list) { System.out.println(dto); break; }
				 */
				mav.setViewName("list");
				mav.addObject("list", list);

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return mav;
	}
}
