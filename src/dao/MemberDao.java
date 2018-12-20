package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.MemberEntity;

public class MemberDao 
{
	public MemberEntity login(MemberEntity member, java.sql.Connection conn) throws SQLException {
		String sql = "select * from member where member_id=? and member_pw=?";
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//pstmt = conn.prepareStatement(proFile.getProperty("login"));
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				member.setMemberName(rs.getString("member_name"));
				member.setMemberNo(rs.getInt("member_no"));
				member.setMemberScore(rs.getInt("member_score"));
				member.setMemberId(rs.getString("member_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
		}
		return member;
	}
}
