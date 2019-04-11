package edu.zut.cs.lbw.logistics.dao.impl;

import edu.zut.cs.lbw.logistics.dao.ManagerDao;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/10
 * @Description: com.logistics.lbw.mian.dao.impl
 * @version: 1.0
 */
public class ManagerDaoImpl implements ManagerDao
{
    private List<String> Stuffs;

    public List<String> getStuffs()
    {

        return Stuffs;
    }

    public void setStuffs(List<String> stuffs)
    {
        Stuffs = stuffs;
    }

    @Override
    public void Recruit()
    {

    }

    @Override
    public void Dismiss()
    {

    }

    @Override
    public void Job()
    {

    }
}

