package net.developia.prj.models;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;
public interface ArticleDAO {

	void insertArticle(@RequestParam Map<String, Object> map) throws SQLException;

	List<ArticleDTO> getArticleList() throws SQLException;
	List<ArticleDTO> getArticleListForCF(long cfNo) throws SQLException;
	List<ArticleDTO> getNoneArticleList() throws SQLException;

	void updateReadCount(long no) throws SQLException;

	ArticleDTO getDetail(long no) throws SQLException;

	int updateArticle(ArticleDTO articleDTO) throws SQLException;

	int deleteArticle(ArticleDTO articleDTO) throws SQLException;

	int deleteArticleForNo(long articleNo) throws SQLException; 


}
