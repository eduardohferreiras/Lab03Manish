import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DecodificadorGray {

    public static String decodificar(String fileName) throws IOException {
        Scanner input = new Scanner(new FileReader(fileName));

        StringBuilder sb = new StringBuilder();
        while(input.hasNext()) {
            sb.append(input.next());
        }
        input.close();
        String text = sb.toString();
        return DecodificadorGray.decodificarString(text);
    }

    public static String decodificarString(String text) {
        String msgDecodificada = "";
        String msg = "";
        String redundancia = "";

        int counter = 0;
        for (char singleChar : text.toCharArray()) {
            if (counter < 4) {
                msg += singleChar;
            } else {
                redundancia += singleChar;
            }

            counter ++;
            if (counter == 7) {
                msgDecodificada += DecodificadorGray.decodificarSingle(msg, redundancia);
                msg = "";
                redundancia = "";
                counter = 0;
            }
        }
        return msgDecodificada;
    }

    private static String decodificarSingle(String msg, String redundancia) {
        if (isAMatch(msg, redundancia)) {
            return msg;
        }

        // Try to change only one bit
        for (int i=0; i<4; i++) {
            char[] newMsg = msg.toCharArray();

            if (newMsg[i] == '0') {
                newMsg[i] = '1';
            } else {
                newMsg[i] = '0';
            }
            if (isAMatch(String.valueOf(newMsg), redundancia)) {
                return String.valueOf(newMsg);
            }
        }

        return msg;
    }

    private static boolean isAMatch(String msg, String redundancia) {
        switch (redundancia) {
            case "000":
                if (msg.equals("0000") || msg.equals("1111")) {
                    return true;
                }
                break;
            case "111":
                if (msg.equals("0001") || msg.equals("1110")) {
                    return true;
                }
                break;
            case "001":
                if (msg.equals("0011") || msg.equals("1100")) {
                    return true;
                }
                break;
            case "110":
                if (msg.equals("0010") || msg.equals("1101")) {
                    return true;
                }
                break;
            case "010":
                if (msg.equals("0110") || msg.equals("1001")) {
                    return true;
                }
                break;
            case "101":
                if (msg.equals("0100") || msg.equals("1011")) {
                    return true;
                }
                break;
            case "011":
                if (msg.equals("0101") || msg.equals("1010")) {
                    return true;
                }
                break;
            case "100":
                if (msg.equals("0111") || msg.equals("1000")) {
                    return true;
                }
                break;
        }
        return false;
    }

    public static void main(String [] args) {
        String coded = DecodificadorGray.decodificarString("00000001110111");
        System.out.println(coded);
    }

}
