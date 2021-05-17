package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		if(session == null) { 
			mav.setViewName("result");
			mav.addObject("msg", "세션이 만료되었습니다");
			mav.addObject("url", "login");
			return null;
		} else {
			return mav;
		}
	}

}
