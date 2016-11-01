package com.endava.training;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        //count('a');
        System.out.println(Count.count('a'));
        System.out.println(Count.countRandom(' '));
        File input= new File("input.txt");
        reversed(input);

    }

    public static void reversed(File file)
    {
        RandomAccessFile raf = null;
        Writer writer = null;
        try {
            InputStream is = new FileInputStream("input.txt");
            Reader reader = new InputStreamReader(is);
            int data = 0;
            OutputStream os = new FileOutputStream("output.txt");
            writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();

            while(data != -1){
                char chr = (char) data;
                data = reader.read();
                writer.write(data);
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

