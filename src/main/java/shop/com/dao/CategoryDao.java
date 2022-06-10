package shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.com.vo.CategoryVo;

public class CategoryDao implements CategoryDaoAble{
	private String list_sql="select * from category";
	private String detail_sql="select * from category where cate_num=?";
	private String update_sql="update category set name=? where cate_num=?";
	private String delete_sql="delete from category where cate_num=?";
	private String insert_sql="insert into category(name) values(?)";
	@Override
	public List<CategoryVo> list(int page) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		List<CategoryVo> cateList=new ArrayList<CategoryVo>();
		CategoryVo cate;
		while(rs.next()) {
			cate=new CategoryVo();
			cate.setCate_num(rs.getInt("cate_num"));
			cate.setName(rs.getString("name"));
			cate.setSub(rs.getInt("sub"));
			cateList.add(cate);
		}
		return cateList;
	}
	@Override
	public CategoryVo detail(int cateNum) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setInt(1, cateNum);
		ResultSet rs=ps.executeQuery();
		CategoryVo cate=new CategoryVo();
		while(rs.next()) {
			cate.setCate_num(rs.getInt("cate_num"));
			cate.setName(rs.getString("name"));
			cate.setSub(rs.getInt("sub"));
		}
		return cate;
	}

	@Override
	public boolean update(CategoryVo cate) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setString(1, cate.getName());
		ps.setInt(2, cate.getCate_num());
		int update=ps.executeUpdate();
		if(update>0) {
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public boolean delete(int cateNum) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setInt(1, cateNum);
		int delete=ps.executeUpdate();
		if(delete>0) {
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public boolean insert(CategoryVo cate) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setString(1, cate.getName());
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {
			return false;			
		}
	}

	
}
