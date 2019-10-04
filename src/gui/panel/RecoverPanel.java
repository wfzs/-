package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecordListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel{
//	static{
//		GUIUtil.useLNF();
//	}
	public static RecoverPanel instance=new RecoverPanel();
	
	public JButton bRecover=new JButton("»Ö¸´");
	
	public RecoverPanel(){
		GUIUtil.setColor(ColorUtil.blueColor, bRecover);
		this.add(bRecover);
		addListener();
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(RecoverPanel.instance);
	}
	@Override
	public void updateDate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecordListener listener=new RecordListener();
		bRecover.addActionListener(listener);
	}
}
