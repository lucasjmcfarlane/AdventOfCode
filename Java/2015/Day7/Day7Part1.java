import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//create an object for every instruction in the txt
//object will have a string array length 2 called requires
//instructions may require 0 1 or 2 wires to already exist
//first loop will complete all instructions that require 0 existing wires
//second loop will complete instructions that require those wires and nothing more
//this repeats until the queue is empty

public class Day7Part1 {
    public static void main(String[] args) {
        try{
            File file = new File("Day7Input.txt");
            Scanner sc = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
    }
}