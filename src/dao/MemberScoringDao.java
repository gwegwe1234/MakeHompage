package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.MemberEntity;

public class MemberScoringDao {
	public int readScore(String memberId, java.sql.Connection conn) throws SQLException {
		String sql = "update member set member_score=member_score+5 where member_id=?";
		String sql_getScore = "select * from member where member_id=?";
		java.sql.PreparedStatement pstmt = null;
		java.sql.PreparedStatement pstmt_getScore = null;
		ResultSet rs = null;
		
		int score = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			
			pstmt_getScore = conn.prepareStatement(sql_getScore);
			pstmt_getScore.setString(1, memberId);
			rs = pstmt_getScore.executeQuery();
			while(rs.next())
				score = rs.getInt("member_score");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
		}
		
		return score;
	}
	
	public int writeScore(String memberId, java.sql.Connection conn) throws SQLException {
		String sql = "update member set member_score=member_score+10 where member_id=?";
		String sql_getScore = "select * from member where member_id=?";
		java.sql.PreparedStatement pstmt = null;
		java.sql.PreparedStatement pstmt_getScore = null;
		ResultSet rs = null;
		
		int score = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			
			pstmt_getScore = conn.prepareStatement(sql_getScore);
			pstmt_getScore.setString(1, memberId);
			rs = pstmt_getScore.executeQuery();
			while(rs.next())
				score = rs.getInt("member_score");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
		}
		
		return score;
	}

	public int deleteScore(String memberId, java.sql.Connection conn) throws SQLException {
		String sql = "update member set member_score=member_score-10 where member_id=?";
		String sql_getScore = "select * from member where member_id=?";
		java.sql.PreparedStatement pstmt = null;
		java.sql.PreparedStatement pstmt_getScore = null;
		ResultSet rs = null;
		
		int score = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			
			pstmt_getScore = conn.prepareStatement(sql_getScore);
			pstmt_getScore.setString(1, memberId);
			rs = pstmt_getScore.executeQuery();
			while(rs.next())
				score = rs.getInt("member_score");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
		}
		
		return score;
	}
}
