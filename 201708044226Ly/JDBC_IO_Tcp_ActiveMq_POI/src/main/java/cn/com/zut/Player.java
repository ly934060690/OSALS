package cn.com.zut;

public class Player {

    private static int count = 0;

    public Player(){
        count++;
    }

    public  static Player getPlayer() {
        if(count == 11) return null;
        return new Player();
    }
}
