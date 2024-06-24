package airportSimulation;

public class trafficControlTasks {

    public static void moveAirplane(int airplaneID, String originalLink, String nextLink) {
        System.out.println("Moving airplane " + airplaneID + " from " + originalLink + " to " + nextLink);
    }

    public static void holdAirplane(int airplaneID, String designatedLink) {
        System.out.println("Holding airplane " + airplaneID + " in position at " + designatedLink);
    }

    public static void parkAirplane(int airplaneID, String designatedGate) {
        System.out.println("Parking airplane " + airplaneID + " at gate " + designatedGate);
    }
}
