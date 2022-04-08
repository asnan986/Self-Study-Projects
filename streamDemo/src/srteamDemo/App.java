package srteamDemo;

import java.util.Arrays;
import java.util.List;

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
	}

}
