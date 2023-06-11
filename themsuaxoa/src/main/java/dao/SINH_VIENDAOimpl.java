package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DButil;
import entities.SINH_VIEN;

public class SINH_VIENDAOimpl implements SINH_VIENDAO {

	@Override
	public List<SINH_VIEN> getSINH_VIENs() {
		List<SINH_VIEN> listSINH_VIEN = new ArrayList();
		Connection conn;
		PreparedStatement pstm;
		ResultSet resulset;
		conn = DButil.openConnection();
		try {
			pstm = conn.prepareStatement("SELECT * FROM  SINH_VIEN");
			resulset = pstm.executeQuery();
			while (resulset.next()) {
				SINH_VIEN sv = new SINH_VIEN();
				sv.setMSV(resulset.getString("MSV"));
				sv.setHO_TEN(resulset.getString("HO_TEN"));
				sv.setGIOI_TINH(resulset.getBoolean("GIOI_TINH"));
				sv.setNGAY_SINH(resulset.getDate("NGAY_SINH"));
				sv.setDIA_CHI(resulset.getString("DIA_CHI"));
				sv.setMA_LOP(resulset.getString("MA_LOP"));

				listSINH_VIEN.add(sv);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listSINH_VIEN;
	}

	@Override
	public Boolean insertSINH_VIEN(SINH_VIEN s) {

		Boolean check = false;
		Connection conn;
		PreparedStatement pstm;
		conn = DButil.openConnection();
		try {
			pstm = conn.prepareStatement(
					"INSERT INTO SINH_VIEN(MSV,HO_TEN,GIOI_TINH,NGAY_SINH,DIA_CHI,MA_LOP) values(?,?,?,?,?,?) ");
			pstm.setString(1, s.getMSV());
			pstm.setString(2, s.getHO_TEN());
			pstm.setBoolean(3, s.getGIOI_TINH());
			pstm.setDate(4, s.getNGAY_SINH());
			pstm.setString(5, s.getDIA_CHI());
			pstm.setString(6, s.getMA_LOP());

			int i = pstm.executeUpdate();
			if (i > 0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.closeConnection(conn);
		}

		return check;
	}

	@Override
	public Boolean updateSINH_VIEN(SINH_VIEN s) {
		Boolean check = false;
		Connection conn;
		PreparedStatement pstm;
		conn = DButil.openConnection();
		try {
			pstm = conn.prepareStatement(
					"update SINH_VIEN SET HO_TEN=?,GIOI_TINH=?,NGAY_SINH=?,DIA_CHI=?,MA_LOP=? where MSV=?");

			pstm.setString(1, s.getHO_TEN());
			pstm.setBoolean(2, s.getGIOI_TINH());
			pstm.setDate(3, s.getNGAY_SINH());
			pstm.setString(4, s.getDIA_CHI());
			pstm.setString(5, s.getMA_LOP());
			pstm.setString(6, s.getMSV());
			int i = pstm.executeUpdate();
			if (i > 0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.closeConnection(conn);
		}

		return check;
	}

	@Override
	public Boolean deleteSINH_VIEN(String MSV) {
		Boolean check = false;
		Connection conn;
		PreparedStatement pstm;
		conn = DButil.openConnection();
		try {
			pstm = conn.prepareStatement("delete from SINH_VIEN where MSV=?");
			pstm.setString(1, MSV);

			int i = pstm.executeUpdate();
			if (i > 0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.closeConnection(conn);
		}

		return check;
	}

	@Override
	public SINH_VIEN findStudentById(String MSV) {
		SINH_VIEN sv = null;
		Connection conn;
		PreparedStatement pstm;
		ResultSet resulset;
		conn = DButil.openConnection();
		try {
			pstm = conn.prepareStatement("SELECT * FROM  SINH_VIEN where MSV=?");
			pstm.setString(1, MSV);
			resulset = pstm.executeQuery();
			while (resulset.next()) {
				sv = new SINH_VIEN();
				sv.setMSV(resulset.getString("MSV"));
				sv.setHO_TEN(resulset.getString("HO_TEN"));
				sv.setGIOI_TINH(resulset.getBoolean("GIOI_TINH"));
				sv.setNGAY_SINH(resulset.getDate("NGAY_SINH"));
				sv.setDIA_CHI(resulset.getString("DIA_CHI"));
				sv.setMA_LOP(resulset.getString("MA_LOP"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sv;
	}

}
