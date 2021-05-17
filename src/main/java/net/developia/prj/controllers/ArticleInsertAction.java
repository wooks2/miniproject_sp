package net.developia.prj.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.prj.models.ArticleCFDTO;
import net.developia.prj.models.ArticleDTO;
import net.developia.prj.models.GradeDTO;
import net.developia.prj.models.MemberDTO;
import net.developia.prj.services.ArticleService;

@Controller
public class ArticleInsertAction {
	
	@Autowired ArticleService articleService;
	
	@RequestMapping(value="/insertAction")
	public ModelAndView insertArticleAction(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		Long member_no = Long.parseLong(request.getParameter("member_no"));
		Long grade_no = Long.parseLong(request.getParameter("grade"));
		Long cf = Long.parseLong(request.getParameter("cf"));
		
		
		ArticleDTO articleDTO = new ArticleDTO();
		MemberDTO memberDTO = new MemberDTO();
		ArticleCFDTO cfDTO = new ArticleCFDTO();
		GradeDTO gradeDTO = new GradeDTO();
		
		cfDTO.setArticleCFNo(cf);
		gradeDTO.setGradeNo(grade_no);
		
		articleDTO.setTitle(title);
		articleDTO.setWriter(name);
		articleDTO.setContent(content);
		articleDTO.setBoardCF(cfDTO);
		articleDTO.setReadgrade(gradeDTO);
		
		memberDTO.setMemberNo(member_no);
		
		ModelAndView mav = new ModelAndView();
		try {
			System.out.println("insert 시작");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("articleDTO", articleDTO);
			map.put("memberDTO", memberDTO);
			articleService.insertArticle(map);
			System.out.println("insert 완료");
			mav.setViewName("redirect:list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("msg", "글 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		

		return mav;
	}

}
