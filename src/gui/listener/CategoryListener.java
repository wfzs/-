package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CategoryPanel p=CategoryPanel.instance;
		
		JButton b=(JButton)e.getSource();
		if(b==p.bAdd){
			String name=JOptionPane.showInputDialog(null);
			if(name==null)return;
			if(0==name.length()){
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
				return;
			}
			new CategoryService().add(name);
		}
		if(b==p.bEdit){
			Category c=p.getSelectedCategory();
			if(c==null){
				JOptionPane.showMessageDialog(p, "没选中数据");
				return;
			}
			int id=c.id;
			String name=JOptionPane.showInputDialog("修改分类名称",c.name);
			if(name==null)return;
			if(0==name.length()){
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
				return;
			}
			
			new CategoryService().update(id, name);
		}
		if(b==p.bDelete){
			Category c=p.getSelectedCategory();
			if(c==null){
				JOptionPane.showMessageDialog(p, "没选中数据");
				return;
			}
			if(0!=c.recordNumber){
				JOptionPane.showMessageDialog(p, "本分类下有记录消费，不能删除");
				return;
			}
			if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(p, "确认删除吗？"))
				return;
			
			int id=c.id;
			new CategoryService().delete(id);
		}
		p.updateDate();
	}

}
