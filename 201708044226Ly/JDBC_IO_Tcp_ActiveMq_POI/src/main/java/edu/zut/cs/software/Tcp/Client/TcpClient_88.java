package edu.zut.cs.software.Tcp.Client;

import java.util.Scanner;

public class TcpClient_88 {

    public static void main(String []args) {

        MyTcpClientThread_Send myTcpClientThread_send = new MyTcpClientThread_Send();


        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您要生产的ActiveMQQueueName：");
        String queueName1 = scanner.nextLine();

        System.out.print("请输入您要消费的ActiveMQQueueName：");
        String queueName2 = scanner.nextLine();

        TcpClientChatThread_Send tcpClientChatThread_send = new TcpClientChatThread_Send(queueName1);
        MyTcpClientThread_Listen myTcpClientThread_listen = new MyTcpClientThread_Listen(queueName2, 88);
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
