package busTravel;

import java.util.List;

public class PassengerDetails {

	public void query1(List<Passenger> list) {

		int in = 0;
		int out = 0;
		for (Passenger p : list) {
			if (p.getNoOftimesIn()>0)
				in++;
			if(p.getNoOftimesOut()>0)
				out++;

			
		}
		System.out.println("No of passengers got on " + in + ". No of passengers out " + out);

	}

	public void query2(List<Passenger> list, int seatingCapacity) {
		float fare1 = 1.6f * seatingCapacity;
		float fare2 = 1.3f * seatingCapacity;
		int noOffare1 = 0, noOffare2 = 0, noOffaren = 0;
		for (Passenger p : list)
			for (Float f : p.getFare()) {
				if (f == fare1)
					noOffare1++;
				else if (f == fare2)
					noOffare2++;
				else if(f==seatingCapacity)
					noOffaren++;
			}

		System.out.println(noOffare1 + " is travelling with " + fare1 + " . " + noOffare2 + " is travelling with fare "
				+ fare1 + " . " + noOffaren + " is travelling with fare " + seatingCapacity + " .");

	}

	public void query3(List<Passenger> list, int id) {
		float faresum = 0;
		for (Passenger p : list)
			if (p.getPassengerId() == id)
				for (float f : p.getFareList())
					faresum += f;

		System.out.println("fare charge of passenger with id " + id + " is " + faresum);
	}

	public void query4(List<Passenger> list, int id) {

		int sum = 0;
		for (Passenger p : list) {
			if (p.getPassengerId() == id) {
				sum=p.getNoOftimesIn();
				break;

			}
		}
		System.out.println("passenger with id " + id + " entered the bus for " + sum + " times");
	}

	public void query5(List<Passenger> list, int id) {

		boolean isInside = false;
		for (Passenger p : list) {
			if (p.getPassengerId() == id && p.isOnTheBus())
				isInside = true;
		}
		String status = isInside ? "inside" : "not inside";

		System.out.println("the passenger with id " + id + " is " + status + " the bus");
	}
}
