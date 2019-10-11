package com.sungju.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sungju.member.MemberDTO;
import com.sungju.util.DBconnecter;

public class AccountDAO {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	String sql;
	int result;
	
	public AccountDAO() {
	con = null;
	st = null;
	rs = null;
	sql = null;
	result = 0;
	}
	
	public int makeAccount(AccountDTO dto) {
		try {
			con = DBconnecter.getConnect();
			sql = "insert into mkaccount values(?,?,?,?)";
			st=con.prepareStatement(sql);
			st.setString(1, dto.getId());
			st.setString(2, dto.getAcname());
			st.setString(3, dto.getAcnumber());
			st.setLong(4, dto.getBalance());
			
			result = st.executeUpdate();
			if (result !=0) {
				System.out.println("계좌개설 성공");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("계좌개설 실패");
			
		}finally {
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
	
	
	
	
	
	
	public ArrayList<AccountDTO> searchAcc(MemberDTO dto) {
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();
		try {
			con = DBconnecter.getConnect();
			sql = "select * from mkaccount where id = ?";
			st = con.prepareStatement(sql);
			st.setString(1, dto.getId());
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				AccountDTO acdto = new AccountDTO();
				acdto.setId(rs.getString(1));
				acdto.setAcname(rs.getString(2));
				acdto.setAcnumber(rs.getString(3));
				acdto.setBalance(rs.getInt(4));
				ar.add(acdto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ar;
	}
	
	
	public int deleteAccount(String acname) {
		
		try {
			con = DBconnecter.getConnect();
			sql = "delete mkaccount where acname = ? ";
			st = con.prepareStatement(sql);
			st.setString(1, acname);
			result = st.executeUpdate();
			if (result !=0) {
				System.out.println("계좌 삭제 성공");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("계좌 삭제 실패");
		}finally {
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
	
	public void updateBalance(AccountDTO dto) { //10/1
		try {
			con  = DBconnecter.getConnect();
			sql = "update mkaccount set balance = ? "
					+ "where acname = ?";
			st = con.prepareStatement(sql);
			st.setLong(1, dto.getBalance());
			st.setString(2, dto.getAcname());
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
