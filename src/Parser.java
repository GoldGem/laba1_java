import java.util.Scanner;

public class Parser {
    private Scanner scanner;
    private String[] strArray;
    private int[] digitArray;
    private int[] powArray;
    private double a;
    private double b;
    private int length;
    private boolean flag;

    public Parser(String str) {
        this.scanner = new Scanner(System.in);
        this.strArray = str.split("\\+");
        this.digitArray = new int[1000];
        this.powArray = new int[1000];
        this.a = scanner.nextDouble();
        this.b = scanner.nextDouble();
        this.length = strArray.length;
        this.flag = false;
    }

    public String start() {
        Integral integral = new Integral();
        parser();
//        System.out.println();
        return Double.toString(integral.calculate(this.a, this.b, x -> f(x)));
    }

    public void parser() {
        for (int i = 0; i < this.length; i++) {
//            System.out.println(strArray[i]);
            this.digitArray[i] = 0;
            this.powArray[i] = 0;
            this.flag = false;
            for (int j = 0; j < this.strArray[i].length(); j++) {
//                System.out.println(strArray[i].charAt(j));
                if (this.strArray[i].charAt(j) == '^') this.flag = true;
                if ( Character.isDigit(this.strArray[i].charAt(j)) && !this.flag) {
                    this.digitArray[i] = this.digitArray[i] * 10 + Character.getNumericValue(this.strArray[i].charAt(j));
                }
                if ( Character.isDigit(this.strArray[i].charAt(j)) && this.flag) {
                    this.powArray[i] = this.powArray[i] * 10 + Character.getNumericValue(this.strArray[i].charAt(j));
                }
            }
            if (this.digitArray[i] == 0) this.digitArray[i] = 1;
            if (!this.flag) this.powArray[i] = 1;
//            System.out.println(digitArray[i]);
//            System.out.println(powArray[i]);
        }
    }

    public double f(double x) {
        double result = 0;
        for (int i = 0; i < this.length; i++) {
            result += Math.pow(this.digitArray[i] * x, this.powArray[i]);
        }
        return result;
    }
}
