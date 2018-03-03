package com.guoyasoft.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class DaoSvc {
	public <T> List<T>  select(T obj){
		List<T> list=new ArrayList<T>();
		//第1步：建立数据库链接
		Connection conn = getConnection();
		//第2步：写SQL魔板
	    String sql = "insert into gy_student_0711 (SNO, SNAME, SAGE, SADDR, SSEX)values (?, ?, ?, ?, ?)";
	    //第3步：按照真实数据生成执行SQL
	    PreparedStatement st;
	    try {
	        st =conn.prepareStatement(sql);
	        st.setString(1, "guoya");
	        st.setString(2, "123' or '1'='1");

	       
	        //执行拼装好的sql,如果是更新，则返回更新条数
	        ResultSet rs=st.executeQuery(sql);
	        //关闭链接
	        st.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return list;
	}
	
	private Connection getConnection() {
		//第1步：选择驱动，有mysql的，有orace，类似不同版本的浏览器
		String driver="oracle.jdbc.driver.OracleDriver";
		//第2步：提供链接地址，哪台主机，哪个应用port，哪个实例（类似tomcat的应用名）
	    String url = "jdbc:oracle:thin:@120.132.0.117:1521:CCSDB1";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
		//第3步：登录，用户名、密码
	    String username = "shuccs1o";
	    String password = "q1w2e3r4t5";
	    //第4步：建立链接，固定写法
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
}
