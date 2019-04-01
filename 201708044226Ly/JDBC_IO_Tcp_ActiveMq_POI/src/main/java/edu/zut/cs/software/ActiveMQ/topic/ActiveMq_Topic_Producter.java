package edu.zut.cs.software.ActiveMQ.topic;

public class ActiveMq_Topic_Producter {
    public class Productor implements Runnable {
        private ActiveMq_Topic_Producter_Demo activeMq_topic_producter_demo;
        private String TopicName;
        private String Message_Date;

        public Productor(ActiveMq_Topic_Producter_Demo activeMq_topic_producter_demo, String topicName, String message_Date) {
            this.activeMq_topic_producter_demo = activeMq_topic_producter_demo;
            this.TopicName = topicName;
            Message_Date = message_Date;
        }

        @Override
        public void run() {
            activeMq_topic_producter_demo.sendMessage(TopicName, Message_Date);
        }
    }
}
