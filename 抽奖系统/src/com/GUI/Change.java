package com.GUI;

import java.io.*;

public class Change {
    static String name;
    static String apass;
    public Change(){
        try{
            File file = new File("C:\\Users\\28135\\IdeaProjects\\Test\\1.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            name = br.readLine();
            apass = br.readLine();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void changepass(String str){
        try{
            File file = new File("C:\\Users\\28135\\IdeaProjects\\Test1.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(name);
            bw.newLine();
            bw.write(str);
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
