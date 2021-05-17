package net.developia.prj.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.developia.prj.models.ArticleDTO;

public interface ArticleService {

	void insertArticle(Map<String, Object> map) throws SQLException;

	List<ArticleDTO> getArticleList() throws SQLException;
	List<ArticleDTO> getArticleListForCF(long cfNo) throws SQLException;
	List<ArticleDTO> getNoneArticleList() throws SQLException;

	ArticleDTO getDetail(long no, boolean updateReadCount) throws Exception;

	ArticleDTO getDetail(long no) throws Exception;

	void updateArticle(ArticleDTO articleDTO) throws Exception;

	void deleteArticle(ArticleDTO articeDTO) throws Exception;

	void deleteArticleForNo(long articleNo) throws Exception;

	void updateReadCount(long no) throws Exception;

	
}
