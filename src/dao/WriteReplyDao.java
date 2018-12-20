package dao;

import java.sql.SQLException;

import entity.FreeboardEntity;

public class WriteReplyDao {
public void WriteReply(FreeboardEntity reply, java.sql.Connection conn) throws SQLException {
		
		String sql_update = "update freeboard set board_re_ref = board_re_ref+1 where board_re_ref > ?";
		String sql = "insert into freeboard values(?,?,?,?,now(),?,0,0)";
		
		java.sql.PreparedStatement pstmt_update = null;
		java.sql.PreparedStatement pstmt = null;
		

		try {
			pstmt_update = conn.prepareStatement(sql_update);
			pstmt_update.setInt(1, reply.getBoardReRef());
			pstmt_update.executeUpdate();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getBoardNo());
			pstmt.setString(2, reply.getBoardId());
			pstmt.setString(3, reply.getBoardSubject());
			pstmt.setString(4, reply.getBoardContext());
			//pstmt.setString(5, freeboardlist.getBoardDate());
			pstmt.setInt(5, reply.getBoardReRef()+1);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
		}

	}
}
