package edu.zut.cs.software.ActiveMQ.topic;

public class ActiveMq_Topic_Consumer {

    public class Consumer implements Runnable {
        ActiveMq_Topic_Consumer_Demo activerMq_topic_consumer_demo;
        String TopicName;

        public Consumer(ActiveMq_Topic_Consumer_Demo activerMq_topic_consumer_demo, String topicName) {
            this.activerMq_topic_consumer_demo = activerMq_topic_consumer_demo;
            this.TopicName = topicName;
        }

        @Override
        public void run() {
            activerMq_topic_consumer_demo.getMessage(TopicName);
        }
    }

}
