import java.io.File;
import java.util.Scanner;
import java.util.HashSet;

public class Day3Part2 {
    public static void main(String[] args) {
        int x=0,y=0,x2=0,y2=0;
        HashSet<Pos> set = new HashSet<Pos>();
        
        try{
            File file = new File("Day3Input.txt");
            Scanner sc = new Scanner(file);
            String input = sc.nextLine();
            set.add(new Pos(0,0));

            for(int i = 0; i<input.length(); i++){

                Pos newPos;

                if(i%2==0){
                    switch(input.charAt(i)){
                        case '^': y++; break;
                        case 'v': y--; break;
                        case '>': x++; break;
                        case '<': x--; break;
                    }
                    newPos = new Pos(x,y);
                }

                else{
                    switch(input.charAt(i)){
                        case '^': y2++; break;
                        case 'v': y2--; break;
                        case '>': x2++; break;
                        case '<': x2--; break;
                    }
                    newPos = new Pos(x2,y2);
                }

                set.add(newPos);
            }
            sc.close();
            System.out.println(set.size());
        }

        catch(Exception e){
            System.out.println("Invalid File Given!");
            System.out.println(e.getMessage());
            return;
        }
    }
}

class Pos{
    private int x;
    private int y;
    public Pos(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){return x;}
    public int getY(){return y;}

    @Override
    public int hashCode(){return x*y;}

    @Override
    public boolean equals(Object obj){
        Pos pos = (Pos)obj;
        if (this.x==pos.getX()&&this.y==pos.getY()) return true; else return false;
    }
}