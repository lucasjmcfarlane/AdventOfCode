import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Day5Part1 {
    public static void main(String[] args) {
        try{
            File file = new File("Day5Input.txt");
            Scanner sc = new Scanner(file);
            int niceCount = 0;

            while(sc.hasNextLine()){
                int vowelCount = 0;
                boolean doubleLetter = false;
                boolean containsInvalidString = false;

                String input = sc.nextLine().toLowerCase();

                for(int i = 0; i<input.length(); i++){
                    switch(input.charAt(i)){
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u': vowelCount++;
                    }
                }

                if(input.length()>=2){
                    for(int i = 1; i<input.length(); i++){
                        if(input.charAt(i) == input.charAt(i-1)){
                            doubleLetter = true;
                            break;
                        }
                    }
                }

                if(input.contains("ab")) containsInvalidString=true;
                else if(input.contains("cd")) containsInvalidString=true;
                else if(input.contains("pq")) containsInvalidString=true;
                else if(input.contains("xy")) containsInvalidString=true;

                if(vowelCount>=3 && doubleLetter && !containsInvalidString) niceCount++;
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