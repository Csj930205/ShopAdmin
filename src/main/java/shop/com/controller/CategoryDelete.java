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
@WebServlet("/category/categoryDelete.do")
public class CategoryDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao cateDao=new CategoryDao();
		CategoryVo cateVo=new CategoryVo();
		int cateNum=Integer.parseInt(req.getParameter("cate_num"));
		boolean delete=false;
		try {
			delete=cateDao.delete(cateNum);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(delete) {
			resp.sendRedirect("./list.do");
		}else {
			resp.sendRedirect("./categoryModify.do?cate_num="+cateVo.getCate_num());
		}
	}
}
