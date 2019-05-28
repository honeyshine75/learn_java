import java.io.*;

public class WriteAFile {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("hello foo!\n");
            writer.write("hello imis!");
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}