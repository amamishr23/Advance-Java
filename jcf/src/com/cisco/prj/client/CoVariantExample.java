package com.cisco.prj.client;

import java.util.ArrayList;
import java.util.List;

public class CoVariantExample {

	public static void main(String[] args) {
//		Object[] elems = new String[2]; // Co-variant
//		elems[0] = new String("Hello");
//		elems[1] = new Date(); //ArrayStoreException
		
		List<String> list = new ArrayList<String>(); // collections are not co-variant
		
		list.add("A");
		list.add("B");
		
		List<Integer> il = new ArrayList<Integer>();
		
		il.add(33);
		il.add(22);
		il.add(12);
		
		print(list);
		print(il);
		
		List<String> destStr  = new ArrayList<>();
		List<Integer> destInt = new ArrayList<>();
		
		copy(destStr, list);
		copy(destInt, il);
	}
	//PECS ==> Producer Extends Consumer Super
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for(T o : src) {
			dest.add(o);
		}
	}
	
	public static void print(List<?> list) {
		for(Object o : list) {
			System.out.println(o);
		}
	}

}
