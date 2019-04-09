package edu.zut.cs.software.Tcp.Client;
//客户端程序

import edu.zut.cs.software.IO.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class TcpClient_1 {
    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;
    private String activeMQ_Name;
    public void connect(){
        System.out.println("尝试连接");
        try{
            socket = new Socket("0.0.0.0",8866);
            writer = new PrintWriter(socket.getOutputStream(),true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("连接成功");

            writer.println("0");

            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入您要消费的ActiveMQQueueName：");
            activeMQ_Name = scanner.nextLine();
            writer.println(activeMQ_Name);

            writer.println("你好，来自TcpClient_1的连接");
            getserverMessage();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void getserverMessage(){
        try{
            while(true){
                String string = reader.readLine();
                Writer.Write_Tcp_Client(string, 1);
                System.out.println("TcpClient_1信息接收：" + string);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(reader != null){
                reader.close();
            }
            if(writer != null){
                writer.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TcpClient_1 tcpClient_1;
        tcpClient_1 = new TcpClient_1();
        tcpClient_1.connect();
    }
}


