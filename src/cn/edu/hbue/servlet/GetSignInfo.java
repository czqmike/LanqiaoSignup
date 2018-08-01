package cn.edu.hbue.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.dao.Lq_submitted;
import cn.edu.hbue.model.Submit;

/**
 * @author czqmike
 * @date 2018年7月29日
 * @description 接收用户提交的表单信息。
 */
@WebServlet("/GetSignInfo")
public class GetSignInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSignInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 通过getParameter来测试用户点击的是 [get-captcha] 还是 [sign-up]]
		String isGetCaptcha = request.getParameter("get-captcha");
		
		if (isGetCaptcha != null) { //用户点击了获取验证码按钮
			//  接收表单传来的各项数据并且push进ArrayList
			ArrayList<String> paraOfSubmit = new ArrayList<String>();
			Enumeration<String> paraNames = request.getParameterNames();
			while (paraNames.hasMoreElements()) {
				String name = paraNames.nextElement();
				paraOfSubmit.add(new String(request.getParameter(name).getBytes("ISO8859-1"),"UTF-8"));
			}
			//  构造Submit，方便插入
			Submit submit = new Submit(paraOfSubmit);
	
			// test data
//			PrintWriter out = response.getWriter();
//			paraNames = request.getParameterNames();
//			while (paraNames.hasMoreElements()) {
//				String name = paraNames.nextElement();
//				String para = new String(request.getParameter(name).getBytes("ISO8859-1"),"UTF-8");
//				out.println("<h1>" + name + " = " + para + "</h1>");
//			}
			boolean ok = Lq_submitted.insert(submit);

			if (ok) {
				out.println("<h1>请查收验证码(*^_^*), 3秒后跳转</h1>");
			} else {
				out.println("<h1>插入数据失败！ </h1>");
			}
			//3秒后跳转到注册页面
			response.setHeader("refresh","3;/LanqiaoSignup/LanqiaoSignup.html"); 
		} else { // 用户点击了注册按钮
			String captcha = request.getParameter("captcha");
			// TODO: 修改表中student_no为当前学生的captcha

			out.println("<h1>恭喜，信息已提交！注册完成后会在第一时间以邮件方式通知你(*^_^*)</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
