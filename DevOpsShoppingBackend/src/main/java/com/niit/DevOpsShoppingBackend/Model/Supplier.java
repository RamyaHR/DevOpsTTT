package com.niit.DevOpsShoppingBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier{

	@Id
	private String supId;
	private String supName;
	
	public Supplier()
	{
		this.supId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	
	
}
