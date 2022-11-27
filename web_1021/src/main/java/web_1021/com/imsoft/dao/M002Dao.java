/**
*
*
* author : ME
*/

package web_1021.com.imsoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web_1021.com.imsoft.dto.M002Dto;

public class M002Dao {

	Connection conn = null;
	List list = new ArrayList();
	

	public Connection connect() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//61.216.84.220:1534/XE", "demo", "123456");
			System.out.println("連線成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public List query(String orderNo, String product) {

		String sql = "select *from WEB_ORDERS where 1=1 ";
		if (!"".equals(orderNo)) {
			sql += "and ORDER_NO like '%" + orderNo + "%'";
		}
		if (!"".equals(product)) {
			sql += " and PRODUCT like '%" + product + "%'";

		}
		try (Statement st = conn.createStatement(); 
			 ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				M002Dto dto = new M002Dto();
				dto.setOrderNo(rs.getString("ORDER_NO"));
				dto.setProduct(rs.getString("PRODUCT"));
				dto.setUnitAmt(rs.getString("UNIT_AMT"));
				dto.setQty(rs.getString("QTY"));
				dto.setTotalAmt(rs.getString("TOTAL_AMT"));
				dto.setBuyTime(rs.getString("BUY_TIME"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("查詢成功");
			return list;
	}

	public void closed(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void closed(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void closed(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
