package shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import shop.com.vo.MemberVo;

public class MemberDao implements MemberDaoAble{ // DaoAble을 통해 만들어둔 interface를 구현하여 작성
	private String list_sql="select * from member"; // database의 member 전체를 출력
	private String detail_sql="select * from member where id=?"; // id=?인 member의 data를 가져온다
	private String update_sql="update member set "
			+ " pw=?,"
			+ " phone=?,"
			+ " email=?,"
			+ " name=?,"
			+ " address=?,"
			+ " address_detail=?,"
			+ " birth=?,"
			+ " grade=?"
			+ " where id=?";
	private String delete_sql="delete from member where id=?";
	private String insert_sql="insert into member(id,email,phone,pw,name,address,address_detail,grade,birth) values(?,?,?,?,?,?,?,?,?)";
	private String login_sql="select * from member where id=? and pw=?";
	private String emailCheck_sql="select * from member where email=?";
	private String phoneCheck_sql="select * from member where phone=?";
	private String pwCheck_sql="select * from member where pw=?";
	@Override
	public List<MemberVo> list(int page) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql); // sql구문을 실행하는 역할(statement의 기능 향상)
		ResultSet rs=ps.executeQuery(); // select query문을 실행하고 결과를 받기 위해 사용
		ArrayList<MemberVo> memList=new ArrayList<MemberVo>();
		MemberVo mem;
		while(rs.next()) {
			mem=new MemberVo();
			mem.setId(rs.getString("id"));
			mem.setPw(rs.getString("pw"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setBirth(rs.getDate("birth"));
			mem.setGrade(rs.getByte("grade"));
			memList.add(mem);
		}
		return memList;
	}
	@Override
	public MemberVo detail(String id) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setString(1, id); 
		ResultSet rs=ps.executeQuery();
		MemberVo mem=new MemberVo();
		while(rs.next()) {
			mem.setId(rs.getString("id"));
			mem.setPw(rs.getString("pw"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setBirth(rs.getDate("birth"));
			mem.setGrade(rs.getByte("grade"));
		}
		return mem;
	}
	
	@Override
	public boolean update(MemberVo mem) throws ClassNotFoundException, SQLException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-DD");
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setString(1, mem.getPw());
		ps.setString(2, mem.getPhone());
		ps.setString(3, mem.getEmail());
		ps.setString(4, mem.getName());
		ps.setString(5, mem.getAddress());
		ps.setString(6, mem.getAddress_detail());
		ps.setString(7, sdf.format(mem.getBirth()));
		ps.setByte(8, mem.getGrade());		
		ps.setString(9, mem.getId());
		int update=ps.executeUpdate(); // 업데이트 갯수를 저장
		if(update>0) {// 업데이트 개수가 1개 이상일때만 true를 반환
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public boolean delete(String id) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setString(1, id);
		int delete=ps.executeUpdate();
		if(delete>0) {
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public boolean insert(MemberVo mem) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setString(1, mem.getId());
		ps.setString(2, mem.getEmail());
		ps.setString(3, mem.getPhone());
		ps.setString(4, mem.getPw());
		ps.setString(5, mem.getName());
		ps.setString(6, mem.getAddress());
		ps.setString(7, mem.getAddress_detail());
		ps.setByte(8, mem.getGrade());
		ps.setString(9, new SimpleDateFormat("yyyy-mm-DD").format(mem.getBirth()));
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {
			return false;			
		}
	}
	public MemberVo login(String id, String pw) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(login_sql);
		MemberVo mem=null;
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			mem=new MemberVo();
			mem.setId(rs.getString("id"));
			mem.setPw(rs.getString("pw"));
			mem.setPhone(rs.getString("phone"));
			mem.setEmail(rs.getString("email"));
			mem.setName(rs.getString("name"));
			mem.setAddress(rs.getString("address"));
			mem.setAddress_detail(rs.getString("address_detail"));
			mem.setSignup_time(rs.getDate("signup_time"));
			mem.setBirth(rs.getDate("birth"));
			mem.setGrade(rs.getByte("grade"));
		}
		return mem;
	}
	public MemberVo emailCheck(String email) throws ClassNotFoundException, SQLException{
		MemberVo memVo=new MemberVo();
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(emailCheck_sql);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			memVo.setEmail(rs.getString("email"));
		}
		return memVo;
	}
	public MemberVo phoneCheck(String phone) throws ClassNotFoundException, SQLException{
		MemberVo memVo=new MemberVo();
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(phoneCheck_sql);
		ps.setString(1, phone);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			memVo.setPhone(rs.getString("phone"));
		}
		return memVo;
	}
	public MemberVo pwCheck(String pw) throws ClassNotFoundException, SQLException{
		MemberVo memVo=new MemberVo();
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(pwCheck_sql);
		ps.setString(1, pw);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			memVo.setPw(rs.getString("pw"));
		}
		return memVo;
	}
}
