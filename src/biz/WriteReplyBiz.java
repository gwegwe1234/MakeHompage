package biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import constants.DataBaseConstants;
import dao.WriteReplyDao;
import entity.FreeboardEntity;

public class WriteReplyBiz {
	public void WriteReply(FreeboardEntity reply) throws SQLException {
		Connection conn = null;

		WriteReplyDao dao = new WriteReplyDao();

		try {
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "");
			dao.WriteReply(reply, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
