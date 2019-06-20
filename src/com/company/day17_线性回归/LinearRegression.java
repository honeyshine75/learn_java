package com.company.day17_���Իع�;
/**
 * Description : Javaʵ��һԪ���Իع���㷨�����Իع�����࣬(��ʵ��ͳ��ָ���Ԥ��) 
 */

/**
 * <p>
 * <b>Linear Regression</b> <br>
 * Demonstrate linear regression by constructing the regression line for a set
 * of data points.
 * 
 * <p>
 * require DataPoint.java,RegressionLine.java
 * 
 * <p>
 * Ϊ�˼�����ڸ������ݵ����С������ߣ���Ҫ����SumX,SumY,SumXX,SumXY; (ע��SumXX = Sum (X^2))
 * <p>
 * <b>�ع�ֱ�߷������£� f(x)=a1x+a0 </b>
 * <p>
 * <b>б�ʺͽؾ�ļ��㹫ʽ���£�</b> <br>
 * n: ���ݵ����
 * <p>
 * a1=(n(SumXY)-SumX*SumY)/(n*SumXX-(SumX)^2) <br>
 * a0=(SumY - SumY * a1)/n <br>
 * (Ҳ�ɱ��Ϊa0=averageY-a1*averageX)
 * 
 * <p>
 * <b>���ߵ�ԭ�������һֱ�ߣ�ֻҪ��ȷ�������㼴��</b><br>
 * ��һ�㣺(0,a0) ������ȡһ��x1ֵ���뷽�̣�ȡ��y1������(0,a0)��(x1,y1)���㼴�ɡ�
 * Ϊ�����ߴ�������ͼ,x1����ȡ����������ֵXmax��������Ϊ(0,a0),(Xmax,Y)�����y=a1*Xmax+a0,y����
 * ���������ֵYmax����������㡣����yȡ���ֵYmax����ô�ʱx��ֵ��ʹ��(X,Ymax)�� ������Ϊ(0,a0),(X,Ymax)
 * 
 * <p>
 * <b>��϶ȼ��㣺(��Excel�е�R^2)</b>
 * <p>
 * *R2 = 1 - E
 * <p>
 * ���E�ļ��㣺E = SSE/SST
 * <p>
 * SSE=sum((Yi-Y)^2) SST=sumYY - (sumY*sumY)/n;
 * <p>
 */
public class LinearRegression {

    private static final int MAX_POINTS = 10;

    private double E;

    /**
     * Main program.
     * 
     * @param args the array of runtime arguments
     */
    public static void main(String args[]) {
        RegressionLine line = new RegressionLine();

        line.addDataPoint(new DataPoint(1, 0.5));
        line.addDataPoint(new DataPoint(2, 0.8));
        line.addDataPoint(new DataPoint(3, 2.5));
        line.addDataPoint(new DataPoint(4, 3));
//        line.addDataPoint(new DataPoint(5, 147));

        printSums(line);
        printLine(line);
    }

    /**
     * Print the computed sums.
     * 
     * @param line the regression line
     */
    private static void printSums(RegressionLine line) {
        System.out.println("\n���ݵ���� n = " + line.getDataPointCount());
        System.out.println("\nSum x  = " + line.getSumX());
        System.out.println("Sum y  = " + line.getSumY());
        System.out.println("Sum xx = " + line.getSumXX());
        System.out.println("Sum xy = " + line.getSumXY());
        System.out.println("Sum yy = " + line.getSumYY());

    }

    /**
     * Print the regression line function.
     * 
     * @param line the regression line
     */
    private static void printLine(RegressionLine line) {
        System.out.println("\n�ع��߹�ʽ:  y = " + line.getA1() + "x + " + line.getA0());
        System.out.println("��     R^2 = " + line.getR());
    }

    // y = 2.1x + 133.7 2.1 * 6 + 133.7 = 12.6 + 133.7 = 146.3
    // y = 2.1x + 133.7 2.1 * 7 + 133.7 = 14.7 + 133.7 = 148.4

}