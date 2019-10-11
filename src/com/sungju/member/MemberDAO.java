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
			if (result == 1) {
				System.out.println("회원가입 성공");
			}
		} catch (Exception e) {

			System.out.println("회원가입 실패");

		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
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
			} else {
				dto = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
				if (dto != null) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;

	}

}
