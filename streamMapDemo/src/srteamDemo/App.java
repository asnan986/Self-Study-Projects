package srteamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;


public class App {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		/*
		 * first for(int i : list) {
		 * 
		 * System.out.println("value is "+i); }
		 */
		// second list.forEach(i->System.out.println(i));

		//third method reference
		//list.forEach(System.out::println);
		
		Function<Integer, Integer> function= new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*2;
			}
		};
		
		Stream<Integer> s = list.stream();
		
		Stream<Integer> s1=s.map(function);
		
		BinaryOperator<Integer> operator =new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				
				return t+u;
			}
		};
		
		//int result = (int) s1.reduce(0,operator);
		
		//s1.forEach(System.out::println);
		
		
		//int result=list.stream().map(i->i*2).reduce(0, (i,j)->i+j);
		//System.out.println(list.stream().map(i->i*2).reduce(0, (i,j)->i+j));
		
		System.out.println(list.stream().map(i->i*2).reduce(0, Integer::sum));
		
	}

}
