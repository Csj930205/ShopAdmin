package shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.MemberDao;
import shop.com.vo.MemberVo;
@WebServlet("/member/memberModify.do")
public class MemberModify extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao memDao=new MemberDao();
		MemberVo memVo=new MemberVo();
		String id=req.getParameter("id");
		try {
			memVo=memDao.detail(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("memVo", memVo);
		req.getRequestDispatcher("./memberModify.jsp").forward(req, resp);
	}
}
