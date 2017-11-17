import java.io.*;
import java.util.ArrayList;

public class Executador {
    private static String inputCodificada;
    private static String outputCanal;
    private static String outputDecodificador;

    public static void main(String[] args) throws IOException{
        //double m[] = {0.5, 0.2, 0.1, 0.05, 0.02, 0.01, 0.005, 0.002, 0.0001, 0.0005, 0.00002, 0.00001, 0.00005, 0.00002, 0.000001};
        double m[] = {0.001,0.0002,0.0001,0.000005,0.000002};
        Codificador codificador = new Codificador();
        Decodificador decodificador = new Decodificador();
        Canal canal = new Canal();

        try {
            inputCodificada = codificador.codificar("input.txt");
        } catch (IOException e) {
            System.out.println("Input error.");
        }

        for(int i = 0; i<m.length; i++)
        {
            canal.setProbErro(m[i]);

            outputCanal = canal.processarString(inputCodificada);

            outputDecodificador = decodificador.decodificar(outputCanal);

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("redecodificado"+String.valueOf(m[i])+".txt"), "utf-8"))) {
                writer.write(outputDecodificador);
            }

        }

    }
}
