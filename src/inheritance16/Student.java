package inheritance16;

//[Student is a Person성립]
public class Student extends Person {	
	//이름과 나이와 주소는 재사용]
	//Student클래스에서 새롭게(확장)한 멤버변수
	String stNumber;//학번	
	
	//기본 생성자]	
	public Student() {
		super();
		System.out.println("Student의 기본 생성자");		
	}	
	//인자 생성자]		
	public Student(String name,int age,String addr,String stNumber) {
		//super();//Person의 기본 생성자.생략해도 자동으로 호출된다
		this.name=name;
		this.age=age;
		this.addr=addr;
		this.stNumber=stNumber;	
		System.out.println("Student의 인자 생성자");		
	}
	//[멤버 메소드]
	//Person에서 정의한 메소드는 재사용
	//Student클래스에서 새롭게 추가한(확장)한 메소드
	void study() {
		System.out.println(String.format("나이가 %d인 %s가 공부한다",age,name));
	}
	String getStudent() {
		return String.format("%s,학번:%s", getPerson(),stNumber);
	}
	void printStudent() {
		System.out.println(getStudent());
	}
	
}
