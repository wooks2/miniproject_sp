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
public class GradeDAO {
	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	
	
	public List<GradeDTO> getMemberGradeList() throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, grade ");
		sql.append("FROM t_grade ");
		
		List<GradeDTO> list = new ArrayList<GradeDTO>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					GradeDTO memberGradeDTO = new GradeDTO();
					
					memberGradeDTO.setGradeNo(rs.getLong("no"));
					memberGradeDTO.setGrade(rs.getString("grade"));
					list.add(memberGradeDTO);
				}
			}
		}
		return list;
	}
}
