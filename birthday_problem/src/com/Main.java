package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//
//		int people = s.nextInt();
//		int sim = s.nextInt();
//		System.out.println(calculate(people, sim));
		//System.out.println("Owner: John Adams;"=="Owner: John Adams;");
		
		A a = new B();
		
		a.methodA();

	}

	private static double calculate(int people, int sim) {

		//Set<Integer> list = new HashSet<Integer>();

		//ArrayList<String> a= new ArrayList<String>;
		boolean result = false;
		System.out.println(result);
		System.out.println("hello kids"=="kids");
		
		Integer values[]= new Integer[5];
		
		;
		
		System.out.println(Arrays.toString(values));;
		
		return 0;
		
	}

}

class A{
	
	public void methodA() {
		System.out.println("parent");
	}
}
class B extends A{
	public void methodA() {
		System.out.println("child");
	}
}