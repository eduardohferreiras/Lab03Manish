import java.util.ArrayList;

public class Decodificador {

    private ArrayList<String> erros = new ArrayList<>();
    private ArrayList<String> sintomas = new ArrayList<>();
    private String msgDecodificada;

    Decodificador() {
        preencherArrays();
    }

    private void preencherArrays() {
        erros.add("1000000");
        erros.add("0100000");
        erros.add("0010000");
        erros.add("0001000");
        erros.add("0000100");
        erros.add("0000010");
        erros.add("0000001");

        sintomas.add("111");
        sintomas.add("101");
        sintomas.add("110");
        sintomas.add("011");
        sintomas.add("100");
        sintomas.add("010");
        sintomas.add("001");
    }

    public String decodificar(String msg) {
        msgDecodificada = "";
        int counter = 0;
        for (char singleChar : msg.toCharArray()) {
            String r = "";
            String s = "";
            String v = ""; // só os primeiro 4 chars de v, os outros nao importam;

            if (counter < 7) {
                r += singleChar;
                counter++;
            } else {
                int r1 = char2int(b.charAt(0));
                int r2 = char2int(b.charAt(1));
                int r3 = char2int(b.charAt(2));
                int r4 = char2int(b.charAt(3));
                int r5 = char2int(b.charAt(4));
                int r6 = char2int(b.charAt(5));
                int r7 = char2int(b.charAt(6));

                int s1 = r1 + r2 + r3 + r5;
                s1 = s1 % 2;
                s += int2hcar(s1);

                int s2 = r1 + r3 + r4 + r6;
                s2 = s2 % 2;
                s += int2hcar(s2);

                int s3 = r1 + r2 + r4 + r7;
                s3 = s3 % 2;
                s += int2hcar(s3);

                int v1 = r1 + char2int(erros.get(sintomas.indexOf(s)).charAt(0));
                v1 = v1 % 2;
                v += int2Char(v1);

                int v2 = r2 + char2int(erros.get(sintomas.indexOf(s)).charAt(1));
                v2 = v2 %2;
                v += int2Char(v2);

                int v3 = r3 + char2int(erros.get(sintomas.indexOf(s)).charAt(2));
                v3 = v3 % 2;
                v += int2Char(v3);

                int v4 = r4 + char2int(erros.get(sintomas.indexOf(s)).charAt(4));
                v4 = v4 % 2;
                v += int2Char(v4);

                msgDecodificada += v;
            }
        }
        return msgDecodificada;
    }
}
