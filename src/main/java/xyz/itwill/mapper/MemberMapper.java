package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.Member;

public interface MemberMapper {
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String id);
	Member selectMember(String id);
	List<Member> selectMemberList();
	
}