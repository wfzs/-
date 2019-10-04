package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category>{
//	public List<String> cs=new ArrayList();
	public List<Category> cs=new CategoryService().list();
	public Category c;
	
//	String c;
	public CategoryComboBoxModel() {
		// TODO Auto-generated constructor stub
//		cs.add("餐饮");
//		cs.add("交通");
//		cs.add("住宿");
//		cs.add("话费");
		if(!cs.isEmpty())
			c=cs.get(0);
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return cs.size();
	}

	@Override
	public Category getElementAt(int index) {
		// TODO Auto-generated method stub
		return cs.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		c=(Category)anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		if(!cs.isEmpty())
			return c;
		else
			return null;
	}
	
}
