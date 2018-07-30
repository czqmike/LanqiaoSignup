package cn.edu.hbue.model;

import java.util.ArrayList;

/**
 * @author czqmike
 * @date 2018年7月30日
 * @description 一个Success实例对应一条lq_success表的记录
 * @waring 表中的【class】班级属性换成了 【class_】
 */
public class Success {
	private String name, student_no, class_, report_type, email, phone_number, password;

	public Success() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Success(String name, String student_no, String class_, String report_type, String email, String phone_number,
			String password) {
		super();
		this.name = name;
		this.student_no = student_no;
		this.class_ = class_;
		this.report_type = report_type;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
	}
	
	public Success(ArrayList<String> paras) { 
		this.name = paras.get(0);
		this.student_no = paras.get(1);
		this.class_ = paras.get(2);
		this.report_type = paras.get(3);
		this.email = paras.get(4);
		this.phone_number = paras.get(5);
		this.password = paras.get(6);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
