import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class SM4 {
	private JFrame frame;
	private JPanel panel;
	List<Image> pictureList = new ArrayList<Image>();
	private int indx;
	private double interval=1;
	
	public static void main(String [] args) {
		SM4 sm= new SM4();
		sm.go();
	}
	
	public void go() {
		frame=new JFrame();
		panel=new Panel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.setSize(400, 500);
		frame.setTitle("Jednorêki Bandyta");
		frame.setVisible(true);
		
		String currentDirName;
		try {
			currentDirName = new File( "." ).getCanonicalPath();
			File currentDir = new File(currentDirName);
			String [] dirlist = currentDir.list();
			for (String f : dirlist) {
				if (f.endsWith(".png" ) || f.endsWith(".jpg") || f.endsWith(".gif")) {				// !new File(f).isDirectory()
					System.out.println(f);
					pictureList.add(new ImageIcon(f).getImage());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (interval<1000) {
			try {
				Thread.sleep((long) interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			indx=(indx+1)%pictureList.size();
			//System.out.println(indx+"  "+interval);
			interval*=1.15;
			panel.repaint();
		}
		
		
						
	}
	
	class Panel extends JPanel {
		public void paintComponent(Graphics g1) {
			Graphics2D g = (Graphics2D) g1;
			
			
			class DrawPict extends Panel{
				public DrawPict(int position) {
					g.drawImage(pictureList.get(indx), position, 100, this);
				}
			}
			for (int x=100; x<300; x+=90){
				DrawPict dp1 = new DrawPict(x);
			}
				
			
		}
	}

}
