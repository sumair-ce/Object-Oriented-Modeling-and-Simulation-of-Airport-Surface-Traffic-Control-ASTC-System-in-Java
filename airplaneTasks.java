package airportSimulation;

public class airplaneTasks {

    public static void landAirplane(int airplaneID, String runway, int gate) {
        System.out.println("Airplane " + airplaneID + " is landing on Runway " + runway + " and Gate # " + gate);
    }

    public static void exitLink(int airplaneID, String currentLink, String nextLink) {
        System.out.println("Airplane " + airplaneID + " is exiting from Link " + currentLink + " to " + nextLink);
    }

    public static void enterLink(String airplaneID, String currentLink, String nextLink) {
        System.out.println("Airplane " + airplaneID + " is entering from Link " + currentLink + " to " + nextLink);
    }
}
