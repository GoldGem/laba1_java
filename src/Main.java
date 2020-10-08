import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        while (!(str = scanner.nextLine()).equals("exit")) {
            Parser parse = new Parser(str);
            System.out.println(parse.start());
        }
    }

}
