import java.io.File;
import java.util.Scanner;
public class Day8Part1 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("Day8Input.txt"));
            int realCount = 0, strCount = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                realCount+=input.length();

                input = input.replace("\\\\", "0");
                strCount+=input.length()-2;

                String[] array = input.split("");
                for(int j = 0; j<array.length; j++){
                    if(array[j].equals("\\")){
                        strCount-=1;
                        if(array[j+1].equals("x")) strCount-=2;
                    }
                }
            }            
            System.out.println(realCount-strCount);
        }
        catch(Exception e){return;}
    }
}