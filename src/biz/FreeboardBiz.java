package biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import constants.DataBaseConstants;
import dao.FreeboardDao;
import entity.FreeboardEntity;

public class FreeboardBiz {
	public List<FreeboardEntity> showFreeboardList() throws SQLException {
		Connection conn = null;
		List<FreeboardEntity> freeboardList = null;
		FreeboardDao dao = new FreeboardDao();
		try {
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "");
			freeboardList = dao.showFreeboard(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return freeboardList;
	}
}
