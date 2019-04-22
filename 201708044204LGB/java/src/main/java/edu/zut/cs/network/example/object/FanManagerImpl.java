package edu.zut.cs.network.example.object;

import java.util.ArrayList;
import java.util.List;

public class FanManagerImpl implements FanManager {

    List<Fan> list;

    private void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Fan f = new Fan();
            f.setId(Long.valueOf(i + 1));
            this.list.add(f);
        }
    }

    public FanManagerImpl() {
        this.init();
    }

    @Override
    public List<Fan> getAll() {
        return this.list;
    }

    @Override
    public Fan getById(Long Id) {
        for (Fan fan : list) {
            if (Id.equals(fan.getId())) {
                return fan;
            }
        }
        return null;
    }

}
