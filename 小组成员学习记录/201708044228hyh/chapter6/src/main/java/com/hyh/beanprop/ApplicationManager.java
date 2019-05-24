package com.hyh.beanprop;

/**
 * @Author: hyh
 * @Description:
 * @Date:Created in 15:22 2019/5/18
 * @Modified By:
 */
public class ApplicationManager {

    private int maxTabPageNum;

    private int sessionTimeout;


    public int getMaxTabPageNum() {
        return maxTabPageNum;
    }

    public void setMaxTabPageNum(int maxTabPageNum) {
        this.maxTabPageNum = maxTabPageNum;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
