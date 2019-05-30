package com.adobe.prj.client;

@FunctionalInterface
interface Computation {
	int compute(int x, int y);
}

public class LambdaExample {

	public static void main(String[] args) {
		// Anonymous class
		Computation c1 = new Computation() {

			@Override
			public int compute(int x, int y) {
				return x  + y;
			}
		};
		
		System.out.println(c1.compute(4, 5));
		
		// Lambda Expression
		Computation c2 = (int x, int y) -> {
			return x  + y;
		};
		
		System.out.println(c2.compute(6, 1));
		

		// Lambda Expression
		Computation c3 = (x, y) -> {
			return x  + y;
		};
		
		System.out.println(c3.compute(6, 1));
		
		Computation c4 = (x,y) -> x - y;
		System.out.println(c4.compute(66, 12));
	}

}
