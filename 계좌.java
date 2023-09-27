package SP2;

public class 계좌 {

	private String 계좌번호;
	private String 개설자;
	private int 잔고;
	
	public 계좌(String 계좌번호,String 개설자,int 잔고)
	{ 	this.계좌번호=계좌번호;
		this.개설자=개설자;
		this.잔고=잔고;
	}
	
	
	protected String get계좌() 
	{ return 계좌번호;}	
	protected void set계좌(String 계좌번호)
	{ this.계좌번호 = 계좌번호;}
	
	
	protected String get개설자() 
	{ return 개설자;}
	protected void set개설자(String 개설자)
	{ this.개설자 = 개설자;}
	
	
	protected int get잔고() 
	{ return 잔고;}	
	protected void set잔고(int 잔고)
	{ this.잔고 = 잔고;}
	
	  
	public void 계좌입금(int 잔고) 
	{this.잔고+=잔고;}	
	

/** 출금액이 잔액보다 클경우 예외처리<br>
 * 아니면 정상 출금처리 	
 */		
	public int 출금처리(int 잔고) throws Exception{
		if(this.잔고<잔고) {
		throw new Exception("잔액이 모자랍니다.\n");
		}else {this.잔고-=잔고;}
		
		return 잔고;
		
		
		
		}


	
}
