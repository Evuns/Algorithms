package examPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(bf.readLine().split(", ")).collect(Collectors.toList());
        String[] places = new String[names.size()];
        boolean[] taken = new boolean[names.size()];


        String preferences = bf.readLine();
        while (!preferences.equalsIgnoreCase("generate")) {
            String[] data = preferences.split(" - ");
            String name = data[0];
            int place = Integer.parseInt(data[1]);
            places[place - 1] = name;
            taken[place - 1] = true;
            names.remove(name);
            preferences = bf.readLine();
        }
        boolean[] tried = new boolean[names.size()];
        variate(names, places, taken,0, tried);

    }

    private static void variate(List<String> input, String[] print, boolean[] taken, int secondInd, boolean[] tried) {
        if (isTrue(tried)) {
            System.out.println(Arrays.toString(print).replaceAll("[\\[\\],]", ""));
            return;
        }
        for (int i = 0; i < print.length; i++) {
            if (!taken[i]) {
                for (int j = secondInd; j < input.size(); j++) {
                    if (!tried[j]) {
                        print[i] = input.get(j);
                        tried[j] = true;
                        taken[i] = true;
                        variate(input, print, taken, secondInd + 1, tried);
                        tried[j] = false;
                        taken[i] = false;
                    }
                }
            }
        }
    }

    private static boolean isTrue(boolean[] tried) {
        for (boolean b : tried) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
