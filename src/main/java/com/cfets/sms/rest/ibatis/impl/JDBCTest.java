package com.cfets.sms.rest.ibatis.impl;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���scutcs
		String url = "jdbc:mysql://127.0.0.1:3306/sms";
		// MySQL����ʱ���û���
		String user = "root";
		// MySQL����ʱ������
//		String password = "root";
		try {
			// ������������
			Class.forName(driver);
			// �������ݿ�
			Connection conn = DriverManager.getConnection(url, user,"");
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// statement����ִ��SQL���
			Statement statement = conn.createStatement();
			// Ҫִ�е�SQL���
			String sql = "select * from admin_usr";

			// �����
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("-----------------");
			System.out.println(" ѧ��" + "\t" + " ����");
			System.out.println("-----------------");

			String name = null;

			while (rs.next()) {

				// ѡ��sname��������
				name = rs.getString("usr_nm");

				// ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
				// Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");

				// ������
				System.out.println(rs.getString("pswd") + "\t" + name);
			}

			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {

			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}