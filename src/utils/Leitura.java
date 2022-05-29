package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String entDados(String str){
        String inputString = "";
        try{
            System.out.print(str);
            inputString =  br.readLine();
        }catch(IOException e){
            System.out.println("Falha na entrada de dados!");
        }
        return inputString;
    }
}
