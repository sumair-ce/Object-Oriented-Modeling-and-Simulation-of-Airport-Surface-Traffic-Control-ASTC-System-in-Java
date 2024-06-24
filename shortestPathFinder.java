package airportSimulation;

import java.util.*;

public class shortestPathFinder {
    static Map<String, Map<String, Integer>> distances = Map.of(
            "New York", Map.of("Chicago", 5, "Houston", 10, "New Jersey", 15, "Los Angeles", 20, "Miami", 25, "San Francisco", 30, "Denver", 35),
            "Chicago", Map.of("New York", 5, "Houston", 8, "New Jersey", 12, "Los Angeles", 18, "Miami", 22, "San Francisco", 28, "Denver", 32),
            "Houston", Map.of("New York", 10, "Chicago", 8, "New Jersey", 6, "Los Angeles", 15, "Miami", 20, "San Francisco", 25, "Denver", 30),
            "New Jersey", Map.of("New York", 15, "Chicago", 12, "Houston", 6, "Los Angeles", 25, "Miami", 18, "San Francisco", 22, "Denver", 27),
            "Los Angeles", Map.of("New York", 20, "Chicago", 18, "Houston", 15, "New Jersey", 25, "Miami", 10, "San Francisco", 12, "Denver", 16),
            "Miami", Map.of("New York", 25, "Chicago", 22, "Houston", 20, "New Jersey", 18, "Los Angeles", 10, "San Francisco", 14, "Denver", 24),
            "San Francisco", Map.of("New York", 30, "Chicago", 28, "Houston", 25, "New Jersey", 22, "Los Angeles", 12, "Miami", 14, "Denver", 20),
            "Denver", Map.of("New York", 35, "Chicago", 32, "Houston", 30, "New Jersey", 27, "Los Angeles", 16, "Miami", 24, "San Francisco", 20)
    );

    public static int callDijkstra(String start, String end) {
        return dijkstra(distances, start, end);
    }

    private static int dijkstra(Map<String, Map<String, Integer>> distances, String start, String end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Map<String, Integer> distanceMap = new HashMap<>();

        pq.offer(new Node(start, 0));
        distanceMap.put(start, 0);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.destination.equals(end))
                return current.distance;

            distances.getOrDefault(current.destination, Collections.emptyMap())
                    .forEach((neighbor, weight) -> {
                        int newDistance = current.distance + weight;
                        if (newDistance < distanceMap.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                            distanceMap.put(neighbor, newDistance);
                            pq.offer(new Node(neighbor, newDistance));
                        }
                    });
        }

        return Integer.MAX_VALUE;
    }

}
