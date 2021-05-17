package net.developia.prj.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.developia.prj.models.MemberDAO;
import net.developia.prj.models.MemberDTO;

@Repository
public class MemberServiceImpl implements MemberService {
	@Autowired 
	@Qualifier(value="memberDAO")
	private MemberDAO memberDAO;
	
	@Override
	public MemberDTO getCurrentMember(Map<String, String> map) throws SQLException {
		MemberDTO memberDTO = memberDAO.getCurrentMember(map);
		if(memberDTO == null) {
			throw new RuntimeException("로그인 정보가 틀렸습니다");
		}
		return memberDTO;
	}

	@Override
	public MemberDTO getCurrentMemberForNo(Long no) throws SQLException {
		MemberDTO memberDTO = memberDAO.getCurrentMemberForCF(no);
		if(memberDTO == null) {
			throw new RuntimeException("해당 회원이 없습니다");
		}
		return memberDTO;
	}

	@Override
	public List<MemberDTO> getMembers() throws SQLException {
		List<MemberDTO> memberList = memberDAO.getMembers();
		return memberList;
	}

	@Override
	public List<MemberDTO> getMembersForGradeNo(Long no) throws SQLException {
		List<MemberDTO> memberList = memberDAO.getMembersForGradeNo(no);
		return memberList;
	}

	@Override
	public void deleteMember(long no) throws Exception {
		if(memberDAO.deleteMember(no) != 1) {
			throw new RuntimeException("탈퇴실패!!");
		}
		
	}

	@Override
	public boolean checkID(String str) throws Exception {
		if(memberDAO.checkID(str) == 0) {
			return true;
		} else {
			return false;
		}
	}

	
}
