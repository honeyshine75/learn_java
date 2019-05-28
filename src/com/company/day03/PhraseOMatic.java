public class PhraseOMatic {
    public static void main(String[] args) {
        String[] wordListOne = { "24/7", "multi-hack", "30,000 foot", "B-to-B", "win-win", "front-end", "web-based",
                "smart", "six- sigma" };
        String[] wordListTwo = { "empowered", "sticky", "ok" };
        String[] wordListThree = { "process", "solution", "space", "vision", "mission" };

        // 计算每一组有多少个名词术语
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        //产生随机数字
		int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        //组合出专家术语
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + ".";

        // 输出
        System.out.println("What we need is a " + phrase);
    }
}