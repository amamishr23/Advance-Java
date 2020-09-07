package com.cisco.prj.dao;

public class MobileDaoFactory {
	public static MobileDao getMobileDao() {
		return new MobileDaoMySQLImpl();
	}
}
