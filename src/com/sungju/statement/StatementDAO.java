package com.sungju.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sungju.account.AccountDTO;
import com.sungju.util.DBconnecter;

public class StatementDAO {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	int result;
	String sql;
	Scanner sc;

	public StatementDAO() {
		con = null;
		st = null;
		rs = null;
		result = 0;
		sql = null;
		sc = new Scanner(System.in);
	}

	public int banking(StatementDTO dto) {
		try {
			con = DBconnecter.getConnect();
			sql = "insert into statement values(STATEMENT_NUMBER.nextval,?,sysdate,?,?,?)";

			st = con.prepareStatement(sql);
			st.setString(1, dto.getAcnumber());
			st.setLong(2, dto.getDeposit());
			st.setLong(3, dto.getWithdraw());
			st.setLong(4, dto.getBalance());

			result = st.executeUpdate();
			if (result != 0) {
				System.out.println("거래완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("거래실패");
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

	public ArrayList<StatementDTO> getStatement(AccountDTO dto) {
		ArrayList<StatementDTO> ar = new ArrayList<StatementDTO>();
		StatementDTO sdto = null;
		try {
			con = DBconnecter.getConnect();
			sql = "select * from statement " 
					+ "where acnumber = ? "
					+ "order by statenumber asc";
			st = con.prepareStatement(sql);
			st.setString(1, dto.getAcnumber());

			rs = st.executeQuery();
			while (rs.next()) {
				sdto = new StatementDTO();
				sdto.setStateNumber(rs.getInt(1));
				sdto.setAcnumber(rs.getString(2));
				sdto.setAcdate(rs.getDate(3));
				sdto.setDeposit(rs.getLong(4));
				sdto.setWithdraw(rs.getLong(5));
				sdto.setBalance(rs.getLong(6));
				ar.add(sdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("일치하는 계정이 없습니다");
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ar;
	}

}
