package xyz.itwill.mapper;

import java.util.List;
import java.util.Map;

import xyz.itwill.dto.Qna;

public interface QnaMapper {
	
	int insertQna(Qna qna); 
	int deleteQna(int idx); 
	int selectQnaCount(); 
	Qna selectQnaComment(int idx);
	Qna selectQna(int idx);
	List<Qna> selectQnaList(Map<String, Object> map);
	int updateAdminQnaAnswer(Qna qna);
	int deleteAdminQnaComment(int idx);
	Qna selectMyQna(String memberId);
	int updateQnaFile(Qna qna);
	int updateQna(Qna qna);
}
