package com.endava.training;

import java.io.*;

/**
 * Created by inastase on 11/1/2016.
 */
public class Count {

    public static int count(char c){
        int nr= 0;
        int bufferSize = 8 * 1024;

        try {
            BufferedReader br = new BufferedReader(new FileReader("inputFile.txt"), bufferSize);
            while(br.readLine() != null){
                String linie = br.readLine();
                for( int i = 0; i<linie.length(); i++){
                    if(c == linie.charAt(i)){
                        nr ++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nr;
    }

    public static int countRandom(char c){
        int nr = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile("inputFile.txt","rw");
            raf.seek(10);
            int pointer = (int) Math.toIntExact(raf.getFilePointer());
            int ch = raf.read();
            while(ch != -1){
                char character = (char) ch;
                if( character == c){
                    nr++;
                }
                ch = raf.read();
            }
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nr;
    }
}
