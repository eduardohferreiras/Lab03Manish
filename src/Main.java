import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static void inputGenerator(int wordLength, int totalBits) throws IOException {
        FileWriter fileWriter = new FileWriter("input.txt", false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter inputFile = new PrintWriter(bufferedWriter);

        int bits = 0;
        Random rand = new Random();
        while (bits < totalBits) {
            for (int i=0; i<wordLength; i++) {
                if (rand.nextDouble() <= 0.5) {
                    inputFile.print("0");
                } else {
                    inputFile.print("1");
                }
            }

            bits+=wordLength;
        }

        inputFile.close();
    }

    private static double compareTexts(String inputName, String outputName) throws FileNotFoundException {
        // Reading files
        Scanner input = new Scanner(new FileReader(inputName));
        Scanner output = new Scanner(new FileReader(outputName));

        StringBuilder sb = new StringBuilder();
        while(input.hasNext()) {
            sb.append(input.next());
        }
        input.close();
        String inputText = sb.toString();

        StringBuilder sbOut = new StringBuilder();
        while(output.hasNext()) {
            sbOut.append(output.next());
        }
        output.close();
        String outputText = sbOut.toString();
        // Reading ended

        double difference = 0;
        double total = (double)inputText.length();

        for (int i=0; i<inputText.length(); i++) {
            if (inputText.charAt(i) != outputText.charAt(i)) {
                difference ++;
            }
        }
        return difference/total;

    }

    public static void main(String [] args) {

        double m[] = {0.001,0.0002,0.0001,0.000005,0.000002};
        //double m[] = {0.5, 0.2, 0.1, 0.05, 0.02, 0.01, 0.005, 0.002, 0.0001, 0.00005, 0.00002, 0.00001, 0.00005, 0.00002, 0.000001};
        //double m [] = {0.5, 0.2, 0.1, 0.05, 0.02, 0.01, 0.005, 0.002, 0.0001, 0.0005, 0.00002, 0.00001, 0.00005, 0.00002, 0.000001};
        for(int i = 0; i < m.length; i++)
        {
            try {
                double value = compareTexts("input.txt", "redecodificado" + String.valueOf(i) + ".txt");
                System.out.println(m[i] + " "+ value);
            } catch (FileNotFoundException e) {}

        }
    }
}
