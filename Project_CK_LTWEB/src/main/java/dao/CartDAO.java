package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.TempCart;

public class CartDAO {

	Connection connect = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	// Lấy danh sách các mục giỏ hàng
	public List<TempCart> getCartByUserId(int id) {
		List<TempCart> list = new ArrayList<>();
		DBContext db = DBContext.getInstance();

		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `cart` WHERE cart.user_id = ?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new TempCart(result.getInt(1), result.getInt(3), result.getInt(4)));
			}
			result.close();
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Lấy danh sách các mục giỏ hàng dựa trên ID
	public List<TempCart> getCartByUserIdAndProductId(int user_id, int pro_id) {
		List<TempCart> list = new ArrayList<>();
		DBContext db = DBContext.getInstance();

		try {
			connect = db.getConnection();

			String query = "SELECT * FROM `cart` WHERE cart.user_id = ? and cart.pro_id=?";
			ps = connect.prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setInt(2, pro_id);
			result = ps.executeQuery();
			while (result.next()) {
				list.add(new TempCart(result.getInt(1), result.getInt(3), result.getInt(4)));
			}
			result.close();
			ps.close();
			connect.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Chèn một mục mới vào giỏ hàng tạm thời
	public void insertTempcart(int user_id, int pro_id, int quantity) {
		DBContext db = DBContext.getInstance();
		try {
			connect = db.getConnection();
			String query = "INSERT INTO `cart`(`user_id`, `pro_id`, `quantity`) VALUES (?,?,?);";
			ps = connect.prepareStatement(query);

			ps.setInt(1, user_id);
			ps.setInt(2, pro_id);
			ps.setInt(3, quantity);
			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Cập nhật số lượng của một mục trong giỏ hàng tạm thời
	public void updateTempcart(int user_id, int pro_id, int quantity) {
		DBContext db = DBContext.getInstance();
		try {
			connect = db.getConnection();
			String query = "UPDATE `cart` SET `quantity`=? WHERE `user_id`=? and `pro_id`=?";
			ps = connect.prepareStatement(query);

			ps.setInt(1, quantity);
			ps.setInt(2, user_id);
			ps.setInt(3, pro_id);
			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Xóa toàn bộ giỏ hàng của một người dùng '
	public void deleteCart(int user_id) {
		DBContext db = DBContext.getInstance();
		try {
			connect = db.getConnection();
			String query = "Delete from cart where user_id=?;";
			ps = connect.prepareStatement(query);

			ps.setInt(1, user_id);
			int numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Xóa một sản phẩm cụ thể khỏi giỏ hàng của một người dùng
	public int deleteProduct(int user_id, int pro_id) {
		DBContext db = DBContext.getInstance();
		int numberRowUpdate = 0;
		try {
			connect = db.getConnection();
			String query = "Delete from cart where user_id=? and pro_id=?;";
			ps = connect.prepareStatement(query);

			ps.setInt(1, user_id);
			ps.setInt(2, pro_id);
			numberRowUpdate = ps.executeUpdate();

			ps.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberRowUpdate;
	}

	public List<TempCart> getFirstFiveItemsInCartByUserId(int user_id) {
		List<TempCart> list = new ArrayList<>();
		DBContext db = DBContext.getInstance();

		try (Connection connect = db.getConnection();
				PreparedStatement ps = connect
						.prepareStatement("SELECT * FROM `cart` WHERE cart.user_id = ? LIMIT 3")) {

			ps.setInt(1, user_id);

			try (ResultSet result = ps.executeQuery()) {
				while (result.next()) {
					list.add(new TempCart(result.getInt(1), result.getInt(3), result.getInt(4)));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {

	}
}
