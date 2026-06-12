package problems.day7;

import java.util.*;

public class UndergroundSystem {
    // Track active check-ins: id → (stationName, time)
    private Map<Integer, CheckIn> checkIns;
    // Track route statistics: "start-end" → (totalTime, tripCount)
    private Map<String, RouteStats> travelData;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelData = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn start = checkIns.get(id);
        checkIns.remove(id);

        String route = start.station + "-" + stationName;
        int travelTime = t - start.time;

        travelData.putIfAbsent(route, new RouteStats());
        RouteStats stats = travelData.get(route);
        stats.totalTime += travelTime;
        stats.count++;
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        RouteStats stats = travelData.get(route);
        return stats.totalTime / stats.count;
    }

    // Helper class for check-in info
    private static class CheckIn {
        String station;
        int time;
        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route statistics
    private static class RouteStats {
        double totalTime;
        int count;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);

        undergroundSystem.checkOut(45, "Waterloo", 15); // travel time = 12
        undergroundSystem.checkOut(27, "Waterloo", 20); // travel time = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // travel time = 14

        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); // 11.0
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.0
    }
}
