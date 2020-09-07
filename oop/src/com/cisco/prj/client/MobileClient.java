package com.cisco.prj.client;

import com.cisco.prj.dao.MobileDao;
import com.cisco.prj.dao.MobileDaoFactory;
import com.cisco.prj.dao.MobileDaoFileImpl;
import com.cisco.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
		Mobile m = new Mobile(33, "iPhone 11", 89000.00, "4G");
//		MobileDao mobileDao = new MobileDao(); Can't instantiate a interface
//		MobileDao mobileDao = new MobileDaoFileImpl(); // switch between strategies

		MobileDao mobileDao = MobileDaoFactory.getMobileDao();
		mobileDao.addMobile(m);
	}

}
