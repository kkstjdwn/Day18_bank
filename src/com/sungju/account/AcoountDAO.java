package com.sungju.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sungju.member.MemberDTO;
import com.sungju.util.DBconnecter;

public class AcoountDAO {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	String sql;
	int result;
	
	public AcoountDAO() {
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
			st.setInt(4, dto.getBalance());
			
			result = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (result !=0) {
				System.out.println("계좌개설 성공");
			}else {
				System.out.println("계좌개설 실패");
			}
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

}
