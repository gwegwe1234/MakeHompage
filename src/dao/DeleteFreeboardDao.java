package dao;

import java.sql.SQLException;

public class DeleteFreeboardDao {
public void DeleteFreeboard(int boardNo, java.sql.Connection conn) throws SQLException {
		
		String sql = "delete from freeboard where board_no=?";		
		java.sql.PreparedStatement pstmt = null;
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
		}

	}
}
