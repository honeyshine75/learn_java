/*
需求：练习一个hello world程序

思路：
1.定义一个类，因为java程序都定义在类中，java程序都是以类的形式存在的，类的形式其实就是一个字节码文件最终体现。
2.定义一个主函数，为了让该类可以独立运行。
3.因为要掩饰hello world，在控制台上看到该字样，所以需要使用输出语句完成。

步骤：
1.用class关键字完成类的定义，并起一个阅读性强的类名。
2.主函数：public static void main(String[] args)这是固定语句，jvm认识。
3.使用输出语句：System.out.println("hello world");


代码仅仅是思想的一种体现形式
*/
class Demo
{
	public static void main(String[] args)
	{
		System.out.println("Hello Java!");
	}
}