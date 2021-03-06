package com.niit.LetsChatBackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="blogcommidseq", sequenceName="blogcomm_id_seq")
public class BlogComment {
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blogcommidseq")
		private int commentId;
		private String commentText;
		private String loginname;
		private int blogId;
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
		private Date commentDate;
		public int getCommentId() {
			return commentId;
		}
		public void setCommentId(int commentId) {
			this.commentId = commentId;
		}
		public String getCommentText() {
			return commentText;
		}
		public void setCommentText(String commentText) {
			this.commentText = commentText;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public int getBlogId() {
			return blogId;
		}
		public void setBlogId(int blogId) {
			this.blogId = blogId;
		}
		public Date getCommentDate() {
			return commentDate;
		}
		public void setCommentDate(Date commentDate) {
			this.commentDate = commentDate;
		}
		
	}


