package gui.frame;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.panel.MainPanel;
import util.CenterPanel;

public class MainFrame extends JFrame{
	public static MainFrame instance=new MainFrame();
	
	public MainFrame(){
		this.setSize(500,450);
		this.setTitle("Ò»±¾ºýÍ¿ÕË");
		this.setContentPane(MainPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		instance.setVisible(true);		
        
	}
}
