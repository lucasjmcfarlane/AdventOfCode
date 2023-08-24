import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Day6Part1 {
    public static void main(String[] args) {

        try {
            File file = new File("Day6Input.txt");
            Scanner sc = new Scanner(file);

            boolean[][] lights = new boolean[1000][1000];

            while (sc.hasNextLine()) {
                String[] input = sc.nextLine().split(" ");

                if (input[0].equals("turn")) {
                    String[] pair1 = input[2].split(",");
                    String[] pair2 = input[4].split(",");

                    if (input[1].equals("on"))
                        turnOn(Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]), Integer.parseInt(pair2[0]),
                                Integer.parseInt(pair2[1]), lights);
                    else
                        turnOff(Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]), Integer.parseInt(pair2[0]),
                                Integer.parseInt(pair2[1]), lights);

                } else { // toggle
                    String[] pair1 = input[1].split(",");
                    String[] pair2 = input[3].split(",");
                    toggle(Integer.parseInt(pair1[0]), Integer.parseInt(pair1[1]), Integer.parseInt(pair2[0]),
                            Integer.parseInt(pair2[1]), lights);
                }
            }
            sc.close();
            System.out.println(countLights(lights));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void turnOn(int x, int y, int x2, int y2, boolean[][] lights) {
        for (int i = x; i <= x2; i++) {
            for (int j = y; j <= y2; j++) {
                lights[i][j] = true;
            }
        }
    }

    public static void turnOff(int x, int y, int x2, int y2, boolean[][] lights) {
        for (int i = x; i <= x2; i++) {
            for (int j = y; j <= y2; j++) {
                lights[i][j] = false;
            }
        }
    }

    public static void toggle(int x, int y, int x2, int y2, boolean[][] lights) {
        for (int i = x; i <= x2; i++) {
            for (int j = y; j <= y2; j++) {
                lights[i][j] = !lights[i][j];
            }
        }
    }

    public static int countLights(boolean[][] lights) {
        int count = 0;
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[0].length; j++) {
                if (lights[i][j])
                    count++;
            }
        }
        return count;
    }
}