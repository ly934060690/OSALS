package edu.zut.cs.software.Tcp.Server;

import edu.zut.cs.software.ActiveMQ.topic.ActiveMq_Topic_Producter;
import edu.zut.cs.software.ActiveMQ.topic.ActiveMq_Topic_Producter_Demo;
import edu.zut.cs.software.JDBC.Message;
import edu.zut.cs.software.JDBC.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TcpServerChatThread_Listen extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String queueName;

    public TcpServerChatThread_Listen(Socket socket) {
        super();
        this.socket = socket;
        start();
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);

//            ActiveMq_Producter_Demo activeMq_producter_demo = new ActiveMq_Producter_Demo();
//            activeMq_producter_demo.init();
            ActiveMq_Topic_Producter_Demo activeMq_topic_producter_demo = new ActiveMq_Topic_Producter_Demo();
            activeMq_topic_producter_demo.init();

            System.out.println("TcpServerThread_Listen_OK!");
            queueName = reader.readLine();

            System.out.println("queueName:" + queueName);
            while(true) {

                String message = reader.readLine();
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String date = simpleDateFormat.format(calendar.getTime());
                Operation.insert(new Message(message, date));
                System.out.println("TcpServerThread_Listen客户端信息接收："+ message);
//                ActiveMq_Producter activeMq_producter = new ActiveMq_Producter();
//                new Thread(activeMq_producter.new Productor(activeMq_producter_demo, queueName, message + " (" + date + ") ")).start();
                ActiveMq_Topic_Producter activeMq_topic_producter = new ActiveMq_Topic_Producter();
                new Thread(activeMq_topic_producter.new Productor(activeMq_topic_producter_demo, queueName, message + " (" + date + ") ")).start();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

