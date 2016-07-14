package com.wenhuisoft.chapter4;

/**
 * Created by lyk on 2016/7/12.
 * Package name: com.wenhuisoft.chapter4
 * Porject name: untitled1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 秒表程序演示 * * @author wangwenjun(Alex) 主要是为了加深对wait.notify方法的理解
 */
public class StopWatch extends JFrame {
    private static final long serialVersionUID = -5212710477644044656L;
    private final JLabel label = new JLabel("00:00:000");
    private JButton button1 = new JButton("Start");
    private JButton button2 = new JButton("Suspend");
    private JButton button3 = new JButton("Clear");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private CommandThread command = null;
    private final ClockDisplay clockDisplay = new ClockDisplay();

    public StopWatch() {
        super("秒表小程序");
    }

    public void init() {
        setLayout(new BorderLayout());
        setSize(250, 120);
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label);
        command = new CommandThread(clockDisplay, label);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        button1.addActionListener(command);
        button2.addActionListener(command);
        button3.addActionListener(command);
        add(BorderLayout.NORTH, panel1);
        add(BorderLayout.CENTER, panel2);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StopWatch().init();
    }
}

class CommandThread implements Runnable, ActionListener {
    private boolean flag = true;
    private ClockDisplay clockDisplay = null;
    private JLabel label = null;
    private Thread t = null;
    private boolean hasStart = false;
    private boolean start = false;

    public CommandThread(ClockDisplay display, JLabel label) {
        this.clockDisplay = display;
        this.label = label;
        t = new Thread(this);
    }

    public void run() {
        while (flag) {
            try {
                start();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void start() {
        synchronized (clockDisplay) {
            if (start) {
                label.setText(clockDisplay.refresh());
            } else {
                try {
                    clockDisplay.wait();
                    //wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void close() {
        this.flag = false;
    }

    private void command(String type) {
        synchronized (clockDisplay) {
            if (type.equalsIgnoreCase("start"))// 启动
            {
                start = true;
                if (!hasStart) {
                    t = new Thread(this);
                    hasStart = true;
                    t.start();
                }
                clockDisplay.notify();
                //notify();
            } else if (type.equalsIgnoreCase("clear")) //停止
            {
                start = false;
                clockDisplay.clear();
                label.setText(clockDisplay.toString());
            } else {//暂停
                start = false;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        command(e.getActionCommand());
    }
}

class ClockDisplay {
    private int minute = 0;
    private int second = 0;
    private int millsecond = 0;

    public ClockDisplay() {
    }

    public void clear() {
        this.minute = 0;
        this.second = 0;
        this.millsecond = 0;
    }

    public String refresh() {
        if (millsecond >= 999) {
            second++;
            millsecond = 0;
        } else {
            millsecond++;
        }
        if (second >= 59) {
            minute++;
            second = 0;
        }
        return toString();
    }

    public String toString() {
        return String.format("%02d", minute) + ":" + String.format("%02d", second) + ":" +
                String.format("%03d", millsecond);
    }
}