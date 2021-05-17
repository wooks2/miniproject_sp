package net.developia.prj.models;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface MemberDAO {

	MemberDTO getCurrentMember(Map<String, String> map) throws SQLException;

	MemberDTO getCurrentMemberForCF(Long no) throws SQLException;

	List<MemberDTO> getMembers() throws SQLException;

	List<MemberDTO> getMembersForGradeNo(Long no) throws SQLException;

	int deleteMember(long no) throws SQLException;

	int checkID(String str) throws SQLException;

}
