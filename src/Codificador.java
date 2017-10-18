import java.io.*;
import java.util.Scanner;

public class Codificador {

    public static String codificar(String fileName) throws IOException {

        Scanner input = new Scanner(new FileReader(fileName));

        StringBuilder sb = new StringBuilder();
        while(input.hasNext()) {
            sb.append(input.next());
        }
        input.close();
        String text = sb.toString();

        String codified = "";
        String b = "";
        int counter = 0;
        for (char singleChar : text.toCharArray()) {
            if (counter < 4) {
                b += singleChar;
                counter++;
            } else {
                int b1 = char2int(b.charAt(0));
                int b2 = char2int(b.charAt(1));
                int b3 = char2int(b.charAt(2));
                int b4 = char2int(b.charAt(3));

                int p1 = b1 + b2 + b3;
                p1 = p1 % 2;
                b += int2hcar(p1);

                int p2 = b1 + b3 + b4;
                p2 = p2 % 2;
                b += int2hcar(p2);

                int p3 = b1 + b2 + b4;
                p3 = p3 % 2;
                b += int2hcar(p3);

                codified += b;
                b = Character.toString(singleChar);
                counter = 0;
            }
        }
        int b1 = char2int(b.charAt(0));
        int b2 = char2int(b.charAt(1));
        int b3 = char2int(b.charAt(2));
        int b4 = char2int(b.charAt(3));

        int p1 = b1 + b2 + b3;
        p1 = p1 % 2;
        b += int2hcar(p1);

        int p2 = b1 + b3 + b4;
        p2 = p2 % 2;
        b += int2hcar(p2);

        int p3 = b1 + b2 + b4;
        p3 = p3 % 2;
        b += int2hcar(p3);

        codified += b;

        input.close();
        return codified;
    }

    private static int char2int (char c) {
        if (c == '1') {
            return 1;
        }
        return 0;
    }

    private static String int2hcar (int i) {
        if (i==0) {
            return "0";
        }
        return "1";
    }

    public static void main(String [] args) {

        try {

            exp = codificar("input.txt");
        } catch (IOException e) {
            System.out.println("erro");
        }
        System.out.println(exp);
    }

    static String exp;
    static String file = "input.txt";

}
