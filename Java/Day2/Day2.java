import java.io.File;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        try{
            File file = new File("Day2Input.txt");
            Scanner sc = new Scanner(file);
            int smallestArea;
            int ribbonLength = 0;
            int total = 0;

            while(sc.hasNextLine()){
                String[] input = sc.nextLine().split("x");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int z = Integer.parseInt(input[2]);
                if(x>=y&&x>=z){
                    smallestArea= y*z;
                    ribbonLength+= 2*y + 2*z;

                } 
                else if (y>=x&&y>=z){
                    smallestArea = x*z;
                    ribbonLength+= 2*x + 2*z;
                } 
                else{
                    smallestArea = x*y;
                    ribbonLength += 2*x + 2*y;
                } 
                ribbonLength+=x*y*z;
                total += (smallestArea + 2*x*y + 2*y*z + 2*z*x);
            }
            System.out.println("Wrapping Paper: " + total);
            System.out.println("Ribbon: " + ribbonLength);
            sc.close();
        }
        catch(Exception e){
            System.out.println("Invalid File Given!");
        }
    }
}

