package shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.MemberDao;
import shop.com.vo.MemberVo;
@WebServlet("/member/list.do")
public class MemberList extends HttpServlet{
	private MemberDao memDao=new MemberDao();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberVo> mem_list=new ArrayList<MemberVo>();
		String page_str=req.getParameter("page");
		int page=(page_str!=null)?Integer.parseInt(page_str):1;
		try {
			mem_list=memDao.list(page);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("mem_list", mem_list);
		req.getRequestDispatcher("./memberList.jsp").forward(req, resp);
	}
}
