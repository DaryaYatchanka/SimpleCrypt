package Crypto.src;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        ROT13 obj = new ROT13('a', 'p');

        String data = readFile("/Users/daryayatchanka/SimpleCrypt/sonnet18.txt");

        //encrypt data
        String encryptedData = obj.encrypt(data);

        //save encrypted data to file
        saveToFile(encryptedData);

        //open encrypted file
        String open = readFile("/Users/daryayatchanka/SimpleCrypt/sonnet18.enc");

        //decrypt data
        String shouldBeSame = obj.decrypt(open);

        System.out.println(shouldBeSame);


    }

    public static String readFile(String path) throws Exception {
        StringBuilder data = new StringBuilder();
        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            data.append(st);
            data.append("\n");
        }

        return data.toString();
    }

    public static void saveToFile(String text) throws Exception {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("/Users/daryayatchanka/SimpleCrypt/sonnet18.enc"));
            writer.write(text);

        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }
    }
}

