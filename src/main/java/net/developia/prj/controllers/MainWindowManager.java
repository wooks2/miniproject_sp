package net.developia.prj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainWindowManager {

	@RequestMapping(value="/mainManager")
	public ModelAndView viewMainWindow_manager(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		try {
			mav.setViewName("main_manager");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}



