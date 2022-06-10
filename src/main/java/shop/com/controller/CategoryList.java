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

import shop.com.dao.CategoryDao;
import shop.com.vo.CategoryVo;
@WebServlet("/category/list.do")
public class CategoryList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryVo> cateList=new ArrayList<CategoryVo>();
		CategoryDao cateDao=new CategoryDao();
		String page_str=req.getParameter("page");
		int page=(page_str!=null)?Integer.parseInt(page_str):1;
		try {
			cateList=cateDao.list(page);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("cateList", cateList);
		req.getRequestDispatcher("./categoryList.jsp").forward(req, resp);
	}
}
