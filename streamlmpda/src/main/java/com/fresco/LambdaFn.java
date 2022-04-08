package com.fresco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LambdaFn {

	public List<Long> functionalProgtamming(List<String> listOfIntegers) {

		List<Long> outputList = new ArrayList<Long>();

		listOfIntegers.stream().map(i -> {
			long j = Long.parseLong(i);
			return (long) Math.pow(j, 2);})
				.filter(i -> {
			long right = 0, left = 0;
			long sqrt = (long) Math.sqrt(i);
			long check = sqrt;
			long itemp = i;
			int k = 0, j = 0;
			while (itemp > 0) {
				if (check > 0) {
					right = (long) (right + (itemp % 10) * Math.pow(10, k));
					k++;
				} else {
					left = (long) (left + (itemp % 10) * Math.pow(10, j));
					j++;
				}
				check = check / 10;
				itemp = itemp / 10;

			}
			if ((right + left) == sqrt)
				return true;
			return false;
		}).forEach(i -> outputList.add((long) Math.sqrt(i)));


		return outputList;
	}

}
