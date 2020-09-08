package com.cisco.prj.entity;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

@Table(name="mobile")
public class Mobile extends Product {
	private String connectivity;

	public Mobile() {
	}

	public Mobile(int id, String name, double price, String connectivity) {
		super(id, name, price);
		this.connectivity = connectivity;
	}
	
	@Column(name="CONNECT")
	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		if("3G".equals(connectivity) && getPrice() > 5000) {
			return true;
		} else if ("4G".equals(connectivity) && getPrice() > 15000) {
			return true;
		}
		return false;
	}

	 
}
