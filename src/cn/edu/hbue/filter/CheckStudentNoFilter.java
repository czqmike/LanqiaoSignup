package cn.edu.hbue.filter;

import java.io.IOException;
import java.sql.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import cn.edu.hbue.dao.Lq_submitted;
import cn.edu.hbue.util.JDBCUtil;

/**
 * Servlet Filter implementation class CheckStudentNoFilter
 */
@WebFilter("/CheckStudentNoFilter")
public class CheckStudentNoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckStudentNoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("doing filter");
		Connection conn = JDBCUtil.getConn();
		String stuno = request.getParameter("student-no");
		
		System.out.println("doing filter");
		int num = Lq_submitted.numOfStudentNo(stuno);
		if (num == 0) {
			chain.doFilter(request, response);
		} else {
			response.getWriter().write("此学号已被注册!");
		}
		System.out.println("doing filter, num = " + num);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
