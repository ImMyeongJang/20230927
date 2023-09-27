package SP2;
import java.text.DecimalFormat;
import java.util.*;
/** 작성자:임명장<br>
 * 작성일:'23.09.16~'23.09.21<br>
 * 프로젝트명:java 미니프로젝트 개별과제<br>
 * 상세구현기능:<br>
 * 은행 계좌생성, 조회, 입금, 출금 기능구현(도스)<br>
 * 계좌 클래스사용, 출금처리에서 예외처리 기능 사용<br>
 * DecimalFormat고유번호넣기 및 ++seq자동번호 부여 기능구현<br>
 * 배열 생성 계좌데이터 저장 및 계좌 조회 기능 구현
 */

public class MyBank {

	private static 계좌[] 계좌배열 = new 계좌[100];
	private static	Scanner sc=new Scanner(System.in);
	private static boolean 계좌등록확인=false;
	private static int seq=0;
	private static final String 고유번호 = "410-";
	
	
/** 초기 화면 내용 출력<br>
 * 2,3,4 초기 계좌등록여부 확인, 계좌 미생성시 초기로 돌아감<br>
 * 처음 1'계좌생성'부터 실행가능 또는 5'종료', 그외 번호 다시 확인 메시지출력<br>
 * 계좌생성 100개 가능, 계좌 생성후 조회, 입금, 출금 가능
 */
	public static void main (String[] args) {
	
	System.out.println("---------------------------------");
	System.out.println("1.계좌생성|2.계좌조회|3.입금|4.출금|5.종료");
	System.out.println("---------------------------------");
	System.out.println("안녕하세요. 원하시는 목록번호를 입력해주세요.");
	System.out.println(">>");
	
	int 선택 = sc.nextInt();
	if(선택==1) {계좌생성();}
		else if(선택==2){계좌목록();}
		else if(선택==3){입금();}
		else if(선택==4){출금();}
		else if(선택==5){ 		
				System.out.println("**거래가 종료되었습니다. 감사합니다^^**");
				System.exit(0);}
		
		else{System.out.println("**번호를 다시 확인해주세요**\n");
			  main(args); }}
		
	

/** 최종상태값을 확인
 * 초기값은 false, 등록후 true 
 */
private static boolean 계좌생성확인() {
	return 계좌등록확인;}

	

/** 계좌생성정보 배열에 저장=>>410(고유값)-001(생성번호),성함,잔액<br>
 * 고유번호-000부터 계좌번호 만들기 계좌생성 001번부터 시작<br>
 * 성함,초기입금액을 입력받으면 for if문 배열에 해당 <br>
 * 계좌클래스의 계좌번호,개설자,잔고 데이터를 넣어줌<br>
 * 계좌생성 정보 배열에 저장후 종료, 메인으로 돌아감
 */	
private static void 계좌생성() {
	
	DecimalFormat df=new DecimalFormat("000");
	String 계좌번호=고유번호+df.format(++seq);
	
	System.out.printf("본인의 성함을 입력해주세요.%n>>");
	String 개설자 = sc.next();
	
	System.out.printf("초기입금액%n>>");
	int 초기입금액 = sc.nextInt();
    
	for(int i=0;i<계좌배열.length;i++) {
      if(계좌배열[i]==null) {
    	  계좌배열[i]=
		  new 계좌(계좌번호,개설자,초기입금액);
    	  System.out.println("\n**계좌생성완료**\n");
          계좌등록확인=true;
          
     main(null); break;}}}



 /**계좌생성확인메소드 계좌등록확인 여부  <br>
  * 계좌생성이 0이면 초기로 돌아감 <br>
  * 계좌가 생성되어있으면 for if반복문으로 배열에 저장된 데이터 출력
  */
private static void 계좌목록() {
	
	if(!계좌생성확인()) {
	  System.out.println("**계좌등록을 해주세요**\n");
	  main(null); 

	}else {System.out.println("**생성된 계좌는 아래와 같습니다**\n");
		
	for(int i=0;i<계좌배열.length;i++) {
			if(계좌배열[i]!=null) {			
			  System.out.println("계좌번호:"+계좌배열[i].
	  		  get계좌()+"\n성함:"+계좌배열[i].
	  		  get개설자()+" 님"+"\n잔액:"+계좌배열[i].
	  		  get잔고()+"원\n");}}}
				
	main(null);}
		
	
/** 계좌생성이 0이면 초기로 돌아감<br>
 * 입금 계좌번호 입력, 계좌찾기 메소드에서 확인<br>
 * 입력된 값으로 계좌배열에서 해당하는 계좌정보를 찾아서 리턴받음<br>
 * 계속 입력받다가 계좌번호가 맞아서 계좌정보를 얻어오면 반복문을 빠져나감<br>
 * 확인후 계좌클래스 입금 메소드 실행 입금확인
 */
private static void 입금() {
	
	if(!계좌생성확인()) {         
      System.out.println("**계좌등록을 해주세요**\n");
      main(null); }
	
		System.out.println("입금할 계좌번호를 선택하세요.\nex)410-001 >>");
		계좌 계좌;	
		while(true) {
		String 계좌번호 = sc.next();
	    계좌 = 계좌찾기(계좌번호);

	   if(계좌==null)
	       System.out.println("**계좌번호를 확인하세요**");
	   else break;}

	   	   
	   System.out.print("입금할 금액을 입력하세요.\n>>");
	   
	   int 입금액 = sc.nextInt();
	   계좌.계좌입금(입금액);
	   System.out.println("\n**입금 성공**");
	   System.out.println("현재 잔액은 "+계좌.get잔고()+"원입니다.\n");
	  
   main(null);}


/** 계좌생성이 0이면 초기로 돌아감<br>
 * 출금 계좌번호 입력, 계좌찾기 메소드에서 확인<br>
 * 계좌확인되면 계좌클래스의 출금메소드 실행<br>
 * (잔액 보다 크면 예외처리 부여)
 */
private static void 출금(){
	
	if(!계좌생성확인()) {         
	      System.out.println("**계좌등록을 해주세요**\n");
	      main(null); }
     
		System.out.println("출금할 계좌번호를 선택하세요.\nex)410-001 >>");
		계좌 계좌;	
       while(true) {
           String 계좌번호 = sc.next();
           계좌 = 계좌찾기(계좌번호);
           if(계좌생성확인()==false)
               System.out.println("**계좌번호를 확인하세요**");
           else break;}
             
       System.out.println("현재 출금가능 잔액은 "+계좌.get잔고()+"원입니다.");
       System.out.print("출금할 금액을 입력하세요.\n>>");
       
       int 출금액 = sc.nextInt();
       int result;
            try {
    	result = 계좌.출금처리(출금액);
    	System.out.println("\n**출금 성공**\n잔액은 "+계좌.get잔고()+"원입니다.\n");
    	main(null);
       }catch(Exception e) {
          System.out.println(e.getMessage());
          
  main(null);}}  


/** 문자열의 내용비교, 입금과 출금시 입력받은 계좌번호 비교 확인
 */
private static 계좌 계좌찾기(String 계좌번호) {
    계좌 계좌=null;
    for(int i =0;i<계좌배열.length;i++) {
        if(계좌배열[i]!=null)
        if(계좌배열[i].get계좌().equals(계좌번호)) {
        				계좌 = 계좌배열[i];}}
				
    				return 계좌;}  
		
    
}
	