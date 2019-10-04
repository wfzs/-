package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ConfigPanel p=ConfigPanel.instance;
		if(!GUIUtil.checkNumber(p.tfBudget, "����Ԥ��"))
			return;
		String mysqlPath=p.tfInstallation.getText().trim();
		if(0!=mysqlPath.length()){
			File commandFile=new File(mysqlPath,"bin/mysql.exe");
			if(!commandFile.exists()){
				JOptionPane.showMessageDialog(p, "Mysql·������ȷ");
				p.tfInstallation.grabFocus();
				return;
			}
		}
		ConfigService cService=new ConfigService();
		cService.update(ConfigService.budget, p.tfBudget.getText());
		cService.update(ConfigService.mysqlPath, mysqlPath);
		
		JOptionPane.showMessageDialog(p, "���óɹ�");
	}

}
