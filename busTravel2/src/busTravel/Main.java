package busTravel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		PassengerDetails details = new PassengerDetails();

		List<Passenger> list = new ArrayList<Passenger>();

		int seatingCapacity = Integer.parseInt(s.nextLine());

		int noOfStops = Integer.parseInt(s.nextLine());
		int i = 1;
		int nofpassengersinBus = 0;

		while (i <= noOfStops) {
			String pid_stop = s.nextLine();
			String[] temp = pid_stop.split(" ");
			for (String y : temp) {
				boolean isOntheBus = y.charAt(0) == '+' ? true : false;
				nofpassengersinBus += isOntheBus ? 1 : -1;
			}

			float percentage = 0;
			percentage = (nofpassengersinBus) * 100 / (seatingCapacity);

			float fare = 0;
			if (percentage <= 25)
				fare = 1.6f * seatingCapacity;
			else if (percentage > 25 && percentage <= 50)
				fare = 1.3f * seatingCapacity;
			else
				fare = seatingCapacity;
			for (String x : temp) {
				int passengerId = Integer.parseInt(x.substring(1));
				boolean isOntheBus = x.charAt(0) == '+' ? true : false;
				boolean existing=false;
				for(Passenger p:list)
					if(p.getPassengerId()==passengerId) {
						existing=true;
						p.setOnTheBus(isOntheBus);
						p.setNoOftimesIn(isOntheBus?p.getNoOftimesIn()+1:p.getNoOftimesIn());
						p.setNoOftimesOut(isOntheBus?p.getNoOftimesOut():p.getNoOftimesOut()+1);
						p.addFare(isOntheBus ? fare : 0);
					}
					
   
				if(!existing)
					list.add(new Passenger(passengerId, isOntheBus, isOntheBus ? fare : 0,isOntheBus ? 1: 0,isOntheBus ? 0 : 1));
	
			}
			i++;

		}

		String queryNO_idNO = s.nextLine();
		String[] str = queryNO_idNO.split(",");

		int queryNO = Integer.parseInt(str[0]);
		int id = 0;
		if (str.length > 1)
			id = Integer.parseInt(str[1]);

		switch (queryNO) {
		case 1:
			details.query1(list);
			break;
		case 2:
			details.query2(list, seatingCapacity);
			break;
		case 3:
			details.query3(list, id);
			break;
		case 4:
			details.query4(list, id);
			break;
		case 5:
			details.query5(list, id);
			break;
		}

		list.forEach(p -> System.out.println(p));

	}

}
