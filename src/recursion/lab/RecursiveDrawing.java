package recursion.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());
        System.out.println(drawFirst(num).trim());
        System.out.println(drawSecond(num,0).trim());


    }

    private static String drawFirst(int num) {
        if (num <= 0) {
            return "";
        }
        String drawing = "";
        for (int i = 0; i < num; i++) {
            drawing += "*";
        }
        return drawing + System.lineSeparator() + drawFirst(num - 1);
    }

    private static String drawSecond(int num, int index) {
        if (index >= num) {
            return "";
        }
        String drawing = "";
        for (int i = 0; i <= index; i++) {
            drawing += "#";
        }
        index ++;
        return drawing + System.lineSeparator() + drawSecond(num,index);
    }
}
