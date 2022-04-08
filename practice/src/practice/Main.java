package practice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * B bclass= new A(); A aclass= (A)bclass; System.out.println(bclass.a);
		 * System.out.println(aclass.a); bclass.Show();
		 */
		
//		B b = new B();
//		A a= (A)b;
//		a.Show();
		
		Scanner s = new Scanner(System.in);
	     
		int i = Integer.parseInt(s.nextLine());
		int rev = 0;
		while(i>0){
			rev=rev*10+i%10;
			i=i/10;
		}
		System.out.println(rev);
		
		
		
		
	}

}


class AbcImpl implements Abc{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("hai");
	}

	@Override
	public void hello() {
		System.out.println("hello");
		
	}
	
}

interface Abc extends Bcd{
	void show();
}
interface Bcd{
	void show();
	void hello();
}


class A extends B{
	int a =5;
	
	@Override
	void Show() {
		System.out.println("in child");
	}
}

class B{
	int a=6;
	void Show() {
		System.out.println("in parent");
	}
}