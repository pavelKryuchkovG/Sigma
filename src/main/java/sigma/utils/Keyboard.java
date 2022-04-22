package sigma.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {

    public String getDataFromKeyBoard() {
        BufferedReader bufferedReader;
        String result = "";
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
