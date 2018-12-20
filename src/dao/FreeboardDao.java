package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.FreeboardEntity;

public class FreeboardDao 
{
	public ArrayList<FreeboardEntity> showFreeboard(java.sql.Connection conn) throws SQLException
	{
		String sql = "select * from freeboard order by board_re_ref asc";
		
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FreeboardEntity> freeboardList = new ArrayList<FreeboardEntity>();
		FreeboardEntity entity = null;
		
		try
		{
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				entity = new FreeboardEntity();
				
				entity.setBoardNo(rs.getInt("board_no"));
				entity.setBoardId(rs.getString("board_id"));
				entity.setBoardSubject(rs.getString("board_subject"));
				entity.setBoardContext(rs.getString("board_context"));
				entity.setBoardDate(rs.getString("board_date"));
				entity.setBoardReRef(rs.getInt("board_re_ref"));
				entity.setBoardReDepth(rs.getInt("board_re_depth"));
				entity.setBoardReOrder(rs.getInt("board_re_order"));
				
				freeboardList.add(entity);
			}			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			rs.close();
			pstmt.close();
		}
		
		return freeboardList;
	}
	
}
