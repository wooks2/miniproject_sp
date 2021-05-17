package net.developia.prj.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.developia.prj.models.ArticleDAO;
import net.developia.prj.models.ArticleDTO;

@Repository
public class ArticleServiceImpl implements ArticleService {
	@Autowired 
	@Qualifier(value = "articleDAO")
	private ArticleDAO articleDAO;
	public ArticleServiceImpl() {
	}
	
	
	@Override
	public void insertArticle(Map<String, Object> map) throws SQLException {
		articleDAO.insertArticle(map);
		
	}
	
	@Override
	public List<ArticleDTO> getArticleList() throws SQLException {
		return articleDAO.getArticleList();
		
	}
	
	@Override
	public List<ArticleDTO> getArticleListForCF(long cfNo) throws SQLException {
		return articleDAO.getArticleListForCF(cfNo);
	}

	@Override
	public List<ArticleDTO> getNoneArticleList() throws SQLException {
		return articleDAO.getNoneArticleList();
	}
	
	@Override
	public ArticleDTO getDetail(long no, boolean updateReadCount) throws Exception {
		try {
			if(updateReadCount) articleDAO.updateReadCount(no);
			
			ArticleDTO articleDTO = articleDAO.getDetail(no);
			if(articleDTO == null) {
				throw new RuntimeException("상세보기 실패");
			}
			
			return articleDTO;
		} finally {}
	}

	@Override
	public ArticleDTO getDetail(long no) throws Exception {
		return getDetail(no, true);
	}

	@Override
	public void updateArticle(ArticleDTO articleDTO) throws Exception {
		if(articleDAO.updateArticle(articleDTO) == 0) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
		
	}

	@Override
	public void deleteArticle(ArticleDTO articleDTO) throws Exception {
		if(articleDAO.deleteArticle(articleDTO) != 1) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
		
	}

	@Override
	public void deleteArticleForNo(long articleNo) throws Exception {
		if(articleDAO.deleteArticleForNo(articleNo) != 1) {
			throw new RuntimeException("글이 없거나 비밀번호가 틀립니다.");
		}
		
	}

	@Override
	public void updateReadCount(long no) throws Exception {
		articleDAO.updateReadCount(no);
		
	}



}
