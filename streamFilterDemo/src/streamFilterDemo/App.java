package streamFilterDemo;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(5, 2, 4, 10, 15, 75);

		int result = 0;
		for (int i : list) {

			result = i % 5 == 0 ? result + i : result;
		}

		// System.out.println(result);
		
		result=list.stream().filter(i->i%5==0).reduce(0, (i,j)->i+j);
		
		System.out.println(result);
	}

}
