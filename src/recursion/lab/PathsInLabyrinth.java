package recursion.lab;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;

public class PathsInLabyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(bf.readLine());
        int cols = Integer.parseInt(bf.readLine());

        char[][] labyrinth = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            labyrinth[i] = bf.readLine().toCharArray();
        }

        List<Character> path = new ArrayList<>();
        findPath(labyrinth, 0, 0, path);
    }

    private static void findPath(char[][] labyrinth, int row, int col, List<Character> path) {
        if (row < 0 || row > labyrinth.length - 1 || col < 0 || col > labyrinth[row].length - 1) {
            return;
        }
        if (labyrinth[row][col] == 'e') {
            print(path);
            return;
        }
        if (labyrinth[row][col] == '*') {
            return;
        }
        if (labyrinth[row][col] == 'v') {
            return;
        }

        labyrinth[row][col] = 'v';
        path.add('R');
        findPath(labyrinth, row, col + 1, path);//R
        path.remove(path.size() - 1);
        path.add('L');
        findPath(labyrinth, row, col - 1, path);//L
        path.remove(path.size() - 1);
        path.add('D');
        findPath(labyrinth, row + 1, col, path);//D
        path.remove(path.size() - 1);
        path.add('U');
        findPath(labyrinth, row - 1, col, path);//U
        path.remove(path.size() - 1);

        labyrinth[row][col] = '-';
    }

    private static void print(List<Character> path) {
        System.out.println(path.toString().replaceAll("\\s+|\\[|]|,", ""));
    }
}
