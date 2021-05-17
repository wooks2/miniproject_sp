package net.developia.prj.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.ArticleCFDAO;
import net.developia.prj.models.ArticleCFDTO;
import net.developia.prj.models.GradeDAO;
import net.developia.prj.models.GradeDTO;
import net.developia.prj.models.MemberDTO;

@Controller
public class ArticleInsert {

	@Autowired ArticleCFDAO articleCFDAO;
	@Autowired GradeDAO memberGradeDAO;
	
	@RequestMapping(value="/insert")
	public ModelAndView insertArticle(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if(session == null) {
			mav.setViewName("/WEB-INF/view/result.jsp");
			mav.addObject("msg", "세션이 만료되었습니다");
			mav.addObject("url", "login");
		} else {
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
			
			
			List<ArticleCFDTO> cfList = null;
			List<GradeDTO> gradeList = null;
			try {
				cfList= articleCFDAO.getArticleCFList();
				gradeList = memberGradeDAO.getMemberGradeList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.setViewName("insert");
			mav.addObject("memberDTO", memberDTO);
			mav.addObject("cfList", cfList);
			mav.addObject("gradeList", gradeList);
		}
		
		return mav;
	}
}
