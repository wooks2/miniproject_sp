package net.developia.prj.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.prj.services.MemberService;

@Slf4j
@Controller
@RequestMapping("/register")
public class Register {
	@Autowired private MemberService memberService;
	
	
	@RequestMapping("")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("register");
	}
	
	@RequestMapping(value="/")
	public ModelAndView login2(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("register");
	}
	
	@PostMapping(value="/checkID")
	@ResponseBody
	public String checkID(@RequestParam Map<String, Object> m) {
		log.info("[중복체크]: 받아온 ID : " + m);
		boolean checked = false;
		try {
			log.info("id는? : " + m.get("id"));
			checked = memberService.checkID((String)m.get("id"));
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		
		if(checked) {
			log.info("[중복체크] : 결과 : sucees");
			return "success";
		} else {
			log.info("[중복체크] : 결과 : fail");
			return "fail";
		}
 	}
}
