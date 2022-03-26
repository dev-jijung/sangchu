package xyz.itwill.exception;

import xyz.itwill.dto.Member;

//ȸ����Ͻ� ����ڰ� �Է��� ���̵� �̹� �����ϴ� ��츦 ���� �ۼ��� ����Ŭ����
public class UserinfoExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	//���� ó���� �ʿ��� ���� �����ϱ� ���� �ʵ�
	// => ����ڰ� �Է��� ȸ�������� �����ϱ� ���� �ʵ� ����
	private Member member;
	
	public UserinfoExistsException() {
		// TODO Auto-generated constructor stub
	}

	public UserinfoExistsException(String message, Member member) {
		super(message);
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	
}
