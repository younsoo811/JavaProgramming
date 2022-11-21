package java10;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileList {
    public static void listDirectory(File dir) {
        File[] subFiles = dir.listFiles();

        for (int i = 0; i < subFiles.length; i++) {
            File f = subFiles[i];
            String res = "", tb = "";

            if (f.isDirectory()) res = "dir\t\t";
            else if (f.isFile()) res = "file\t";
            System.out.print(res);
            if (f.length() > 999999) tb = "바이트\t\t";
            else if (f.length() > 99) tb = "바이트\t\t\t";
            else tb = "바이트\t\t\t\t";

            System.out.print(f.length() + tb);
            System.out.println(f.getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("***** 파일 탐색기입니다. *****");
        String res = "C:", fname = "", str="";
        File f1;

        Scanner s = new Scanner(System.in);
        while(true) {
            f1 = new File(res);
            System.out.println("[" + f1.getPath() + "]");

            if(!f1.exists()) {
                System.out.println("해당 디렉터리는 존재하지 않습니다.!");
                fname="..";
            }
            else {
                listDirectory(new File(res));

                System.out.print(">>");
                fname = s.nextLine();
            }

            if(fname.equals("그만")) break;
            else if (fname.equals("..")) {
                StringTokenizer del = new StringTokenizer(res, "\\");
                while(del.hasMoreTokens()) {
                    str = del.nextToken();
                }
                res = res.replace("\\"+str, "");
                fname=null;
            }
            else{
                StringTokenizer st = new StringTokenizer(fname, " ");

                String tk = st.nextToken();

                if(tk.equals("mkdir")){
                    try{
                        String dirName = st.nextToken();
                        File f2 = new File(res+dirName);
                        if(!f2.exists()){
                            f2.mkdir();
                            System.out.println(dirName+" 디렉터리를 생성하였습니다.");
                        }
                        else
                            System.out.println(dirName+" 디렉터리명이 존재합니다.");
                    }
                    catch(NoSuchElementException e){
                        System.out.println("생성할 디렉터리명이 주어지지 않았습니다.!");
                    }

                }
                else if(tk.equals("rename")){
                    try{
                        String oriName = st.nextToken();
                        String cName = st.nextToken();
                        File f3 = new File(res+oriName);
                        if(f3.exists()) {
                            f3.renameTo(new File(res + cName));
                            System.out.println(oriName+"를"+cName+" 이름 변경하였습니다.");
                        }
                        else
                            System.out.println("디렉터리명 "+oriName+"을 찾을 수 없습니다.");
                    }
                    catch(NoSuchElementException e){
                        System.out.println("두개의 파일명이 주어지지 않았습니다.!");
                    }
                }
                else{
                    res = res + "\\" + fname;
                }
            }
        }
    }
}
