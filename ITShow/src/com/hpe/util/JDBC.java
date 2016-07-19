package com.hpe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JDBC {
	public static Connection conn = null;// 连接对象
	public static Statement stmt = null;// 语句
	public static ResultSet rs = null;// 结果集对s�?

	public static final String url = "jdbc:mysql://localhost:3306/itsa?characterEncoding=utf-8";// 连接数据库的URL地址
	public static final String username = "root";// 数据库的用户�?
	public static final String password = "root";// 数据库的密码
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (conn == null) {
				conn = DriverManager.getConnection(url, username, password);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 释放资源的方�?
	public static void releaseResource() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			/*
			 * if(conn!=null){ conn.close(); conn=null; }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询�?��的学生资�?
	public int query(String query) {
		int myMoney = 0;
		String sql = "select query,num from requirement where time BETWEEN '20160601' AND '20160607' ";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				// System.out.println("学号:"+rs.getString("stuID")+",姓名:"+rs.getString("stuName").getBytes()+",年龄:"+rs.getInt("stuAge"));
				myMoney = rs.getInt("money");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			releaseResource();
		}
		return myMoney;

	}

	/*public MyModel queryNum(String queryID, String salaryID) {
		int myNum = 0;
		MyModel mm = new MyModel(queryID, salaryID, myNum);
		 List myList = new ArrayList() ; 
		ArrayList<Integer> list = new ArrayList<Integer>();
		String sql = "select num2 from java where query = '" + queryID
				+ "' and salary = '" + salaryID + "' ";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				mm.setNum(rs.getInt("num2"));
				mm.setQuery(queryID);
				mm.setSalary(salaryID);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			releaseResource();
		}
		return mm;

	}*/

	public ArrayList<Integer> queryNumByCity(String myKey,String myCity) {
		int myNum = 0;
		//MyModel mm = new MyModel(City, myNum);
		/* List myList = new ArrayList() ; */
		ArrayList<Integer> myList = new ArrayList<Integer>();
		String sql = "select num1,num2,num3,num4 from java where city = '" + myCity + "'";
		System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				myList.add(rs.getInt("num1"));
				myList.add(rs.getInt("num2"));
				myList.add(rs.getInt("num3"));
				myList.add(rs.getInt("num4"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResource();
		}
		return myList;

	}

	public void queryBytime() {
		// TODO Auto-generated method stub
		int myMoney = 0;
		// String
		// sql="select countNum from javalivedata where cityID ='"+cityID+"'";
		try {
			stmt = conn.createStatement();
			// rs=stmt.executeQuery(sql);
			if (rs.next()) {
				// System.out.println("学号:"+rs.getString("stuID")+",姓名:"+rs.getString("stuName").getBytes()+",年龄:"+rs.getInt("stuAge"));
				myMoney = rs.getInt("money");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			releaseResource();
		}
		// return myMoney;
	}

	/*public static void main(String[] args) {
		JDBC my = new JDBC();
		MyModel mm = my.queryNum("java", "s1");
		System.out.println(mm.getNum());
	}*/
}
