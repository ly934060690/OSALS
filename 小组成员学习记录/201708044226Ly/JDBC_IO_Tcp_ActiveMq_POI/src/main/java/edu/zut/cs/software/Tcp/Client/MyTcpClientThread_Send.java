package edu.zut.cs.software.Tcp.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyTcpClientThread_Send extends Thread {

    private PrintWriter writer;
    Socket socket;

    @Override
    public void run() {
        System.out.println("尝试连接");
        try {
            socket = new Socket("0.0.0.0",8866);
            writer = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("连接成功");
        Scanner in = new Scanner(System.in);
        String string = null;

        writer.println("1");

        writer.println("你好，来自MyTcpClient_Send的连接");

        while(true) {
            string = in.nextLine();
            writer.println(string);
        }
    }
}
