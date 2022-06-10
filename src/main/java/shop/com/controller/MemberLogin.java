package shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.com.dao.MemberDao;
import shop.com.vo.MemberVo;
@WebServlet("/login/login.do")
public class MemberLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean login=false;
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		MemberVo memVo=null;
		MemberDao memDao=new MemberDao();
		try {
			memVo=memDao.login(id, pw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		HttpSession session=req.getSession();
		if(memVo!=null) {
			session.setAttribute("id", memVo.getId());
			session.setAttribute("name", memVo.getName());
			session.setAttribute("grade", memVo.getGrade());
			login=true;
		}else {
			session.setAttribute("id", id);
		}
		session.setAttribute("login", login);
		String loginTrue=req.getContextPath()+((login)?"/":"/login/login.do");
		resp.sendRedirect(loginTrue);
	}
}
