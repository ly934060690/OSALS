package edu.zut.cs.lbw.logistics.dao;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/4/10
 * @Description: com.logistics.lbw.mian.dao.impl
 * @version: 1.0
 */
public interface ManagerDao
{
    public List<String> stuffs = null;

    public void Recruit();     //对仓库人员的管理  招聘

    public void Dismiss();     //解雇

    public void Job();        //任职


}
