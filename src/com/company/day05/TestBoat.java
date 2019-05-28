class Rowboats extends Boat {
    public void rowTheBoat(){
        System.out.print("stroke matasha");
    }
}

class Boat {
    private int length;
    public void setLength(int len){
        length = len;
    }
    public int getLength(){
        return length;
    }
    public void move(){
        System.out.print("drift ");
    }
}

class Sailboat extends Boat {
    public void move(){
        System.out.print("hoist sail");
    }
}

public class TestBoat {
    public static void main(String[] args) {
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboats b3 = new Rowboats();
        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }
}