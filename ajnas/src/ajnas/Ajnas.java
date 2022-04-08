package ajnas;

public class Ajnas {

	public static void main(String[] args) {


		Student s1= new Aided();
		Student s2= new SelfFinance();
		
		String s1Test="100 5,100 5,53 5,76 3|0,100,5";
		String s2Test="100 5,100 5,100 5,100 5|1,100,5|0,100,5";
		
		System.out.println(s1.function(s2Test));

	}

}
