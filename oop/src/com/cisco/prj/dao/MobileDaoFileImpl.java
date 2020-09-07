package com.cisco.prj.dao;

import com.cisco.prj.entity.Mobile;

public class MobileDaoFileImpl implements MobileDao {

	@Override
	public void addMobile(Mobile m) {
		System.out.println("stored in file System!!!");
	}

}

