import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CodificadorGray {

    static String exp;
    static String file = "input.txt";

    public static String codificar(String fileName) throws IOException {
        Scanner input = new Scanner(new FileReader(fileName));

        StringBuilder sb = new StringBuilder();
        while(input.hasNext()) {
            sb.append(input.next());
        }
        input.close();
        String text = sb.toString();
        return CodificadorGray.codificarString(text);
    }

    public static String codificarString(String text) {
        String codified = "";
        String b = "";
        int counter = 0;
        for (char singleChar : text.toCharArray()) {
            if (counter < 4) {
                b += singleChar;
                counter++;
            } else {
                int b4 = Utils.char2int(b.charAt(0));
                int b3 =  Utils.char2int(b.charAt(1));
                int b2 =  Utils.char2int(b.charAt(2));
                int b1 =  Utils.char2int(b.charAt(3));

                int sum = b4*1000 + b3*100 + b2*10 + b1;
                int p = CodificadorGray.getPs(sum);
                System.out.println(sum);
                int p1 = p%10;
                int p2 = (p%10) / 10;
                int p3 = (p%100) / 100;

                b += Utils.int2char(p1);
                b += Utils.int2char(p2);
                b += Utils.int2char(p3);
                codified += b;
                b = Character.toString(singleChar);
                counter = 1;
            }
        }
        int b4 = Utils.char2int(b.charAt(0));
        int b3 = Utils.char2int(b.charAt(1));
        int b2 = Utils.char2int(b.charAt(2));
        int b1 = Utils.char2int(b.charAt(3));

        int sum = b4*1000 + b3*100 + b2*10 + b1;
        int p = CodificadorGray.getPs(sum);
        System.out.println(sum);
        int p1 = p%10;
        int p2 = (p/10) % 10;
        int p3 = (p/100) % 100;

        b += Utils.int2char(p1);
        b += Utils.int2char(p2);
        b += Utils.int2char(p3);

        codified += b;

        return codified;
    }

    private static int getPs(int b) {
        if (b==0 || b==1111) {
            return 0;
        }
        if (b==1 || b==1110) {
            return 111;
        }
        if (b==11 || b==1100) {
            return 1;
        }
        if (b==10 || b==1101) {
            return 110;
        }
        if (b==110 || b==1001) {
            return 10;
        }
        if (b==100 || b==1011) {
            return 101;
        }
        if (b==101 || b==1010) {
            return 11;
        }
        if (b==111 || b==1000) {
            return 100;
        }
        return 0;
    }

    public static void main(String [] args) {

        String coded = CodificadorGray.codificarString("00001110");
        System.out.println(coded);

//        try {
//            exp = codificar("input.txt");
//            System.out.println(exp);
//        } catch(IOException e) {
//            System.out.println("erro");
//        }
    }

}
