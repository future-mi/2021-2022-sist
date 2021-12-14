package com.sist.main;
/*
 * 	자바의 단어(개념→기술면접) → 구현
 * 	→ 웹(CURD),모바일
 * 
 * 객체지향 프로그램
 * 	장점 : 코드 재사용이 용이, 유지보수가 쉬움, 대형프로젝트에 적합
 * 	단점 : 처리속도가 상대적으로 느림, 객체가 많으면 용량이 커질 수 있음, 설계시 많은 시간과 노력이 필요
 *  1.캡슐화 : 데이터 보호 목적, 경계제작시 사용
 *  		→ 은닉화 : private → 멤버변수, 메소드(다른 클래스와 연결, public)
 *  2.상속/포함
 *  	1)상속 : 확장해서 새로운 클래스를 만든다, 변경해서 사용
 *  		- 단일상속 → extends / class B extends A → 재사용을 목적 / B는 A다 
 *  				  ex) class 인간 extends 동물 → 인간은 동물이다
 *  					 class Login extends JFrame → is a
 *  
 *  	2)포함 : 라이브러리, 있는 그대로를 사용
 *  			class Login
 *  			{
 *  				JFrame f=new JFrame(); → has a
 *  			}
 *  
 *  3.다형성(오버로딩/오버라이딩)
 *  	1)추가 : 오버로딩
 *  	2)수정 : 오버라이딩(자바는 미국에서 만들어져서 우리나라 실정에 맞지 않을 수 있어서 오버라이딩을 많이씀)
 *  			→ 한글변환
 *  4.클래스의 종류
 *  	1)일반클래스
 *  		- 기능(메소드) → CURD(추가,수정,읽기,삭제)
 *  					  Create, update, read, delete / Insert, update, select, delete
 *  			~DAO, ~Manager(크롤링,XML,JSON)
 *  		- 데이터만 관리하는 클래스 → 사용자 정의 데이터형
 *  			~VO, ~DTO
 *  		- 프로그램(데이터수집, 데이터관리, 데이터처리)
 *  
 *  	2)추상클래스 : 클래스의 공통점(공통으로 사용하는 기능)
 *  				추상클래스는 abstract가 붙음 
 *  				설계만 하고 구현은 X → 미완성 클래스, 완성해서 사용해야함
 *  
 *  		[추상클래스의 구성요소]
 *  		abstract class A
 *  		{
 *  		===================================
 *  			멤버변수
 *  		===================================
 *  			구현된 메소드
 *  			public void display()
 *  			{
 *  			}
 *  		===================================
 *  			구현이 안된 메소드(선언)
 *  			public abstract void display();
 *  		===================================
 *			}     → 추상 클래스는 단일 상속만 가능  	
 *  
 *  		- 인터페이스(스프링은 인터페이스 기반) : 추상클래스의 일종
 *  		interface interface_name
 *  		{
 *  		====================================
 *  			변수 → 상수형 변수(값을 주입)
 *  			int a;(오류)
 *  			public static final int a=10;
 *  			(public static final 생략이 가능)
 *  		====================================
 *  			메소드 → 설계
 *  			public void display();
 *  			public abstract void display();
 *  			void display(); 만 써도 됨
 *  		====================================
 *			→ JDK 1.8에서 구현된 메소드가 사용가능하게 변경됨(default)
 *			public default void display();
 *			
 *  		}	
 *  			[인터페이스 특징]
 *  			(1)독립적으로 사용이 가능
 *  			(2)서로다른 연결할 때 주로 사용(관련된 클래스를 여러개 묶어서 사용)
 *  				- 데이터가 여러개 (이름 한개로 관리 → 배열)
 *  				- 클래스가 여러개 (인터페이스)
 *  			(3)표준화 작업할 때 주로 사용 → 모든 개발자 동일하게 사용
 *  									프레임워크(프로그램 통일화 : 스프링, 마이바티스) / 형식이 동일 → 분석은 동일하게 가능
 *  			(4)추상클래스를 보완 → 다중구현이 가능(상속)
 *  					interface 비행기
 *  					interface 배
 *  					interface 자동차 extends 비행기,배
 *  										   ======= 다중상속
 *  					interface → interface / extends
 *  					interface → class 	  /	implements → overriding(윈도우,쓰레드,컬렉션)
 *  					class → interface(X)  / 존재하지 않음
 *  		→ 공통점
 *  
 *  	3)내부클래스
 *  		- 서로다른 클래스가 공유하는 데이터가 많은 경우 사용(서로다른 클래스에서 데이터를 공유 → static)
 *  			→ 쓰레드(서버프로그램에서 많이 등장→웹서버 존재), 윈도우(애플리케이션), 네트워크
 *  		- 상속없이 오버라이딩 : 익명의 클래스
 *  
 *  		(1)데이터공유 : 멤버클래스
 *  			class A
 *  			{
 *  			=======
 *  			데이터
 *  			=======
 *  			class B(쓰레드)
 *  				{
 *  					A가 가지고있는 모든 데이터를 마음대로 사용이 가능
 *  				}
 *  			} 
 *  		(2)상속없이 오버라이딩 : 익명의 클래스
 *  			class A
 *  			{
 *  			}
 *  			class B
 *  			{
 *  				public void display(){}
 *  			}	
 *  			
 *		  		→ class A extends B
 *  			{
 *  				public void display(){내용변경}
 *  			}	
 *  
 *  			class A 
 *  			{
 *  				B b=new B()	
 *  				{
 *  				public void display(){내용변경} : 오버라이딩
 *  				}
 *  			}	
 *  			class B
 *  			{
 *  			public void display(){}
 *  			}
 *  				→ 웹은 상속,인터페이스 구현(X) / Object(모든 클래스의 상위 클래스)
 *												→ 형변환(클래스 → is-a(상속),has-a(포함))
 *				===================================================================
 *				class A
 *				{
 *					int a,b,c,d,e,f,g; // →  28byte 
 * 				}
 *  			class B
 *				{
 *					int a,b; // →  8byte
 * 				}
 * 					→ 실제 클래스 크기는 동일(저장 → 주소값이 저장(int범위에서만 사용))
 * 						A와 B클래스는 크기 비교가 불가능
 * 				====================================================================
 * 				class A
 * 				{
 * 					// 실제 크기는 A가 크다
 * 				}
 * 				class B extends A
 * 				{
 * 					// 메모리는 B가 크다
 * 				}
 *  				→ 상속을 내리는 클래스가 크다 A>B
 * 				
 * 					- 객체생성
 * 						A a=new A(); → double a=10.5;
 * 						B b=new B(); → int b=10;
 * 						A c=new B(); → double c=10;
 * 						B d=new A(); (X)  
 * 							→ B d=(B)new A(); //형변환을 사용한다 → int d=(int)10.5;
 * 					- 일반 데이터형과 동일하게 취급
 * 							
 * 
 *  	게시판 : 목록, 상세보기, 추가, 수정, 삭제
 *  	  |
 *    =========
 *  묻고답하기,  자료실,  후기게시판,  댓글형게시판
 * 					→ 파일업로드	→ 댓글
 *  → 답변	 → 파일업로드/다운로드
 *  	버튼 → 인터페이스(기능설계 → 프로그래머에 전담해서 만들어야함)
 *  
 *  
 */


public class MainClass {
	
	public static void main(String[] args) {
	
	}
}
