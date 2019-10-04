package service;

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import gui.panel.RecoverPanel;
import util.DateUtil;

public class SpendService {
	
	public SpendPage getSpendPage(){
		RecordDAO recordDAO=new RecordDAO();
		//��������
		List<Record> thisMonthRecord=recordDAO.listThisMonth();
		//��������
		List<Record> todayRecord=recordDAO.listToday();
		//����������
		int thisMonth=DateUtil.thisMonthTotalDay();
		
		int monthSpend=0;
		int todaySpend=0;
		int avgSpendPerDay=0;
		int monthAvailable=0;
		int dayAvgAvailable=0;		
		int monthLeftDay=0; 
		int usagePercentage=0;
		
		//Ԥ��
		int monthBudget=new ConfigService().getIntBudget();
		//ͳ�Ʊ�������
		for(Record r:thisMonthRecord){
			monthSpend+=r.getSpend();
		}
		//ͳ�ƽ�������
		for(Record r:todayRecord){
			todaySpend+=r.getSpend();
		}
		//�����վ�����
		avgSpendPerDay=monthSpend/thisMonth;
		//���㱾��ʣ��
		monthAvailable=monthBudget-monthSpend;
		//������ĩ
		monthLeftDay=DateUtil.thisMonthLeftDay();
		//�����վ�����
		dayAvgAvailable=monthAvailable/monthLeftDay;
		//����ʹ�ñ���
		usagePercentage=monthSpend*100/monthBudget;
		
		return new SpendPage(monthSpend,todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable,
				monthLeftDay, usagePercentage);
	}
}
