package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.UserObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class UserFunctionImpl implements UserFunction {

	private Connection con;

	public UserFunctionImpl(ConnectionPool cp) {
		if (cp == null) {
			cp = new ConnectionPoolImpl();
		}

		try {
			this.con = cp.getConnection("user");
			// kiểm tra và chấm dứt chế độ thực thi tự động của kết nối
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean exe(PreparedStatement pre) {
		// pre đã dc biên dịch và truyền đầy đủ gtri cho các tham số
		if (pre != null) {
			try {

				int results = pre.executeUpdate();

				if (results == 0) {
					this.con.rollback();
					return false;
				}

				// xác nhận thực thi sau cùng
				this.con.commit();
				return true;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				pre = null;
			}
		}
		return false;
	}

	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbluser(");
		sql.append("user_name, user_pass, user_fullname, user_birthday,");
		sql.append("user_mobilephone, user_homephone, user_officephone, user_email,");
		sql.append("user_address, user_jobarea, user_job, user_position,");
		sql.append("user_applyyear, user_permission, user_notes, user_roles,");
		sql.append("user_logined, user_created_date, user_last_modified, user_last_logined,");
		sql.append("user_parent_id, user_actions, user_deleted) ");
		sql.append("VALUE(?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		// BIÊN DỊCH
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setString(4, item.getUser_birthday());
			pre.setString(5, item.getUser_mobilephone());
			pre.setString(6, item.getUser_homephone());
			pre.setString(7, item.getUser_officephone());
			pre.setString(8, item.getUser_email());
			pre.setString(9, item.getUser_address());
			pre.setString(10, item.getUser_jobarea());
			pre.setString(11, item.getUser_job());
			pre.setString(12, item.getUser_position());
			pre.setShort(13, item.getUser_applyyear());
			pre.setByte(14, item.getUser_permission());
			pre.setString(15, item.getUser_notes());
			pre.setString(16, item.getUser_roles());
			pre.setInt(17, item.getUser_logined());
			pre.setString(18, item.getUser_created_date());
			pre.setString(19, item.getUser_last_modified());
			pre.setString(20, item.getUser_last_logined());
			pre.setInt(21, item.getUser_parent_id());
			pre.setByte(22, item.getUser_actions());
			pre.setBoolean(23, item.isUser_deleted());

			return this.exe(pre);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean editUser(UserObject item) {
		// TODO Auto-generated method stub

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbluser SET ");
		sql.append("user_pass=md5(?), user_fullname=?, user_birthday=?, ");
		sql.append("user_mobilephone=?, user_homephone=?, user_officephone=?, user_email=?, ");
		sql.append("user_address=?, user_jobarea=?, user_job=?, user_position=?, ");
		sql.append("user_applyyear=?, user_permission=?, user_notes=?, user_roles=?, ");
		sql.append("user_last_modified=?, user_last_logined=?, ");
		sql.append("user_actions=?, user_deleted=? ");
		sql.append("WHERE user_id=?");
		// BIÊN DỊCH
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			pre.setString(1, item.getUser_pass());
			pre.setString(2, item.getUser_fullname());
			pre.setString(3, item.getUser_birthday());
			pre.setString(4, item.getUser_mobilephone());
			pre.setString(5, item.getUser_homephone());
			pre.setString(6, item.getUser_officephone());
			pre.setString(7, item.getUser_email());
			pre.setString(8, item.getUser_address());
			pre.setString(9, item.getUser_jobarea());
			pre.setString(10, item.getUser_job());
			pre.setString(11, item.getUser_position());
			pre.setShort(12, item.getUser_applyyear());
			pre.setByte(13, item.getUser_permission());
			pre.setString(14, item.getUser_notes());
			pre.setString(15, item.getUser_roles());
			pre.setString(16, item.getUser_last_modified());
			pre.setString(17, item.getUser_last_logined());
			pre.setByte(18, item.getUser_actions());
			pre.setBoolean(19, item.isUser_deleted());
			pre.setInt(20, item.getUser_id());

			return this.exe(pre);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean delUser(UserObject item) {
		// TODO Auto-generated method stub

		String sql = "DELETE FROM tbluser WHERE user_id =?";
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	@Override
	public UserObject getUserObject(int id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tbluser WHERE user_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, id);

			ResultSet rs = pre.executeQuery();
			UserObject item = null;
			if (rs != null) {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_address(rs.getString("user_address"));
				}
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@Override
	public UserObject getUserObject(String username, String password) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tbluser WHERE (user_name=?) AND (user_pass=md5(?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);

			ResultSet rs = pre.executeQuery();
			UserObject item = null;
			if (rs != null) {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_address(rs.getString("user_address"));
				}
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@Override
	public ArrayList<UserObject> getUserObjects(UserObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		ArrayList<UserObject> results = new ArrayList<>();
		UserObject item = null;
		String sql = "select * from tbluser order by user_id desc limit " + at + ", " + total;
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			ResultSet rs = pre.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));

					results.add(item);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return results;
	}

	public static void main(String[] args) {
		UserFunction uf = new UserFunctionImpl(null);
		
		UserObject nItem = new UserObject();
		nItem.setUser_name("javaweb");
		nItem.setUser_fullname("Chu Xuan Loc");
		nItem.setUser_pass("123456");
		nItem.setUser_created_date("8/5/2024");
		nItem.setUser_email("loc@gmail.com");
		
		boolean results = uf.addUser(nItem);
		if(!results) {
			System.out.print("\n----KHONG THANH CONG---\n");
		}

		// Kiểm tra danh sách người dùng sau khi thêm, sửa và xóa
		ArrayList<UserObject> list = uf.getUserObjects(null, 0, (byte) 10);

		list.forEach(u -> {
			System.out.println(u);
		});
	}

}