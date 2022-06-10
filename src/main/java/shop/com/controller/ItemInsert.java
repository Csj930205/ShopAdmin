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
@WebServlet("/item/itemInsert.do")
public class ItemInsert extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./itemInsert.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ItemDao itemDao=new ItemDao();
		ItemVo itemVo=new ItemVo();
		req.setCharacterEncoding("UTF-8");
		itemVo.setCate_num(Integer.parseInt(req.getParameter("cate_num")));
		itemVo.setColor(req.getParameter("color"));
		itemVo.setCount(Integer.parseInt(req.getParameter("count")));
		itemVo.setDetail_img(req.getParameter("detail_img"));
		itemVo.setMain_img(req.getParameter("main_img"));
		itemVo.setMember_id(req.getParameter("member_id"));
		itemVo.setModel_num(req.getParameter("model_num"));
		itemVo.setName(req.getParameter("name"));
		itemVo.setPrice(Integer.parseInt(req.getParameter("price")));
		itemVo.setState(Byte.parseByte(req.getParameter("state")));
		itemVo.setTitle(req.getParameter("title"));
		boolean insert=false;
		try {
			insert=itemDao.insert(itemVo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(insert) {
			resp.sendRedirect("./list.do");
		}else {
			resp.sendRedirect("./itemInsert.do");
		}
	}
	
}
