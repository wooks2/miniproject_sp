package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleDelete {

	@RequestMapping(value="/delete")
	public ModelAndView deleteArticle(HttpServletRequest request, HttpServletResponse response) {
		long no = Long.parseLong(request.getParameter("no"));
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		if(session == null) {
			mav.setViewName("result");
			mav.addObject("msg", "세션이 만료되었습니다");
			mav.addObject("url", "login");
		} else {
			try {
				return new ModelAndView("delete", "no", no);
			} catch (Exception e) {
				e.printStackTrace();
				mav.setViewName("result");
				mav.addObject("msg", e.getMessage());
				mav.addObject("url", "list");
				
			}
		}
		return mav;
	}
}
