import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Day6Part2 {
    public static void main(String[] args) {

        try {
            File file = new File("Day6Input.txt");
            Scanner sc = new Scanner(file);
            int[][] lights = new int[1000][1000];

            while (sc.hasNextLine()) {
                String[] input = sc.nextLine().split(" ");

                if (input[0].equals("turn")) {
                    String[] pair1 = input[2].split(",");
                    String[] pair2 = input[4].split(",");

                    if (input[1].equals("on"))
                        set(Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]), Integer.parseInt(pair2[0]),
                                Integer.parseInt(pair2[1]), 1, lights);
                    else
                        set(Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]), Integer.parseInt(pair2[0]),
                                Integer.parseInt(pair2[1]), -1, lights);
                }

                else { // toggle
                    String[] pair1 = input[1].split(",");
                    String[] pair2 = input[3].split(",");
                    set(Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]), Integer.parseInt(pair2[0]),
                            Integer.parseInt(pair2[1]), 2, lights);
                }
            }
            sc.close();
            System.out.println(countLights(lights));
        }

        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void set(int x, int y, int x2, int y2, int amount, int[][] lights) {
        for (int i = x; i <= x2; i++) {
            for (int j = y; j <= y2; j++) {
                lights[i][j] += amount;
                if (lights[i][j] < 0)
                    lights[i][j] = 0;
            }
        }

    }

    public static int countLights(int[][] lights) {
        int count = 0;
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[0].length; j++) {
                count += lights[i][j];
            }
        }
        return count;
    }
}