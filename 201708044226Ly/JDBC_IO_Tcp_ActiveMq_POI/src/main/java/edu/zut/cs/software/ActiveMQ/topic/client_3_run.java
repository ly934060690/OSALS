package edu.zut.cs.software.ActiveMQ.topic;

public class client_3_run {
    public static void main(String[] args) throws Exception {
        client_3 subscriber = new client_3();
        subscriber.receive();
    }
}
