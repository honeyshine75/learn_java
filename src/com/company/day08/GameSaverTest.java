import java.io.*;

public class GameSaverTest{
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(500, "Trell", new String[] {"bare", "big ax"});
        GameCharacter three = new GameCharacter(520, "Magician", new String[] {"spells", "imis"});

        try{
            FileOutputStream f = new FileOutputStream("Game.ser");
            ObjectOutputStream os = new ObjectOutputStream(f);
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        try{
            FileInputStream fi = new FileInputStream("Game.ser");
            ObjectInputStream osi = new ObjectInputStream(fi);
            GameCharacter oneRestore = (GameCharacter) osi.readObject();
            GameCharacter twoRestore = (GameCharacter) osi.readObject();
            GameCharacter threeRestore = (GameCharacter) osi.readObject();
            osi.close();

            System.out.println("One's type is " + oneRestore.getType());
            System.out.println("Two's type is " + twoRestore.getType());
            System.out.println("Three's type is " + threeRestore.getType());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}