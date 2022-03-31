package xyz.itwill.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.itwill.dto.Qna;
import xyz.itwill.mapper.QnaMapper;

@Repository
public class QnaDAOImpl implements QnaDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int deleteQna(int idx) {
		return sqlSession.getMapper(QnaMapper.class).deleteQna(idx);
	}

	@Override
	public int selectQnaCount() {
		return sqlSession.getMapper(QnaMapper.class).selectQnaCount();
	}
	@Override
	public Qna SelectQnaComment(int idx) {
	
		return sqlSession.getMapper(QnaMapper.class).selectQnaComment(idx);
	}
	
	@Override
	public Qna selectQna(int idx) {
		return sqlSession.getMapper(QnaMapper.class).selectQna(idx);
	}

	@Override
	public List<Qna> selectQnaList(Map<String, Object> map) {
		//System.out.println("DAO = "+startRow);
		return sqlSession.getMapper(QnaMapper.class).selectQnaList(map);
	}

	@Override
	public int insertQna(Qna qna) {
		
		return sqlSession.getMapper(QnaMapper.class).insertQna(qna);
	}

	@Override
	public int updateAdminQnaAnswer(Qna qna) {
		return sqlSession.getMapper(QnaMapper.class).updateAdminQnaAnswer(qna);
	}

	@Override
	public int deleteAdminQnaComment(int idx) {
		return sqlSession.getMapper(QnaMapper.class).deleteAdminQnaComment(idx);
	}

	@Override
	public int updateQnaFile(Qna qna) {
		return sqlSession.getMapper(QnaMapper.class).updateQnaFile(qna);
	}

	@Override
	public int updateQna(Qna qna) {
		return sqlSession.getMapper(QnaMapper.class).updateQna(qna);
	}

	@Override
	public Qna selectMyQna(String memberId) {
		return sqlSession.getMapper(QnaMapper.class).selectMyQna(memberId);
	}

	
	
	
}
