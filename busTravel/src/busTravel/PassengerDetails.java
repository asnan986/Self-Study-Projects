package busTravel;

import java.util.List;

public class PassengerDetails {

	public void query1(List<Passenger> list, int noOfStops) {

		for (int i = 1; i <= noOfStops; i++) {
			int in = 0;
			int out = 0;
			for (Passenger p : list) {
				if (p.getStopNo() == i) {
					if (p.isOnTheBus())
						in++;
					else
						out++;
				}
			}
			
			System.out.println("No of passengers in "+in+". No of passengers out "+out);
		}
		
	}

	public void query2(List<Passenger> list, int seatingCapacity) {
		float fare1=1.6f*seatingCapacity;
		float fare2=1.3f*seatingCapacity;
		int noOffare1=0,noOffare2=0,noOffaren=0;
		for(Passenger p:list) {
			if(p.getFare()==fare1)
				noOffare1++;
			else if(p.getFare()==fare2)
				noOffare2++;
			if (p.getFare()==seatingCapacity)
				noOffaren++;
		}
		
		System.out.println(noOffare1+" is travelling with "+fare1+" . "
				+noOffare2+" is travelling with fare "+fare1+" . "
				+noOffaren+" is travelling with fare "+seatingCapacity+" .");

	}

	public void query3(List<Passenger> list, int id) {
		float faresum=0;
		for(Passenger p:list) 
			if(p.getPassengerId()==id)
				faresum+=p.getFare();
     System.out.println("fare charge of passenger with id "+id+" is "+faresum);
	}

	public void query4(List<Passenger> list, int id) {
		
		int sum=0;
		for(Passenger p:list) {
			if(p.getPassengerId()==id&&p.isOnTheBus()) {
				sum++;
			}
		}
       System.out.println("passenger with id "+id+" entered the bus for "+sum+" times");
	}

	public void query5(List<Passenger> list, int id, int noOfStops) {
		
		boolean isInside=false;
		for(Passenger p:list) {
			if (p.getStopNo()==noOfStops&&p.getPassengerId()==id&&p.isOnTheBus())
				isInside=true;
		}
		String status=isInside ?"inside" :"not inside";
        
		System.out.println("the passenger with id "+id+" is "+ status+" the bus");
	}
}
