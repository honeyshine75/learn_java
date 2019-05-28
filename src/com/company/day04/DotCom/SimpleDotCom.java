public class SimpleDotCom{
    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    public String checkYourself(String stringGuess){
        //把字符转换为int
        int guess = Integer.parseInt(stringGuess);
        //创建出保存返回结果的变量，默认值为miss
        String result = "miss";
        //以循环对每个格子重复执行
        for(int cell : locationCells){
            //比较各自与猜测值
            if(guess == cell){
                result = "hit";
                numOfHits++;
                //已经离开循环，但需要判断是否击沉
                break;
            }
        }
        if(numOfHits == locationCells.length){
            result = "kill";
        }
        System.out.println(result);
        //返回结果
        return result;
    }
}