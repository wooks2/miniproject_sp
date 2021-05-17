package net.developia.prj.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.developia.prj.models.MemberDTO;

public interface MemberService {
	public MemberDTO getCurrentMemberForNo(Long no) throws SQLException;
	public MemberDTO getCurrentMember(Map<String, String> map) throws SQLException;
	public List<MemberDTO> getMembers() throws SQLException;
	public List<MemberDTO> getMembersForGradeNo(Long no) throws SQLException;
	public void deleteMember(long no) throws Exception;
	public boolean checkID(String str) throws Exception;
}
