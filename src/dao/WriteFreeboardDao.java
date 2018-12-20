package dao;

import java.sql.SQLException;

import entity.FreeboardEntity;

public class WriteFreeboardDao 
{
	public void WriteFreeboard(FreeboardEntity freeboardlist, java.sql.Connection conn) throws SQLException {
		
		String sql_update = "update freeboard set board_re_ref = board_re_ref+1";
		String sql = "insert into freeboard values(?,?,?,?,now(),0,0,0)";
		
		java.sql.PreparedStatement pstmt_update = null;
		java.sql.PreparedStatement pstmt = null;
		

		try {
			pstmt_update = conn.prepareStatement(sql_update);
			pstmt_update.executeUpdate();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, freeboardlist.getBoardNo());
			pstmt.setString(2, freeboardlist.getBoardId());
			pstmt.setString(3, freeboardlist.getBoardSubject());
			pstmt.setString(4, freeboardlist.getBoardContext());
			//pstmt.setString(5, freeboardlist.getBoardDate());
			//pstmt.setInt(5, freeboardlist.getBoardReRef());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
		}

	}

}
