package com.sungju.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sungju.util.DBconnecter;

public class MemberDAO {

	Connection con;
	PreparedStatement st;
	ResultSet rs;
	String sql;
	int result;

	public MemberDAO() {
		con = null;
		st = null;
		rs = null;
		sql = null;
		result = 0;

	}

	public int signup(MemberDTO dto) {
		
		try {
			con = DBconnecter.getConnect();
			sql = "insert into acmember values(?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, dto.getId());
			st.setString(2, dto.getPw());
			st.setString(3, dto.getName());
			st.setString(4, dto.getHp());
			st.setString(5, dto.getEmail());
			
			result = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;

	}
	
	
	public MemberDTO signin(MemberDTO dto) {
		try {
			con = DBconnecter.getConnect();
			sql = "select * from acmember where id =? and pw = ? ";
			st = con.prepareStatement(sql);
			
			st.setString(1, dto.getId());
			st.setString(2, dto.getPw());
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString(1));
				dto.setPw(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setEmail(rs.getString(5));
			}else {
				dto = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}

}