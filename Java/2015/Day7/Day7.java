import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7{
    public static void main(String[] args) {
        try{
            File file = new File("Day7Input.txt");
            Scanner sc = new Scanner(file);
            ArrayList<Instruction> instructions = new ArrayList<Instruction>();
            ArrayList<Wire> wires = new ArrayList<Wire>();

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                String[] inputArr = input.split(" ");

                if(input.contains("AND") || input.contains("OR") || input.contains("LSHIFT") || input.contains("RSHIFT")){
                    instructions.add(new Instruction(inputArr[4], inputArr[1], inputArr[0], inputArr[2]));
                }
                else if(input.contains("NOT")){
                    instructions.add(new Instruction(inputArr[3], inputArr[0], inputArr[1], null));
                }
                else{
                    instructions.add(new Instruction(inputArr[2], inputArr[1], inputArr[0], null));
                }
            }

            //loop through instructions until list is empty
            while(!instructions.isEmpty()){
                Instruction instruction = instructions.remove(0);
                int val1 = operandToInt(instruction.operands[0], wires);
                int val2 = operandToInt(instruction.operands[1], wires);

                if((val1 > -1 && val2 == -2) || (val1 > -1 && val2 > -1)){
                    wires.add(new Wire(instruction.identifier, performOperation(val1, val2, instruction.operator)));
                }
                else{
                    instructions.add(instruction);
                }
            }

            for(int i = 0; i<wires.size(); i++){
                if(wires.get(i).ident.equals("a")) System.out.println("a="+wires.get(i).value);
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
    }

    public static int operandToInt(String ident, ArrayList<Wire> wires){
        if(ident==null) return -2;
        try{
            return Integer.parseInt(ident);
        }
        catch(NumberFormatException e){
            for(int i = 0; i<wires.size(); i++){
                if(wires.get(i).ident.equals(ident)) return wires.get(i).value;
            }
        }
        return -1;
    }

    public static int performOperation(int val1, int val2, String operator){
        switch(operator){
            case "->":     return val1;
            case "AND":    return val1&val2;
            case "OR":     return val1|val2;
            case "NOT":    return 65536 + ~val1;
            case "LSHIFT": return val1<<val2;
            case "RSHIFT": return val1>>val2;
        }
        return -1;
    }
}

class Wire{
    public String ident;
    public int value;
    public Wire(String ident, int value){
        this.ident=ident;
        this.value=value;
    }
}

class Instruction{
    public String identifier;
    public String operator;
    public String[] operands = new String[2];

    public Instruction(String identifier, String operator, String operand1, String operand2){
        this.identifier=identifier;
        this.operator=operator;
        this.operands[0] = operand1;
        this.operands[1] = operand2;
    }
}