package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel{
//	static{
//		GUIUtil.useLNF();
//	}
	public static ConfigPanel instance=new ConfigPanel();
	JLabel lMonthBudget=new JLabel("本月预算(￥)");
	JLabel lInstallation=new JLabel("Mysql安装目录");
	
	public JTextField tfBudget=new JTextField("0");
	public JTextField tfInstallation=new JTextField();
	
	public JButton bUpdate=new JButton("更新");
	
	public ConfigPanel(){
		JPanel pInput=new JPanel();
		JPanel pSubmit=new JPanel();
		GUIUtil.setColor(ColorUtil.graayColor, lMonthBudget,lInstallation);
		GUIUtil.setColor(ColorUtil.blueColor, bUpdate);
		pInput.setLayout(new GridLayout(4,1,40,40));
		pInput.add(lMonthBudget);
		pInput.add(tfBudget);
		pInput.add(lInstallation);
		pInput.add(tfInstallation);
		
		pSubmit.add(bUpdate);
		
		this.setLayout(new BorderLayout());
		this.add(pInput,BorderLayout.NORTH);
		this.add(pSubmit,BorderLayout.CENTER);
		
		addListener();
	}
	public void addListener() {
		// TODO Auto-generated method stub
		ConfigListener i=new ConfigListener();
		bUpdate.addActionListener(i);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}
	@Override
	public void updateDate() {
		// TODO Auto-generated method stub
		String budget=new ConfigService().get(ConfigService.budget);
		String mysqlPath=new ConfigService().get(ConfigService.mysqlPath);
		tfBudget.setText(budget);
		tfInstallation.setText(mysqlPath);
		tfBudget.grabFocus();
	}
}
