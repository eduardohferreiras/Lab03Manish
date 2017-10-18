import java.util.ArrayList;

public class Decodificador {
    ArrayList<String> erros = new ArrayList<String>();
    ArrayList<String> sintomas = new ArrayList<String>();

    Decodificador()
    {
        preencherArrays();
    }

    private void preencherArrays ()
    {
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

    
}
