import java.io.IOException;
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
        erros.add("0000000");

        sintomas.add("111");
        sintomas.add("101");
        sintomas.add("110");
        sintomas.add("011");
        sintomas.add("100");
        sintomas.add("010");
        sintomas.add("001");
        sintomas.add("000");
    }

    public String decodificar(String msg) {
        msgDecodificada = "";
        int counter = 0;
        String r = "";
          // só os primeiro 4 chars de v, os outros nao importam;
        for (char singleChar : msg.toCharArray()) {

            String v = "";
            String s = "";
            if (counter < 7) {
                r += singleChar;
                counter++;
                //System.out.println(1);
            } else {
                int r1 = Utils.char2int(r.charAt(0));
                int r2 = Utils.char2int(r.charAt(1));
                int r3 = Utils.char2int(r.charAt(2));
                int r4 = Utils.char2int(r.charAt(3));
                int r5 = Utils.char2int(r.charAt(4));
                int r6 = Utils.char2int(r.charAt(5));
                int r7 = Utils.char2int(r.charAt(6));

                int s1 = r1 + r2 + r3 + r5;
                s1 = s1 % 2;
                s += Utils.int2char(s1);

                int s2 = r1 + r3 + r4 + r6;
                s2 = s2 % 2;
                s += Utils.int2char(s2);

                int s3 = r1 + r2 + r4 + r7;
                s3 = s3 % 2;
                s += Utils.int2char(s3);



                int v1 = r1 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(0));
                v1 = v1 % 2;
                v += Utils.int2char(v1);

                int v2 = r2 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(1));
                v2 = v2 %2;
                v += Utils.int2char(v2);

                int v3 = r3 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(2));
                v3 = v3 % 2;
                v += Utils.int2char(v3);

                int v4 = r4 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(4));
                v4 = v4 % 2;
                v += Utils.int2char(v4);


                msgDecodificada += v;
                r = singleChar + "";
                counter = 1;
            }
        }
        String v = "";
        String s = "";

        int r1 = Utils.char2int(r.charAt(0));
        int r2 = Utils.char2int(r.charAt(1));
        int r3 = Utils.char2int(r.charAt(2));
        int r4 = Utils.char2int(r.charAt(3));
        int r5 = Utils.char2int(r.charAt(4));
        int r6 = Utils.char2int(r.charAt(5));
        int r7 = Utils.char2int(r.charAt(6));

        int s1 = r1 + r2 + r3 + r5;
        s1 = s1 % 2;
        s += Utils.int2char(s1);

        int s2 = r1 + r3 + r4 + r6;
        s2 = s2 % 2;
        s += Utils.int2char(s2);

        int s3 = r1 + r2 + r4 + r7;
        s3 = s3 % 2;
        s += Utils.int2char(s3);



        int v1 = r1 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(0));
        v1 = v1 % 2;
        v += Utils.int2char(v1);

        int v2 = r2 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(1));
        v2 = v2 %2;
        v += Utils.int2char(v2);

        int v3 = r3 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(2));
        v3 = v3 % 2;
        v += Utils.int2char(v3);

        int v4 = r4 + Utils.char2int(erros.get(sintomas.indexOf(s)).charAt(4));
        v4 = v4 % 2;
        v += Utils.int2char(v4);


        msgDecodificada += v;
        return msgDecodificada;
    }

    public static void main(String args[]) throws IOException
    {

        Decodificador deco = new Decodificador();
        String msg = "0110011000000001100110000000";
        System.out.println(deco.decodificar(msg));
    }
}
