package fishmarket.model.dao;

import java.sql.*;

import fishmarket.model.vo.Member;


public class MemberDAO {

	public int insertMember(Connection conn, Member member) {
		String query = "INSERT INTO FISHWEB VALUES(?,?,?,?,?,?,?,DEFAULT,DEFAULT)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPw());
			pstmt.setString(4, member.getMemberName());
			pstmt.setString(5, member.getMemberAddress());
			pstmt.setString(6, member.getMemberPhone());
			pstmt.setInt(7, member.getMemberAge());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		String query = "UPDATE FISHWEB SET USER_PW = ?, USER_EMAIL = ?, USER_PHONE = ?, USER_ADDRESS = ?,  EROLL_DATE = DEFAULT,UPDATE_DATE = DEFAULT WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setString(5, member.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE * FROM FISHWEB WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member selectCheckLogin(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM FISHWEB WHERE USER_ID = ? AND USER_PASSWORD= ?";
		Member mOne = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset = pstmt.executeQuery();	
			if(rset.next()) {
				mOne = rsetToMember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}

	public Member selectOneById(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM FISHWEB WHERE USER_ID = ?";
		Member mOne = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();	
			if(rset.next()) {
				mOne = rsetToMember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}

	private Member rsetToMember(ResultSet rset) throws SQLException {
		Member member = new Member();
		member.setMemberId(rset.getString("USER_ID"));
		member.setMemberPw(rset.getString("USER_PASSWORD"));
		member.setMemberName(rset.getString("USER_NAME"));
		member.setMemberAge(rset.getInt("AGE"));
		member.setMemberEmail(rset.getString("USER_EMAIL"));
		member.setMemberPhone(rset.getString("PHONE"));
		member.setMemberAddress(rset.getString("USER_ADDR"));
		member.setMemberDate(rset.getTimestamp("ENROLL_DATE"));
		member.setUpdateDate(rset.getTimestamp("UPDATE_DATE"));
		return member;
	}

}