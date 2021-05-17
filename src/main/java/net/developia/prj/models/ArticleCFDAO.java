package net.developia.prj.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleCFDAO {
	@Autowired private DataSource dataSource;	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	public List<ArticleCFDTO> getArticleCFList() throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, board_name ");
		sql.append("FROM t_board_cf ");
		
		List<ArticleCFDTO> list = new ArrayList<ArticleCFDTO>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					ArticleCFDTO articleCFDTO = new ArticleCFDTO();
					
					articleCFDTO.setArticleCFNo(rs.getLong("no"));
					articleCFDTO.setCf_name(rs.getString("board_name"));
					list.add(articleCFDTO);
				}
			}
		}
		return list;
	}
	public void insertArticleCF(String cfName) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO t_board_cf(no, board_name) ");
		sql.append("VALUES(t_board_cf_seq.NEXTVAL, ?) ");
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setString(1, cfName);
			ps.executeUpdate();
			}
		}
	public int deleteArticleCF(long s) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM t_board_cf ");
		sql.append("WHERE no=? ");
		int result = 0;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setLong(1, s);
			result = ps.executeUpdate();
			
		}
		
		return result;
		
	}
}
