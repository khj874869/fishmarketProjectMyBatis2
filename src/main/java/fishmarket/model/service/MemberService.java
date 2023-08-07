package fishmarket.model.service;

import java.sql.*;

import org.apache.ibatis.session.SqlSession;

import common.JDBCTemplate;
import common.SqlSessionTemplate;
import fishmarket.model.dao.MemberDAO;
import fishmarket.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	public MemberService() {
		mDao = new MemberDAO();
	}
	public int insertMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.insertMember(session,member);
		if(result>0) {
			session.commit();
		}
		else {
			session.rollback();
		}
		session.close();
		return result;
	}
	public int deleteMemeber(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.deleteMemeber(session,memberId);
		if(result>0) {
			session.commit();
		}
		else {
			session.rollback();
		}
		session.close();
		return result;

}
	public int updateMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.updateMember(session,member);
		if(result>0) {
			session.commit();
		}
		else {
			session.rollback();
		}
		session.close();
		return result;

	}
	public Member selectCheckLogin(Member member) {
		SqlSession session =SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectChecklogin(session,member);
		session.close();
		return mOne;
	}
	public Member selectOneById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member member = mDao.mDaoselectOneById(session,memberId);
		session.close();
		return member;
	}
}

