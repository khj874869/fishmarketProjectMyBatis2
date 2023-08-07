package fishmarket.model.dao;

import java.sql.*;

import org.apache.ibatis.session.SqlSession;

import fishmarket.model.vo.Member;


public class MemberDAO {

	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember",member);
		return result;
	}

	public int deleteMemeber(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember",memberId);
		return result;
	}

	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember",member);
		return result;
	}

	public Member selectChecklogin(SqlSession session,Member member) {
		Member mOne = session.selectOne("MemberMapper.selectCheckLogin", member);
		
		return mOne;
	}

	public Member mDaoselectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById",memberId);
		return member;
	}
	
}
