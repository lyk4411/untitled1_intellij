package com.wenhuisoft.chapter7;

/**
 * Created by lyk on 2016/7/13.
 * Package name: com.wenhuisoft.chapter7
 * Porject name: untitled1
 */
public interface ThreadListener {
    /**
     * when thread business start this method will invoke * @param args * @return
     */
    public Object threadStart(Object[] args);

    /**
     * running * @param args * @return
     */
    public Object threadRunning(Object[] args);

    /**
     * normal finish * @param args * @return
     */
    public Object threadFinish(Object[] args);

    /**
     * exception * @param args * @return
     */
    public Object threadException(Object[] args);
}
