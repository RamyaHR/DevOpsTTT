package com.niit.LetsChatBackend.model;

import java.util.Date;

public class OutputMessage extends Message{

	private Date messageTime;
	
	public OutputMessage(Message original, Date msgTime)
	{
		this.setMessageId(original.getMessageId());
		this.setMessage(original.getMessage());
		messageTime = msgTime;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	
	
}
