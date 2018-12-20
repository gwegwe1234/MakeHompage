package biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import constants.DataBaseConstants;
import dao.MemberScoringDao;

public class MemberScoringBiz {
	public int readScore(String memberId) throws SQLException {
		Connection conn = null;

		MemberScoringDao dao = new MemberScoringDao();
		
		int score = 0;
		try {
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "");
			score = dao.readScore(memberId, conn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return score;
	}

	public int writeScore(String memberId) throws SQLException {
		Connection conn = null;

		int score = 0;

		MemberScoringDao dao = new MemberScoringDao();
		
		try{
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "124862ss");
			score = dao.writeScore(memberId, conn);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return score;
	}
	
	public int deleteScore(String memberId) throws SQLException {
		Connection conn = null;

		int score = 0;

		MemberScoringDao dao = new MemberScoringDao();
		
		try{
			Class.forName(DataBaseConstants.MYSQL_DRIVER_PACKAGE1);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loen", "root", "124862ss");
			score = dao.deleteScore(memberId, conn);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return score;
	}
}
