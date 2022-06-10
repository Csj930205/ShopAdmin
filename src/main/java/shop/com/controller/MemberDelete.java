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
@WebServlet("/member/memberDelete.do")
public class MemberDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao memDao=new MemberDao();
		MemberVo memVo=new MemberVo();
		String id=req.getParameter("id");
		boolean delete=false;
		try {
			delete=memDao.delete(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(delete) {
			resp.sendRedirect("./list.do?page=1");
		}else {
			resp.sendRedirect("./memberModify.do?id="+memVo.getId());
		}
		
	}
}
