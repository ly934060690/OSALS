package edu.zut.cs.software.ActiveMQ.topic;

public class client_1_run {
    public static void main(String[] args) throws Exception {
        client_1 publish= new client_1();
        publish.sendMessage();
    }
}

