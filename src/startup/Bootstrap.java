package startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

public class Bootstrap {
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		GUIUtil.useLNF();
		
		SwingUtilities.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instace);
			}
		});
	}
}
