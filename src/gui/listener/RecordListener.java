package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RecordPanel p=RecordPanel.instance;
		if(null==p.cbModel.cs)
			return;
		if(0==p.cbModel.cs.size()){
			JOptionPane.showMessageDialog(p, "�������ѷ��࣬�޷���ӣ�����������ѷ���");
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		if(!GUIUtil.checkZero(p.tfSpend, "���ѽ��"))
			return;
		int spend=Integer.parseInt(p.tfSpend.getText());
		Category c=p.getSelectedCategory();
		String comment=p.tfcomment.getText().trim();
		Date date=p.datePicker.getDate();
		new RecordService().add(spend, c, comment, date);
		JOptionPane.showMessageDialog(p, "��ӳɹ�");
		
		MainPanel.instance.workingPanel.show(SpendPanel.instace);
	}

}
