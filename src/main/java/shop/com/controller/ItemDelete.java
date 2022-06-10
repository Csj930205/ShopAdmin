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
@WebServlet("/item/itemDelete.do")
public class ItemDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ItemDao itemDao=new ItemDao();
		ItemVo itemVo=new ItemVo();
		int itemNum=Integer.parseInt(req.getParameter("item_num"));
		boolean delete=false;
		try {
			delete=itemDao.delete(itemNum);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(delete) {
			resp.sendRedirect("./list.do");
		}else {
			resp.sendRedirect("./itemModify.do?item_num="+itemVo.getItem_num());
		}
	}
	
	
}
