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
@WebServlet("/category/categoryUpdate.do")
public class CategoryUpdate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao cateDao=new CategoryDao();
		CategoryVo cateVo=new CategoryVo();
		req.setCharacterEncoding("UTF-8");
		cateVo.setName(req.getParameter("name"));
		cateVo.setCate_num(Integer.parseInt(req.getParameter("cate_num")));
		boolean update=false;
		try {
			update=cateDao.update(cateVo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(update) {
			resp.sendRedirect("./list.do?page=1");
		}else {
			resp.sendRedirect("./categoryModify.do?cate_num="+cateVo.getCate_num());
		}
	}
}
