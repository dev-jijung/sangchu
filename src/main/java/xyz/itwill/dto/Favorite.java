package xyz.itwill.dto;

/*
�̸�          ��?       ����           
----------- -------- ------------ 
IDX         NOT NULL NUMBER       
PRODUCT_IDX          NUMBER       
MEMBER_ID            VARCHAR2(50) 
 */
public class Favorite {
	private int idx;
	private int productIdx;
	private String memberId;
	
	
	public Favorite() {
		// TODO Auto-generated constructor stub
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public int getProductIdx() {
		return productIdx;
	}


	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
