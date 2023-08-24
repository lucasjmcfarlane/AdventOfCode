import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Day5Part2 {
    public static void main(String[] args) {
        try{
            File file = new File("Day5Input.txt");
            Scanner sc = new Scanner(file);
            int niceCount = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                boolean containsPair = false;
                boolean containsRepeat = false;

                if(input.length()>=4){
                    for(int i = 1; i<input.length()-2; i++){
                        if(input.substring(i+1, input.length()).contains(input.substring(i-1, i+1))){
                            containsPair=true;
                            break;
                        }
                    }
                }
                else continue;

                if(input.length()>=3){
                    for(int i = 2; i<input.length(); i++){
                        if(input.charAt(i-2) == input.charAt(i)){
                            containsRepeat = true;
                            break;
                        }
                    }
                }
                else continue;

                if(containsPair && containsRepeat) niceCount++;
            }

            sc.close();
            System.out.println(niceCount);
        }
        catch(FileNotFoundException e){
            System.out.println("Invalid File Given!");
            return;
        }
    }
}