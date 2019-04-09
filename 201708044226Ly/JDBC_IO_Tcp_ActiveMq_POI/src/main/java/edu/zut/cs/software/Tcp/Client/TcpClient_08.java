package edu.zut.cs.software.Tcp.Client;

import java.util.Scanner;

public class TcpClient_08 {
    public static void main(String []args) {
        MyTcpClientThread_Send myTcpClientThread_send = new MyTcpClientThread_Send();


        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要生产的ActiveMQ_TopicName：");
        String activeMQ_Name1 = scanner.nextLine();

        System.out.print("请输入您要消费的ActiveMQ_TopicName：");
        String activeMQ_Name2 = scanner.nextLine();

        TcpClientChatThread_Send tcpClientChatThread_send = new TcpClientChatThread_Send(activeMQ_Name1);
        MyTcpClientThread_Listen myTcpClientThread_listen = new MyTcpClientThread_Listen(activeMQ_Name2, 8);
        tcpClientChatThread_send.start();
//        myTcpClientThread_send.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myTcpClientThread_listen.start();

    }
}
