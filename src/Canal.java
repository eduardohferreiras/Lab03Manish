import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Canal {

    Canal() {
        rand = new Random();
        msgProcessada = "";
    }

    private double _probErro;
    private String msgProcessada;
    private Random rand;

    public void setProbErro(double prob) {
        _probErro = prob;
    }

    private String processarErroBit(String bit) {
        if (rand.nextDouble() <= _probErro) {
            if (bit.equals("1")) {
                return "0";
            }
            return "1";
        }
        return bit;
    }

    public String processarString(String msg){

        for(int i = 0; i < msg.length(); i++)
        {
            msgProcessada = msgProcessada.concat(processarErroBit(msg.charAt(i) + ""));
        }
        return msgProcessada;
    }

    public void imprimirResultadoBSC() throws IOException
    {
        FileWriter fileWriter = new FileWriter("resultadoBSC.txt", false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter codifiedFile = new PrintWriter(bufferedWriter);
        codifiedFile.print(msgProcessada);
        codifiedFile.close();
    }

    public static void main(String args[]) throws IOException
    {
        String texto = "10101010101010";
        Canal canal = new Canal();
        canal.setProbErro(0.5);
        System.out.println(canal.processarString(texto));
        canal.imprimirResultadoBSC();
    }

}
