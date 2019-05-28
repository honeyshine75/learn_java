class PoolPuzzleOne{
    public static void main(String[] args){
        int x = 0;

        while(x < 4){
            System.out.print("a");
            if(x < 1)
                System.out.print(" ");
            System.out.print("n");
            if(x < 1){
                System.out.print("oise");
                x = x - 1;
            }
            if(x == 1)
                System.out.print("onys");
            if(x > 1)
                System.out.print(" oyster");
            System.out.println("");
            x = x + 2;
        }
    }
}