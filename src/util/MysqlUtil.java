package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MysqlUtil {
	public static void backup(String mysqlPath, String backupfile) throws IOException {
		String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";
		String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port,
				DBUtil.database, backupfile);
		
		System.out.println(command);
		Runtime.getRuntime().exec(command);
	}

	public static void recover(String mysqlPath, String recoverfile) {
		try {
			String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s   %s ";
			String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password,
					DBUtil.database);

			Process p = Runtime.getRuntime().exec(command);
			
			OutputStream out = p.getOutputStream();
			String inString;
			StringBuffer sb=new StringBuffer("");
			String outStr;
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile),"utf-8"));
			while((inString=br.readLine())!=null){
				sb.append(inString+"\r\n");
			}
			outStr=sb.toString();
			OutputStreamWriter writer=new OutputStreamWriter(out,"utf8");
			writer.write(outStr);
			writer.flush();			
			out.close();
			br.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public static void main(String[] args) throws IOException {
		String mysqlPath="C:/Program Files (x86)/MySQL/MySQL Server 5.5";
		String file="F:\\备份文件\\hutubilixxx.sql";
		backup(mysqlPath, file);
		
//		recover(mysqlPath, file);
	}
}
