package edu.zut.cs.software.Tcp.Client;

import edu.zut.cs.software.IO.Writer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyTcpClientThread_Listen extends Thread {

    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;
    private String activeMQ_Name;
    private Integer integer;


    public MyTcpClientThread_Listen(String activeMQ_Name, Integer integer) {
        super();
        this.activeMQ_Name = activeMQ_Name;
        this.integer = integer;
    }


    @Override
    public void run() {
        System.out.println("尝试连接");
        try{
            socket = new Socket("0.0.0.0",8866);
            writer = new PrintWriter(socket.getOutputStream(),true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("连接成功");

            writer.println("0");
/*
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入您要消费的ActiveMQQueueName：");
            queueName = scanner.nextLine();
*/

            writer.println(activeMQ_Name);

            writer.println("你好，来自MyTcpClient_Listen的连接");

            try{
                while(true){
                    String string = reader.readLine();
                    Writer.Write_Tcp_Client(string, integer);
                    System.out.println("MyTcpClient_Listen信息接收：" + string);
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
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
