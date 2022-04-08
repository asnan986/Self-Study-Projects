package busTravel;

public class Passenger {
	
	private int passengerId;
	private float fare;
	private boolean isOnTheBus;
	private int stopNo;
	public Passenger(int passengerId, boolean isOnTheBus, int stopNo,float fare) {
		super();
		this.passengerId = passengerId;
		this.isOnTheBus = isOnTheBus;
		this.stopNo = stopNo;
		this.fare=fare;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public float getFare() {
		return fare;
	}
	public boolean isOnTheBus() {
		return isOnTheBus;
	}
	public int getStopNo() {
		return stopNo;
	}
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", fare=" + fare + ", isOnTheBus=" + isOnTheBus + ", stopNo="
				+ stopNo + "]";
	}
	

	
}
