import java.io.File;
import java.util.Scanner;
public class Day8Part2 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("Day8Input.txt"));
            int realCount = 0, strCount = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                realCount+=input.length();

                input = input.replace("\\", "\\\\");
                input = input.replace("\"", "\\\"");
                strCount += input.length()+2;
            }            
            System.out.println(strCount-realCount);
        }
        catch(Exception e){return;}
    }
}