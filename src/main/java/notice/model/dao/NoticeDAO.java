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
	
public String generatePageNavi(int currentPage) {
	int totalCount =209;
	int recordCountPerPage=10;
	int naviCountPerPage=5;
	int totalNaviCount;
	if(totalCount % recordCountPerPage>0) {
		totalNaviCount = totalCount/recordCountPerPage+1;
	}
	else {
	totalNaviCount = totalCount/recordCountPerPage;
	}
	int startNavi =((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
	int endNavi =startNavi+naviCountPerPage-1;
	StringBuffer result = new StringBuffer();
	boolean needPrev = true;
	boolean needNext = true;
	if(startNavi !=1) {
		result.append("<a href='/notice/list.do?currentPage="+(currentPage-1)+"'>[이전]</a>&nbsp;");
	}
	for(int i =startNavi ; i<=endNavi;i++) {
		result.append("<a href='/notice/list.do?currentPage='"+i+">"+i+"</a>&nbsp;&nbsp;");
		
	}
	if(endNavi!=totalNaviCount) {
		result.append("<a href='/notice/list.do?currentPage="+(currentPage-1)+"'>[다음]</a>");

	}
	return result.toString() ;
	
	
}
}
