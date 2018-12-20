package biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import constants.DataBaseConstants;
import dao.MemberDao;
import entity.MemberEntity;

public class MemberBiz 
{
	public MemberEntity login(MemberEntity member) throws SQLException {
		Connection conn = null;

		MemberDao dao = new MemberDao();
		try {
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "");
			member = dao.login(member, conn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return member;
	}
}
