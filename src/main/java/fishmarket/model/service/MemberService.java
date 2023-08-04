package fishmarket.model.service;

import java.sql.*;

import common.JDBCTemplate;
import fishmarket.model.dao.MemberDAO;
import fishmarket.model.vo.Member;

public class MemberService {

	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {
	}
	public int insertMember(Member member) {
	return 0;
	}

	public int updateMember(Member member) {
		return 0;

	}

	public int deleteMember(String memberId) {
		return 0;

	
	}

	public Member selectCheckLogin(Member member) {
		return null;

	}

	public Member selectOneById(String memberId) {
		return null;

	}

	
}

