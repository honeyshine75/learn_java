class Duck2 {
    int size;
    public Duck2(int duckSize) {
        System.out.println("Quack");
        size = duckSize;
        System.out.println("size is " + size);
    }
    //Ä¬ÈÏÇé¿ö
    public Duck2(){
        size = 7;
        System.out.println("size is " + size);
    }
}

public class UseADuck2 {
    public static void main(String[] args) {
        Duck2 d1 = new Duck2();
        Duck2 d2 = new Duck2(23);
    }
}