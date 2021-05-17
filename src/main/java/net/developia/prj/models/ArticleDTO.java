package net.developia.prj.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;

@Data
public class ArticleDTO implements Serializable{
	
	private ArticleCFDTO boardCF;
	private long articleNo;
	private String title;
	private String content;
	private Date regdate;
	private long readcount;
	private String writer;
	private GradeDTO readgrade;
}
