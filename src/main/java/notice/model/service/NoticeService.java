package notice.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.JDBCTemplate;
import common.SqlSessionTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.PageData;

public class NoticeService {
	NoticeDAO nDao ;
	public NoticeService() {
		nDao = new NoticeDAO();
	};
public int insertNotice(Notice notice) {
SqlSession session = SqlSessionTemplate.getSqlSession();
int result = nDao.insertNotice(session,notice);
if(result>0) {
	session.commit();
}else {
	session.rollback();
}
session.close();
return result;
}
public PageData selectNoticeList(int currentPage) {
SqlSession session = SqlSessionTemplate.getSqlSession();
List<Notice> nList  = nDao.selectNotice(session,currentPage);
String pageNavi = nDao.generatePageNavi(currentPage);
PageData pd = new PageData(nList,pageNavi);

session.close();
return pd;
}
public int updateList(Notice notice) {
SqlSession session = SqlSessionTemplate.getSqlSession();
 int result = nDao.updateList(session,notice);
if(result>0) {
	session.commit();
}else {
	session.rollback();
}
session.close();

return result;
}
public int deletenotice(String noticeNo) {
SqlSession session = SqlSessionTemplate.getSqlSession();
int result = nDao.deleteNotice(session,noticeNo);
if(result>0) {
	session.commit();
}
else {
	session.rollback();
}
session.close();
return result;
}
public Notice detatilNotice(int noticeNo) {
SqlSession session = SqlSessionTemplate.getSqlSession();
Notice notice = nDao.selectOneByNo(session,noticeNo);
if(notice!=null) {
	session.commit();
}else {
	session.rollback();
}
session.close();

return notice;
}

}
