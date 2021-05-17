package net.developia.prj.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;

@Data
public class MemberDTO implements Serializable {
	private long memberNo;
	private String name;
	private String id;
	private String pw;
	private String email;
	private String gender;
	private GradeDTO grade;
	private Date joindate;
	private String imgpath;
	private boolean admin = false;
	public void setPassword(String pw) {
		this.pw = DigestUtils.sha3_512Hex(pw);
	}
}