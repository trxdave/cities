import java.io.*;
import java.util.*;

public class ConnectedCities {
    private Map<String, List<String>> graph = new HashMap<>();

    // Load city connections from a file
    public void loadCities(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] cities = line.split(",");
            addConnection(cities[0].trim(), cities[1].trim());
        }
        br.close();
    }

    // Add a connection to the graph
    private void addConnection(String city1, String city2) {
        graph.computeIfAbsent(city1, k -> new ArrayList<>()).add(city2);
        graph.computeIfAbsent(city2, k -> new ArrayList<>()).add(city1);
    }

    // Check if two cities are connected
    public boolean areConnected(String city1, String city2) {
        if (!graph.containsKey(city1) || !graph.containsKey(city2)) return false;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(city1);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(city2)) return true;
            if (visited.add(current)) {
                queue.addAll(graph.get(current));
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        ConnectedCities cc = new ConnectedCities();
        cc.loadCities("cities.txt"); // Replace with your file path
        System.out.println("Are London and Bristol connected? " + cc.areConnected("London", "Bristol"));
        System.out.println("Are London and Nottingham connected? " + cc.areConnected("London", "Nottingham"));
    }
}