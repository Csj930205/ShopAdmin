package shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.MemberDao;
import shop.com.vo.MemberVo;
@WebServlet("/signup/signup.do")
public class MemberInsert extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./signup.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao memDao=new MemberDao();
		MemberVo memVo=new MemberVo();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		req.setCharacterEncoding("UTF-8");
		memVo.setId(req.getParameter("id"));
		memVo.setEmail(req.getParameter("email"));
		memVo.setPhone(req.getParameter("phone"));
		memVo.setPw(req.getParameter("pw"));
		memVo.setName(req.getParameter("name"));
		memVo.setAddress(req.getParameter("address"));
		memVo.setAddress_detail(req.getParameter("address_detail"));
		memVo.setGrade(Byte.parseByte(req.getParameter("grade")));
		try {
			memVo.setBirth(sdf.parse(req.getParameter("birth")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean insert=false;
		try {
			insert=memDao.insert(memVo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("insert", insert);
		if(insert) {
			resp.sendRedirect(req.getContextPath()+"/");
		}else {
			resp.sendRedirect(req.getContextPath()+"/signup/signup.do");
		}
	}
}
