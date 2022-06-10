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

import shop.com.dao.ItemDao;
import shop.com.vo.ItemVo;
@WebServlet("/item/list.do")
public class ItemList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ItemVo> itemList=new ArrayList<ItemVo>();
		ItemDao itemDao=new ItemDao();
		ItemVo itemVo=new ItemVo();
		String page_str=req.getParameter("page");
		int page=(page_str!=null)?Integer.parseInt(page_str):1;
		try {
			itemList=itemDao.list(page);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("itemList", itemList);
		req.getRequestDispatcher("./itemList.jsp").forward(req, resp);
	}
}
