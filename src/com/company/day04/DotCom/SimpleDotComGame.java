public class SimpleDotComGame {
    /*   �����ʼ�Ĳ�������
    public static void main(String[] args){
        //��ʼ��һ��SimpleDotCom����
        SimpleDotCom dot = new SimpleDotCom();
        //��������dot comλ�õ�����
        int[] locations = {2, 3, 4};
        //����dot com��setter
        dot.setLocationCells(locations);
        //�ٵĲ²�
        String userGuess = "1";
        //���ñ��ⷽ��������ٵ�����
        String result = dot.checkYourself(userGuess);
    }
    */

    public static void main(String[] args){
        //��¼�²����
        int numOfGuesses = 0;
        //��ȡ�������
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();
        //�����������һ����λ�ã�Ȼ���Դ�����������
        int randomNum = (int)(Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        //��ֵ
        theDotCom.setLocationCells(locations);
    
        boolean isAlive = true;
        while(isAlive == true){
            //��ȡ����
            String guess = helper.getUserInput("enter a number");
            //�����������result
            String result = theDotCom.checkYourself(guess);
            //�²����+1
            numOfGuesses++;
            if(result.equals("kill")){
                isAlive = false;
                System.out.println("You took " + numOfGuesses + "guesses");
            }
        }
    }
}