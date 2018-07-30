package cn.edu.hbue.model;

import java.util.ArrayList;

/**
 * @author czqmike
 * @date 2018年7月30日
 * @description 一个Submit实例对应一条数据库中lq_submitted数据
 */
public class Submit extends Success{
	private String captcha;

	public Submit() {
		super();
		captcha = "";
	}

	public Submit(ArrayList<String> paras) {
		super(paras);
		this.captcha = paras.get(7);
	}

	public Submit(String name, String student_no, String class_, String report_type, String email, String phone_number,
			String password, String captcha) {
		super(name, student_no, class_, report_type, email, phone_number, password);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}
