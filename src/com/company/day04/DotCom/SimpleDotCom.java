public class SimpleDotCom{
    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    public String checkYourself(String stringGuess){
        //���ַ�ת��Ϊint
        int guess = Integer.parseInt(stringGuess);
        //���������淵�ؽ���ı�����Ĭ��ֵΪmiss
        String result = "miss";
        //��ѭ����ÿ�������ظ�ִ��
        for(int cell : locationCells){
            //�Ƚϸ�����²�ֵ
            if(guess == cell){
                result = "hit";
                numOfHits++;
                //�Ѿ��뿪ѭ��������Ҫ�ж��Ƿ����
                break;
            }
        }
        if(numOfHits == locationCells.length){
            result = "kill";
        }
        System.out.println(result);
        //���ؽ��
        return result;
    }
}