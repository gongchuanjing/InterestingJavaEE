package tk.chuanjing.chapter20.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

/**
 * 监听的演示
 * @author ChuanJing
 *
 */
public class MyFrame extends JFrame{
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setName("小黑");
		// 设置窗口的大小:
		frame.setBounds(0, 0, 200, 200);
		// 设置窗口显示:
		frame.setVisible(true);
		// 设置监听器:
		frame.addWindowListener(new MyWindowListener());
	}
}

class MyWindowListener implements WindowListener{

	public void windowClosing(WindowEvent event) {
		System.out.println("窗口正在关闭...");
		MyFrame frame = (MyFrame)event.getSource();
		System.out.println(frame.getName());
		System.exit(0);
	}
	
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public void windowDeactivated(WindowEvent arg0) {
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		
	}

	public void windowIconified(WindowEvent arg0) {
		
	}

	public void windowOpened(WindowEvent arg0) {
		
	}
	
}
