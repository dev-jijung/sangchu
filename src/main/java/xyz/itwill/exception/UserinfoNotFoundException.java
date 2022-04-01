package xyz.itwill.exception;

//ȸ�������� ����,����,�˻��� ���̵��� ȸ�������� ���� ��츦 ���� �ۼ��� ����Ŭ����
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String id;
	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);	
		
	}
	
	public UserinfoNotFoundException(String message,String id) {
		
		super(message);
		this.id=id;
		
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
