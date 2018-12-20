package biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import constants.DataBaseConstants;
import dao.WriteFreeboardDao;
import entity.FreeboardEntity;

public class WriteFreeboardBiz {

	public void WriteFreeboard(FreeboardEntity freeboard) throws SQLException {
		Connection conn = null;

		WriteFreeboardDao dao = new WriteFreeboardDao();

		try {
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "");
			dao.WriteFreeboard(freeboard, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
