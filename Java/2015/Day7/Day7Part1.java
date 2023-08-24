import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Day7Part1 {
    public static void main(String[] args) {

        try{
            File file = new File("Day7Input.txt");
            Scanner sc = new Scanner(file);
            ArrayList<Wire> list = new ArrayList<Wire>();

            while(sc.hasNextLine()){
                String[] input = sc.nextLine().split(" ");

    
                //get value
                if(input.length == 3){
                    try{
                        list.add(new Wire(input[input.length-1], Integer.parseInt(input[0])));
                    }
                    catch(Exception e){
                        for(int i = 0; i<list.size(); i++){
                            if (list.get(i).getIdent().equals(input[0])){
                                list.add(new Wire(input[input.length-1], list.get(i).getVal()));
                            }
                        }
                    }
                }

                else if(input.length == 4){
                    int val = 0;
                    for(int i = 0; i<list.size(); i++){
                        if (list.get(i).getIdent().equals(input[1])){
                            val = list.get(i).getVal();
                            break;
                        }
                    }
                    list.add(new Wire(input[input.length-1], 65536 + ~val));
                }

                else if(input.length==5){

                    int val1=0, val2=0;

                    for(int i = 0; i<list.size(); i++){
                        if (list.get(i).getIdent().equals(input[0])){
                            val1 = list.get(i).getVal();
                            break;
                        }
                    }

                    try{
                        val2=Integer.parseInt(input[2]);
                    }
                    catch(Exception e){
                        for(int i = 0; i<list.size(); i++){
                            if (list.get(i).getIdent().equals(input[2])){
                                val2 = list.get(i).getVal();
                            }
                        }

                    }

                    if(input[1].equals("AND")){
                        list.add(new Wire(input[input.length-1], val1&val2));
                    }
                    else if(input[1].equals("OR")){
                        list.add(new Wire(input[input.length-1], val1|val2));
                    }
                    else if(input[1].equals("LSHIFT")){
                        list.add(new Wire(input[input.length-1], val1<<val2));
                    }
                    else if(input[1].equals("RSHIFT")){
                        list.add(new Wire(input[input.length-1], val1>>val2));
                    }

                }






            }
            sc.close();
            Collections.sort(list);
            for(int i = 0; i<list.size(); i++){
                System.out.println(list.get(i).getIdent() + ": "+list.get(i).getVal());
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
    }
}

class Wire implements Comparable<Object>{
    private String ident;
    private int val;
    public Wire(String ident, int val){
        this.ident=ident;
        this.val=val;
    }
    public String getIdent(){return ident;}
    public int getVal(){return val;}
    public int compareTo(Object obj){
        Wire wire = (Wire)obj;
        return this.ident.compareTo(wire.getIdent());
    }
}