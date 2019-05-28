public class BeerSong{
    public static void main(String[] srgs){
        int beerNum = 99;
        String word = "bottles";
        while(beerNum > 0){
            if(beerNum == 1){
                word = "bottles";
            }
            System.out.println(beerNum + " " + word + " of beer on the wall");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.println("Take one down.");
            System.out.println("Pass it around.");
            beerNum--;

            if(beerNum > 0){
                System.out.println(beerNum + " " + word + " of beer on the wall");
            }
        }
    }
}