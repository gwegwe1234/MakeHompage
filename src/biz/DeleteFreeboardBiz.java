package biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import constants.DataBaseConstants;
import dao.DeleteFreeboardDao;

public class DeleteFreeboardBiz {
	public void DeleteFreeboard(int boardNo) throws SQLException {
		Connection conn = null;

		DeleteFreeboardDao dao = new DeleteFreeboardDao();

		try {
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "");
			dao.DeleteFreeboard(boardNo, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
