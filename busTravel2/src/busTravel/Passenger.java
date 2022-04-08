package busTravel;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
	
	private int passengerId;
	private List<Float> fareList=new ArrayList<Float>();
	private boolean isOnTheBus;
	private int noOftimesIn;
	private int noOftimesOut;
	
	public Passenger(int passengerId, boolean isOnTheBus,float fare,int noOftimesIn,int noOftimesOut) {
		super();
		this.passengerId = passengerId;
		this.isOnTheBus = isOnTheBus;
		this.fareList.add(fare);
		this.noOftimesIn=noOftimesIn;
		this.noOftimesOut=noOftimesOut;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public List<Float> getFare() {
		return fareList;
	}
	public boolean isOnTheBus() {
		return isOnTheBus;
	}
	
	public List<Float> getFareList() {
		return fareList;
	}
	public void addFare(float newFare) {
		this.fareList.add(newFare);
	}
	
	
	public int getNoOftimesIn() {
		return noOftimesIn;
	}
	public void setNoOftimesIn(int noOftimesIn) {
		this.noOftimesIn = noOftimesIn;
	}
	public int getNoOftimesOut() {
		return noOftimesOut;
	}
	public void setNoOftimesOut(int noOftimesOut) {
		this.noOftimesOut = noOftimesOut;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public void setOnTheBus(boolean isOnTheBus) {
		this.isOnTheBus = isOnTheBus;
	}
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", fareList=" + fareList + ", isOnTheBus=" + isOnTheBus
				+ ", noOftimesIn=" + noOftimesIn + ", noOftimesOut=" + noOftimesOut + "]";
	}
}
