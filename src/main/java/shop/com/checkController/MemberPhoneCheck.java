package shop.com.checkController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.MemberDao;
import shop.com.vo.MemberVo;
@WebServlet("/signup/phone_check.do")
public class MemberPhoneCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone=req.getParameter("phone");
		MemberDao memDao=new MemberDao();
		MemberVo memVo=null;
		resp.setContentType("json/application; charset=UTF-8");
		try {
			memVo=memDao.phoneCheck(phone);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(memVo.getPhone()==null) {
			resp.getWriter().append("{\"phone_check\":true}");
		}else {
			resp.getWriter().append("{\"phone_check\":false}");
		}
	}
}
