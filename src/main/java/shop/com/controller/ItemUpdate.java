package shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.ItemDao;
import shop.com.vo.ItemVo;
@WebServlet("/item/itemUpdate.do")
public class ItemUpdate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ItemDao itemDao=new ItemDao();
		ItemVo itemVo=new ItemVo();
		req.setCharacterEncoding("UTF-8");
		itemVo.setPrice(Integer.parseInt(req.getParameter("price")));
		itemVo.setCate_num(Integer.parseInt(req.getParameter("cate_num")));
		itemVo.setName(req.getParameter("name"));
		itemVo.setItem_num(Integer.parseInt(req.getParameter("item_num")));
		boolean update=false;
		try {
			update=itemDao.update(itemVo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(update) {
			resp.sendRedirect("./list.do");
		}else {
			resp.sendRedirect("./itemMoidfy.do?item_num="+itemVo.getItem_num());
		}
	}
}
