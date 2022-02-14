package inheritance16;

public class PersonApp {

	public static void main(String[] args) {
		/*
		 * 생성자 호출 순서:
		 * 부모 생성자 -> 자식 생성자
		 */
		System.out.println("[기본 생성자로 객체 생성:Student]");
		Student student1 = new Student();
		student1.printStudent();
		//인스턴스 변수로 접근해서 멤버 초기화
		student1.name="가길동";
		student1.age=20;
		student1.addr="가산동";
		student1.stNumber="2021학번";
		System.out.println(student1.getStudent());
		System.out.println("[인자 생성자로 객체 생성:Student]");
		Student student2 = new Student("나길동", 30, "성북동", "2016학번");
		student2.printStudent();
		student2.study();
		/*
		인자 생성자를 정의해서 더 이상 기본생성자를
		제공해주지 않음으로...
		기본 생성자로 객체 생성하려면
		기본 생성자를 직접 정의해주어야 한다.*/
		//Teacher teacher = new Teacher();//[x]
		Teacher teacher= new Teacher("홍길동", 40, "인천","자바");
		teacher.printTeacher();
		teacher.teach();

	}////////////////main
}/////////////class
