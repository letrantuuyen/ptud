package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.Connect;
import entity.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TaiKhoan_Dao {

	public ArrayList<TaiKhoan> getAllTK() {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		String Sql = "select * from TaiKhoan";
		try {

			Connect.getInstance();
			Connection con = Connect.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Sql);
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan();
				tk.setTenDN(rs.getString("TenDN"));
				tk.setMatKhau(rs.getString("MatKhau"));
				tk.setQuyen(rs.getString("Quyen"));
				var nv_dao = new NhanVien_Dao();
				NhanVien nv = nv_dao.getNV(rs.getString("MaNV"));
				tk.setNhanVien(nv);
				dsTK.add(tk);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;

	}

	public boolean themTK(TaiKhoan tk) {
		PreparedStatement stmt = null;
		int n = 0;
		try {
			Connect.getInstance();
			Connection con = Connect.getConnection();
			stmt = con.prepareStatement("insert into TaiKhoan(TenDN,MatKhau,Quyen,MaNV) values(?,?,?,?)");
			stmt.setString(1, tk.getTenDN());
			stmt.setString(2, tk.getMatKhau());
			stmt.setString(3, tk.getQuyen());
			stmt.setString(4, tk.getNhanVien().getMaNV());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean xoa(String ma) {
		Connect.getInstance();
		Connection con = Connect.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where MaNV = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean sua(TaiKhoan ncc) {
		Connect.getInstance();
		Connection con = Connect.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "update TaiKhoan set TenDN=?, MatKhau=?, Quyen=? where MaNV=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ncc.getTenDN());
			ps.setString(2, ncc.getMatKhau());
			ps.setString(3, ncc.getQuyen());
			ps.setString(4, ncc.getNhanVien().getMaNV());
			n = ps.executeUpdate();
			if (n > 0) {
				return true;
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;

	}

	public TaiKhoan getTaiKhoan(String maNV) throws SQLException {
		TaiKhoan tk = null;
		Connect.getInstance();
		Connection con = Connect.getConnection();

		try {
			String sql = "select * from TaiKhoan where MaNV = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maNV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoan();
				tk.setTenDN(rs.getString("TenDN"));
				tk.setMatKhau(rs.getString("MatKhau"));
				tk.setQuyen(rs.getString("Quyen"));
				var nv_dao = new NhanVien_Dao();
				NhanVien nv = nv_dao.getNV(rs.getString("MaNV"));
				tk.setNhanVien(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tk;
	}

	public TaiKhoan getTKDN(String tenDN, String mkDN) {
		TaiKhoan tk = null;
		Connect.getInstance();
		Connection con = Connect.getConnection();

		try {
			String sql = "select * from TaiKhoan where TenDN = ? and MatKhau = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tenDN);
			ps.setString(2, mkDN);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoan();
				tk.setTenDN(rs.getString("TenDN"));
				tk.setMatKhau(rs.getString("MatKhau"));
				tk.setQuyen(rs.getString("Quyen"));
				var nv_dao = new NhanVien_Dao();
				NhanVien nv = nv_dao.getNV(rs.getString("MaNV"));
				tk.setNhanVien(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tk;
	}
}
