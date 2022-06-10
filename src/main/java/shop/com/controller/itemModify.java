package shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.ItemDao;
import shop.com.vo.ItemVo;
@WebServlet("/item/itemModify.do")
public class itemModify extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ItemDao itemDao=new ItemDao();
		ItemVo itemVo=new ItemVo();
		int itemNum=Integer.parseInt(req.getParameter("item_num"));
		try {
			itemVo=itemDao.detail(itemNum);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("itemVo", itemVo);
		req.getRequestDispatcher("./itemModify.jsp").forward(req, resp);
	}
}
