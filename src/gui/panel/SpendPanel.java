package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends WorkingPanel{
//	static{
//		GUIUtil.useLNF();
//	}
	public static SpendPanel instace=new SpendPanel();
	
	public JLabel lMonthSpend=new JLabel("本月消费");
	public JLabel lTodaySpend=new JLabel("今日消费");
	public JLabel lAvgSpendPerDay=new JLabel("日均消费");
	public JLabel lMonthLeft=new JLabel("本月剩余");
	public JLabel lDayAvgAvailable=new JLabel("日均可用");
	public JLabel lMonthLeftDay=new JLabel("距离月末");
	
	public JLabel vMonthSpend=new JLabel("￥2300");
	public JLabel vTodaySpend=new JLabel("￥25");
	public JLabel vAvgSpendPerDay=new JLabel("￥120");
	public JLabel vMonthLeft=new JLabel("￥300");
	public JLabel vDayAvgAvailable=new JLabel("￥30");
	public JLabel vMonthLeftDay=new JLabel("10天");
	
	CircleProgressBar bar;
	
	public SpendPanel(){
		this.setLayout(new BorderLayout());
		bar=new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		
		GUIUtil.setColor(ColorUtil.graayColor, lMonthSpend,lTodaySpend,lAvgSpendPerDay,lMonthLeft,lDayAvgAvailable,
				lMonthLeftDay,vAvgSpendPerDay,vMonthLeft,vDayAvgAvailable,vMonthLeftDay);
		
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend,vTodaySpend);
		
		vMonthSpend.setFont(new Font("微软雅黑",Font.BOLD,23));
		vTodaySpend.setFont(new Font("微软雅黑",Font.BOLD,23));
		
		this.add(center(),BorderLayout.CENTER);
		this.add(sounth(),BorderLayout.SOUTH);
	}

	private JPanel center() {
		// TODO Auto-generated method stub
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		
		p.add(west(),BorderLayout.WEST);
		p.add(center2(),BorderLayout.CENTER);
		
		return p;
	}

	private JPanel west() {
		// TODO Auto-generated method stub
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4, 1));
		
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		
		return p;
	}

	private JPanel center2() {
		// TODO Auto-generated method stub
		return bar;
	}

	private JPanel sounth() {
		// TODO Auto-generated method stub
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2, 4));
		
		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthLeft);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);
		
		return p;
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instace);
	}

	@Override
	public void updateDate() {
		// TODO Auto-generated method stub
		SpendPage spage=new SpendService().getSpendPage();
		vMonthSpend.setText(spage.monthSpend);
		vAvgSpendPerDay.setText(spage.avgSpendPerDay);
		vDayAvgAvailable.setText(spage.dayAvgAvailable);
		vMonthLeft.setText(spage.monthAvailable);
		vMonthLeftDay.setText(spage.monthLeftDay);
		vTodaySpend.setText(spage.todaySpend);
		
		bar.setProgress(spage.usagePercentage);
		if(spage.isOverSpend){
			vMonthSpend.setForeground(ColorUtil.warningColor);
			vMonthLeft.setForeground(ColorUtil.warningColor);
			vTodaySpend.setForeground(ColorUtil.warningColor);
		}else{
			vMonthSpend.setForeground(ColorUtil.blueColor);
			vMonthLeft.setForeground(ColorUtil.blueColor);
			vTodaySpend.setForeground(ColorUtil.blueColor);
		}
		
		bar.setForegroundColor(ColorUtil.getByPercentage(spage.usagePercentage));
		addListener();
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
}
