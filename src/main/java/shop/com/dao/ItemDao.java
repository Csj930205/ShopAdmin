package shop.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.com.vo.ItemVo;

public class ItemDao implements ItemDaoAble{
	private String list_sql="select * from item";
	private String detail_sql="select * from item where item_num=?";
	private String delete_sql="delete from item where item_num=?";
	private String update_sql="update item set price=?,cate_num=?, name=? where item_num=?";
	private String insert_sql="insert into item(cate_num, color, count, detail_img, main_img, member_id, model_num, name, price, state, title)"
							+ "values(?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public List<ItemVo> list(int page) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		List<ItemVo> item_list=new ArrayList<ItemVo>();
		ItemVo item;
		while(rs.next()) {
			item=new ItemVo();
			item.setItem_num(rs.getInt("item_num"));
			item.setName(rs.getString("name"));
			item.setTitle(rs.getString("title"));
			item.setCount(rs.getInt("count"));
			item.setPrice(rs.getInt("price"));
			item.setColor(rs.getString("color"));
			item.setMain_img(rs.getString("main_img"));
			item.setDetail_img(rs.getString("detail_img"));
			item.setModel_num(rs.getString("model_num"));
			item.setMember_id(rs.getString("member_id"));
			item.setPost_time(rs.getTimestamp("post_time"));
			item.setSale_time(rs.getTimestamp("sale_time"));
			item.setSale_end_time(rs.getTimestamp("sale_end_time"));
			item.setState(rs.getByte("state"));
			item.setCate_num(rs.getInt("cate_num"));
			item_list.add(item);
		}
		return item_list;
	}
	@Override
	public ItemVo detail(int item_num) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setInt(1, item_num);
		ResultSet rs=ps.executeQuery();
		ItemVo item=new ItemVo();
		while(rs.next()) {
			item.setItem_num(rs.getInt("item_num"));
			item.setName(rs.getString("name"));
			item.setTitle(rs.getString("title"));
			item.setCount(rs.getInt("count"));
			item.setPrice(rs.getInt("price"));
			item.setColor(rs.getString("color"));
			item.setMain_img(rs.getString("main_img"));
			item.setDetail_img(rs.getString("detail_img"));
			item.setModel_num(rs.getString("model_num"));
			item.setMember_id(rs.getString("member_id"));
			item.setPost_time(rs.getTimestamp("post_time"));
			item.setSale_time(rs.getTimestamp("sale_time"));
			item.setSale_end_time(rs.getTimestamp("sale_end_time"));
			item.setState(rs.getByte("state"));
			item.setCate_num(rs.getInt("cate_num"));
		}
		return item;
	}
	@Override
	public boolean delete(int item_num) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setInt(1, item_num);
		int delete=ps.executeUpdate();
		if(delete>0) {
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public boolean update(ItemVo item) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setInt(1, item.getPrice());
		ps.setInt(2, item.getCate_num());
		ps.setString(3, item.getName());
		ps.setInt(4,item.getItem_num());
		int update=ps.executeUpdate();
		if(update>0) {
			return true;
		}else {
			return false;			
		}
	}
	@Override
	public boolean insert(ItemVo item) throws ClassNotFoundException, SQLException {
		Connection conn=ShopConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setInt(1, item.getCate_num());
		ps.setString(2, item.getColor());
		ps.setInt(3, item.getCount());
		ps.setString(4, item.getDetail_img());
		ps.setString(5, item.getMain_img());
		ps.setString(6, item.getMember_id());
		ps.setString(7, item.getModel_num());
		ps.setString(8, item.getName());
		ps.setInt(9, item.getPrice());
		ps.setByte(10, item.getState());
		ps.setString(11, item.getTitle());
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {
			return false;			
		}
	}
}
