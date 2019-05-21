public class SequenceNumber {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>();

    public Integer initialValue(){
        return 0;
    }

    public int getNextNum(int i,SequenceNumber sequenceNumber){
        if(i==0)
            seqNum.set(sequenceNumber.initialValue());
        else
            seqNum.set(seqNum.get()+1);
        return seqNum.get();

    }

    public static void main(String[] args){
        SequenceNumber sequenceNumber = new SequenceNumber();

        TestClient t1 = new TestClient(sequenceNumber);
        TestClient t2 = new TestClient(sequenceNumber);
        TestClient t3 = new TestClient(sequenceNumber);

        t1.start();
        t2.start();
        t3.start();
    }

    public static class TestClient extends Thread{
        private SequenceNumber sequenceNumber;
        public TestClient(SequenceNumber sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
        }
        public void run(){
            for(int i=0;i<100;i++){
                System.out.println("thread["+Thread.currentThread().getName()+"] sn["+sequenceNumber.getNextNum(i,sequenceNumber)+"]");
            }
        }
    }
}
