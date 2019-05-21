package edu.zut.cs.software.IO;

import java.io.*;

public class Writer {
    public Writer() {
    }

    public static void Write_Tcp_Client(String string, Integer integer) {
        try {
            PrintWriter printWriter =
                    new PrintWriter(new FileWriter("D:/Java/Java_Practice__SC/JDBC_IO_Tcp_ActiveMQ_POI/src/main/java/edu/zut/cs/software/Txt/Tcp_Client_" + integer + "_Txt", true));
            /*
            printWriter.append("1");
            printWriter.append("2");
            printWriter.append("213");
            printWriter.write("999");
            printWriter.println("dsdsa");
            */
            printWriter.println(string);

            printWriter.flush();
            printWriter.close();
            System.out.println("Tcp_Client_" + integer + "所接收的信息已存入文件中！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
