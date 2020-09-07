package com.cisco.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
	private static String clazzName = "";
	
	static {
		ResourceBundle res = ResourceBundle.getBundle("config");
		clazzName = res.getString("DAO");
	}
	public static MobileDao getMobileDao() {
//		return new MobileDaoMySQLImpl();
		try {
			return (MobileDao) Class.forName(clazzName).newInstance();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
