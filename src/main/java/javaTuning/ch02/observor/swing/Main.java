package javaTuning.ch02.observor.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	public static class BtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("click");
		}
	}
	public static void main(String args[]){
		JFrame   p=new JFrame  ();
		JButton btn=new JButton("Click ME");
		btn.addActionListener(new BtnListener());
		p.add(btn);
		p.pack();
		p.setVisible(true);
	}
}
