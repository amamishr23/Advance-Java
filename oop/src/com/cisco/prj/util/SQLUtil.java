package com.cisco.prj.util;

import java.lang.reflect.Method;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

public class SQLUtil {
	
	// Product p = new Mobile(120,"iPhone",45000.00,"4g");
	// insert into products values (120, 'iPhone' , 45000.00);
	// String SQL = SQLUtil.insertSQL(p);
	public static String insertSQL(Object obj) {
		StringBuilder builder = new StringBuilder();
		Table t = (Table) obj.getClass().getAnnotation(Table.class);
		if (t != null) {
			builder.append("insert into ");
			builder.append(t.name());
			builder.append(" values (");
			Method[] methods =  obj.getClass().getMethods();
			for (Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column col = m.getAnnotation(Column.class);
					if(col != null) {
						try {
							Object ret = m.invoke(obj);
							if(ret instanceof String) {
								builder.append("'" + ret + "'");
							} else {
								builder.append(ret);
							}
							builder.append(",");
						} catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		return builder.toString();
	}
	
	public static String createSQL(Class clazz) {
		StringBuilder builder = new StringBuilder();
		Table t = (Table) clazz.getAnnotation(Table.class);
		if (t != null) {
			builder.append("create table ");
			builder.append(t.name());
			builder.append("("); // create table products (

			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column col = m.getAnnotation(Column.class);
					if(col != null) {
						builder.append(col.name()); // create table products (PID 
						builder.append(" ");
						builder.append(col.type());
						builder.append(","); // create table products (PID NUMERIC(12) ,
					}
				}
			}
			// create table products (PID NUMRIC(12), PRD_NAME VARACHAR(255),
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
	
		return builder.toString();
	}
}
