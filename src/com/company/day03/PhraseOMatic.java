public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordListOne = { "24/7", "multi-hack", "30,000 foot", "B-to-B", "win-win", "front-end", "web-based",
                "smart", "six- sigma" };
        String[] wordListTwo = { "empowered", "sticky", "ok" };
        String[] wordListThree = { "process", "solution", "space", "vision", "mission" };

        // ����ÿһ���ж��ٸ���������语
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        //�����������
		int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        //��ϳ�ר������
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + ".";

        // ���
        System.out.println("What we need is a " + phrase);
    }
}