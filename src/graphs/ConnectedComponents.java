package graphs;

import java.util.*;
import java.util.stream.Collectors;

public class ConnectedComponents {
    static Map<Integer, List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        graph = new HashMap<>();
        visited = new boolean[lines];

        for (int i = 0; i < lines; i++) {
            String inputs = scanner.nextLine();
            if (inputs.equals("")) {
                graph.put(i, new ArrayList<>());
            } else {
                List<Integer> nodeConnections = Arrays.stream(inputs.split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());
                graph.put(i, nodeConnections);
            }
        }
        for (int i = 0; i < lines; i++) {
            if(!visited[i]) {
                System.out.print("Connected component: ");
                Dfs(i);
                System.out.println();
            }
        }
    }

    private static void Dfs(int node) {
        if (!visited[node]) {
            visited[node] = true;
            List<Integer> currentNode = graph.get(node);
            for (int n : currentNode) {
                Dfs(n);
            }
            System.out.print(node + " ");
        }
    }
}
