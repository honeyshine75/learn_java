public class SimpleDotComGame {
    /*   这是最开始的测试用例
    public static void main(String[] args){
        //初始化一个SimpleDotCom对象
        SimpleDotCom dot = new SimpleDotCom();
        //创建带有dot com位置的数组
        int[] locations = {2, 3, 4};
        //调用dot com的setter
        dot.setLocationCells(locations);
        //假的猜测
        String userGuess = "1";
        //调用被测方法并传入假的数据
        String result = dot.checkYourself(userGuess);
    }
    */

    public static void main(String[] args){
        //记录猜测次数
        int numOfGuesses = 0;
        //获取玩家输入
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();
        //随机数产生第一个的位置，然后以此制作出数组
        int randomNum = (int)(Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        //赋值
        theDotCom.setLocationCells(locations);
    
        boolean isAlive = true;
        while(isAlive == true){
            //获取输入
            String guess = helper.getUserInput("enter a number");
            //检查结果并存入result
            String result = theDotCom.checkYourself(guess);
            //猜测次数+1
            numOfGuesses++;
            if(result.equals("kill")){
                isAlive = false;
                System.out.println("You took " + numOfGuesses + "guesses");
            }
        }
    }
}