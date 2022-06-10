package shop.com.checkController;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.com.dao.MemberDao;
import shop.com.vo.MemberVo;
@WebServlet("/signup/memberUpdate.do")
public class MemberUpdate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao memDao=new MemberDao();
		MemberVo memVo=new MemberVo();
		req.setCharacterEncoding("UTF-8");
		memVo.setId(req.getParameter("id"));
		memVo.setPw(req.getParameter("pw"));
		memVo.setName(req.getParameter("name"));
		memVo.setGrade(Byte.parseByte(req.getParameter("grade")));
		memVo.setAddress(req.getParameter("address"));
		memVo.setAddress_detail(req.getParameter("address_detail"));
		memVo.setEmail(req.getParameter("email"));
		memVo.setPhone(req.getParameter("phone"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		try {
			memVo.setSignup_time(sdf.parse(req.getParameter("signup_time")));
			memVo.setBirth(sdf.parse(req.getParameter("birth")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean update=false;
			try {
				update=memDao.update(memVo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if(update) {
				resp.sendRedirect("./list.do?page=1");
			}else {
				resp.sendRedirect("./memberModify.do?id="+memVo.getId());
			}
	}
}
