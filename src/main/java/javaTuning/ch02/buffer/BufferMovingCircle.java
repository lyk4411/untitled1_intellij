package javaTuning.ch02.buffer;

import java.awt.Color;
import java.awt.Graphics;

public class BufferMovingCircle extends NoBufferMovingCircle {
	Graphics doubleBuffer = null;					//������

	public void init() {
		super.init();
		doubleBuffer = screenImage.getGraphics();
	}

	public void paint(Graphics g) {
		doubleBuffer.setColor(Color.white);			//�����ڴ��л�ͼ
		doubleBuffer.fillRect(0, 0, 200, 100);
		drawCircle(doubleBuffer);
		
		g.drawImage(screenImage, 0, 0, this);		//��bufferһ������ʾ����
	}
}
