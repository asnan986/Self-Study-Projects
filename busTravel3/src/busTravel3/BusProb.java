package busTravel3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import busTravel3.Passanger;

public class BusProb {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		List<String> list = new ArrayList<String>();

		int seatingCapacity = Integer.parseInt(s.nextLine());

		int noOfStops = Integer.parseInt(s.nextLine());
		int i = 1;
		while (i <= noOfStops) {
			String passengers_stop = s.nextLine();
			list.add(passengers_stop);
			i++;
		}
		String query = s.nextLine();
		System.out.println(BusProb.output(seatingCapacity, noOfStops, list, query));

	}

	public static String output(int capacity, int stops, List<String> listOfInputStrings, String query) {

		int capacitypercent = capacity;

		while (capacitypercent % 4 != 0)
			capacitypercent++;

		String outstring = "";
		List<Passanger> list = new ArrayList<Passanger>();

		int i = 0;
		int nofpassengersinBus = 0;

		while (i < stops) {
			String s = listOfInputStrings.get(i);
			String[] temp = s.split(" ");
			for (String y : temp) {
				boolean isOntheBus = y.charAt(0) == '+' ? true : false;
				nofpassengersinBus += isOntheBus ? 1 : -1;
			}
			System.out.println(nofpassengersinBus);
			float percentage = 0;
			percentage = (nofpassengersinBus) * 100 / (capacitypercent);

			float fare = 0;
			if (percentage <= 25)
				fare = capacity+0.6f * capacity;
			else if (percentage > 25 && percentage < 50)
				fare = 1.3f * capacity;
			else
				fare = capacity;
			for (String x : temp) {
				int passengerId = Integer.parseInt(x.substring(1));
				boolean isOntheBus = x.charAt(0) == '+' ? true : false;

				boolean existing = false;
				for (Passanger p : list)
					if (p.getPassengerId() == passengerId) {
						existing = true;
						p.setOnTheBus(isOntheBus);
						p.setNoOftimesIn(isOntheBus ? p.getNoOftimesIn() + 1 : p.getNoOftimesIn());
						p.setNoOftimesOut(isOntheBus ? p.getNoOftimesOut() : p.getNoOftimesOut() + 1);
						p.addFare(isOntheBus ? fare : 0);
					}

				if (!existing)
					list.add(new Passanger(passengerId, isOntheBus, isOntheBus ? fare : 0, isOntheBus ? 1 : 0,
							isOntheBus ? 0 : 1));
			}
			i++;

		}

		String[] str = query.split(",");

		int qur = Integer.parseInt(str[0]);
		int id = 0;
		if (str.length > 1)
			id = Integer.parseInt(str[1]);

		switch (qur) {
		case 1:
			int in = 0;
			int out = 0;
			for (Passanger p : list) {
				in += p.getNoOftimesIn();
				out += p.getNoOftimesOut();

			}
			outstring = in + " passengers got on the bus and " + out + " passengers got out of the bus";
			break;
		case 2:
			float fare1 = capacity+0.6f*capacity;
			float fare2 = 1.3f * capacity;
			int noOffare1 = 0, noOffare2 = 0, noOffaren = 0;
			for (Passanger p : list)
				for (Float f : p.getFare()) {
					if (f == fare1)
						noOffare1++;
					else if (f == fare2)
						noOffare2++;
					else if (f == capacity)
						noOffaren++;
				}
			// fare1=28.8f;
			outstring = noOffare1 + " passengers traveled with a fare of " + fare1 + ", " + noOffare2
					+ " passengers traveled with a fare of " + fare2 + ", " + noOffaren
					+ " passengers traveled with a fare of " + (float) capacity;

			break;
		case 3:
			float faresum = 0;
			for (Passanger p : list)
				if (p.getPassengerId() == id)
					for (float f : p.getFareList())
						faresum += f;

			outstring = "Passenger " + id + " spent a total fare of " + faresum;
			break;
		case 4:
			int sum = 0;
			for (Passanger p : list) {
				if (p.getPassengerId() == id) {
					sum = p.getNoOftimesIn();
					break;

				}
			}
			outstring = "Passenger " + id + " has got on the bus for " + sum + " times";
			break;
		case 5:
			boolean isInside = false;
			for (Passanger p : list) {
				if (p.getPassengerId() == id && p.isOnTheBus())
					isInside = true;
			}
			String status = isInside ? "inside" : "not inside";

			outstring = "Passenger " + id + " was " + status + " the bus at the end of the trip";
			break;
		}
		// Write your code herest
		list.forEach(v -> System.out.println(v));
		return outstring;
	}
}
