package com.niit.LetsChatBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="friendidseq", sequenceName="friend_id_seq")
public class Friend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="friendidseq")
	private int friendId;
	private String loginname;
	private String friendloginname;
	private String status;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFriendloginname() {
		return friendloginname;
	}
	public void setFriendloginname(String friendloginname) {
		this.friendloginname = friendloginname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
