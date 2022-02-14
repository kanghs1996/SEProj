package inheritance16;

//[Teacher is a Person성립]
public class Teacher extends Person {	
	//이름과 나이와 주소는 재사용]
	//Teacher클래스에서 새롭게(확장)한 멤버변수
	String subject;//과목	
	//인자 생성자]		
	public Teacher(String name,int age,String addr,String subject) {
		//super();//Person의 기본 생성자.생략해도 자동으로 호출된다
		this.name=name;
		this.age=age;
		this.addr=addr;
		this.subject=subject;		
	}
	//[멤버 메소드]
	//Person에서 정의한 메소드는 재사용
	//Teacher클래스에서 새롭게 추가한(확장)한 메소드
	void teach() {
		System.out.println(String.format("%s샘이 %s과목을 가르치다",name,subject));
	}
	String getTeacher() {
		return String.format("%s,과목:%s", getPerson(),subject);
	}
	void printTeacher() {
		System.out.println(getTeacher());
	}
	
}
