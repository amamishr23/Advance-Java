package com.cisco.prj.client;

interface Computation {
	int compute(int x, int y);
}
public class InterfaceExample {

	public static void main(String[] args) {
		// Anonymous class
		Computation c1 = new Computation( ) {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
			 
		};
		
		System.out.println(c1.compute(5, 7)); 
		// If the interface is @FunctionalInterface we can write lambda expr
		Computation c2 = (int x, int y) -> {
			return x * y;
		};
		
		System.out.println(c2.compute(5, 7)); 
		// x and y Type inference
		Computation c3 = (x,y) -> x - y; 
		System.out.println(c3.compute(50, 5));
	}

}
