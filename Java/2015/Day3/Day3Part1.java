import java.io.File;
import java.util.Scanner;
import java.util.HashSet;

public class Day3Part1 {
    public static void main(String[] args) {
        int x = 0; int y = 0;
        HashSet<Pos> set = new HashSet<Pos>();
        
        try{
            File file = new File("Day3Input.txt");
            Scanner sc = new Scanner(file);
            String input = sc.nextLine();
            set.add(new Pos(0,0));

            for(int i = 0; i<input.length(); i++){
                switch(input.charAt(i)){
                    case '^': y++; break;
                    case 'v': y--; break;
                    case '>': x++; break;
                    case '<': x--; break;
                }
                set.add(new Pos(x,y));
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
        if (this.x==pos.getX() && this.y==pos.getY()) return true; else return false;
    }
}