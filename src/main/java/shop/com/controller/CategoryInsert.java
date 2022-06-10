package shop.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.CategoryDao;
import shop.com.vo.CategoryVo;
@WebServlet("/category/categoryInsert.do")
public class CategoryInsert extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./categoryInsert.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao cateDao=new CategoryDao();
		CategoryVo cateVo=new CategoryVo();
		req.setCharacterEncoding("UTF-8");
		cateVo.setName(req.getParameter("name"));
		boolean insert=false;
		try {
			insert=cateDao.insert(cateVo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("insert", insert);
		if(insert) {
			resp.sendRedirect("./list.do");
		}else {
			resp.sendRedirect("./categoryInsert.do");
		}
				
	}
}
