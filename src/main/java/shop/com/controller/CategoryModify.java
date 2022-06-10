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
@WebServlet("/category/categoryModify.do")
public class CategoryModify extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao cateDao=new CategoryDao();
		CategoryVo cateVo=new CategoryVo();
		int cateNum=Integer.parseInt(req.getParameter("cate_num"));
		try {
			cateVo=cateDao.detail(cateNum);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("cateVo", cateVo);
		req.getRequestDispatcher("./categoryModify.jsp").forward(req, resp);
	}
}
