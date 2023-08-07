package notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertnotice",notice);
		return result;
	}

	public List<Notice> selectNotice(SqlSession session,int currentPage) {
		int limit =10 ;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice>nList = session.selectList("NoticeMapper.selectnotice",null,rowBounds);
		return nList;
	}
	

	public int updateList(SqlSession session,Notice notice) {
		int result = session.update("NoticeMapper.noticeUpdate",notice);
		return result;
	}

	public int deleteNotice(SqlSession session, String noticeNo) {
		int result = session.delete("NoticeMapper.noticeDelete",noticeNo);
		
		return result;
	}

	public Notice selectOneByNo(SqlSession session,int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo",noticeNo);
		
		
		return notice;}
	}

