package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.ArticleCFDAO;

@Controller
public class ArticleCFDeleteManager {
	
	@Autowired
	ArticleCFDAO articleCFDAO;
	
	@RequestMapping(value="/articleCFDeleteManager")
	public ModelAndView deleteArticleCF_manager(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String[] deletedCF = request.getParameterValues("selectedCF");
		
		for(String s : deletedCF) {
			//articleCFDAO.deleteArticleCF(Long.parseLong(s));
			System.out.println("deletedCF : " + s);
		}
		
		/*try {
			for(String s : deletedCF) {
				articleCFDAO.deleteArticleCF(Long.parseLong(s));
		
			}
			
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "카테고리가 삭제 되었습니다.");
			mav.addObject("url", "articleCFManager");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
		return mav;
	}

}

