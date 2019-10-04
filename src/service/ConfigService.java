package service;


import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
	public static final String budget="budget";
	public static final String mysqlPath="mysqlPath";
	public static final String default_budget="500";
	
	static ConfigDAO dao=new ConfigDAO();
	static{
		init();
	}
	public static void init() {
		// TODO Auto-generated method stub
		init(budget,default_budget);
		init(mysqlPath,"");
	}
	private static void init(String key, String value) {
		// TODO Auto-generated method stub
		Config config=dao.getByKey(key);
		if(config==null){
			config=new Config();
			config.setKey(key);
			config.setValue(value);
			dao.add(config);
		}
	}
	public String get(String key){
		Config config=dao.getByKey(key);
		return config.getValue();
	}
	public void update(String key,String value){
		Config config=dao.getByKey(key);
		config.setValue(value);
		dao.update(config);
	}
	public int getIntBudget(){
		return Integer.parseInt(get(budget));
	}
}
