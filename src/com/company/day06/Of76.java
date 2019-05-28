interface Nose {
    public int iMethod();
}

abstract class Picasse implements Nose {
    public int iMethod(){
        return 7;
    }
}

class Clowns extends Picasse { }

class Acts implements Nose {
    public int iMethod(){
        return 5;
    }
}

public class Of76 extends Clowns {
    public static void main(String[] args){
        Nose[] i = new Nose[3];
        i[0] = new Acts();
        i[1] = new Clowns();
        i[2] = new Of76();

        for(int x = 0; x < 3; x++){
            System.out.println(i[x].iMethod() + " " + i[x].getClass());
        }
    }
}