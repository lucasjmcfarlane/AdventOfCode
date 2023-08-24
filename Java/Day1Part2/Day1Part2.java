import java.io.File;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {
        try{
            File file = new File("Day1Input.txt");
            Scanner sc = new Scanner(file);
            String input = sc.nextLine();
            int count = 0;

            for(int i = 0; i<input.length(); i++){
                if(input.charAt(i) == '(') count++;
                else if(input.charAt(i)==')') count--;
                if (count == -1){
                    System.out.println(i+1);
                    break;
                } 
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println("Invalid File Given!");
            return;
        }
        return;
    }
}
