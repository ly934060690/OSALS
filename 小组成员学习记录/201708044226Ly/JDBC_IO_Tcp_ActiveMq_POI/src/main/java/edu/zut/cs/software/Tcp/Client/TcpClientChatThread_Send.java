package edu.zut.cs.software.Tcp.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClientChatThread_Send extends Thread {

    private PrintWriter writer;
    private String activeMQ_Name;
    Socket socket;

    public TcpClientChatThread_Send(String activeMQ_Name) {
        this.activeMQ_Name = activeMQ_Name;
    }

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

        writer.println("8");
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要生产的ActiveMQQueueName：");
        queueName = scanner.nextLine();
        */
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writer.println(activeMQ_Name);
        writer.println("你好，来自TcpClientChat_Send的连接");

        while(true) {
            string = in.nextLine();
            writer.println(string);
        }
    }
}
