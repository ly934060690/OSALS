package edu.zut.cs.software.ActiveMQ.topic;

public class client_2_run {
    public static void main(String[] args) throws Exception {
        client_2 subscriber = new client_2();
        subscriber.receive();
    }
}
