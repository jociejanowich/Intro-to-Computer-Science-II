public class Lab4Part1{
    private int x;
    private int y;

    public Lab4Part1(){
        x = 0;
        y = 0;
    }

    public Lab4Part1(int x1, int y1){
        x = x1;
        y = y1;
    }

    public void print(){
        System.out.print(x + " " + y + " ");
    }

    public String toString(){
        return x + " " + y + " ";
    }

    public void set (int x1, int y1){
        x = x1;
        y = y1;
    }

    public static void main(String[] args){
        Lab4Part1 p1 = new Lab4Part1(5, 10);
        p1.print();
        System.out.println();
        System.out.println(p1);

        Lab4Part1_2 p2 = new Lab4Part1_2(7, 14, 21);
        p2.print();
        System.out.println(p2);

        p2.set(1, 2, 3);
        p2.print(); 
    }
}

class Lab4Part1_2 extends Lab4Part1{
    private int z;

    public Lab4Part1_2(){
        super();
        z = 0;
    }

    public Lab4Part1_2(int x1, int y1, int z1){
        super(x1, y1);
        z = z1;
    }

    public void print(){
        super.print();
        System.out.println(z);
    }

    public String toString(){
        return super.toString();
    }

    public void set(int x1, int y1, int z1){
        super.set(x1, y1);
        z = z1;
    }


}