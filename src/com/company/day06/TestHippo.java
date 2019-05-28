class Animal {
    public Animal(){
        System.out.println("Making an Animal...");
    }
}

class Hippo extends Animal {
    public Hippo(){
        System.out.println("Making a Hippo...");
    }
}

public class TestHippo {
    public static void main(String[] args) {
        Hippo h = new Hippo();
    }
}