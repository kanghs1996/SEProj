package polymorphism14;

import java.util.Date;

public class Child extends Parent {
	//[멤버 변수]
	String newExtendVar;//자식에서 새롭게 확장한 멤버	
	//[인자 생성자]
	public Child(String name, int age,String newExtendVar) {
		super(name, age);
		this.newExtendVar=newExtendVar;
	}
	//[멤버 메소드]
	void newExtendMethod() {//자식에서 새롭게 확장한 멤버
		System.out.println("자식에서 새롭게 확장한 멤버");
	}
	//자식에서 새롭게 확장한 메소드
	//오버라이딩이 아님[x]
	//부모의  private이 붙은 메소드는 오버라이딩
	//절대불가(자식에서 안보이니까)	
	private void eat() {
		System.out.println("자식이 먹는다");
	}
	@Override
	public String sleep(int age) {//접근지정자는 부모와 같거나 부모보다 넓어야 한다
		System.out.println("자식이 잔다");
		return null;
	}
	//오버로딩에 해당-부모의 walk는 오버라이딩 안하고
	//그대로 사용.매개변수 타입만 다르게해서 사용
	//자식에서 새롭게 확장한 메소드와 같다
	int walk(int date) {
		System.out.println("나이가 "+age+"살인 자식이 걷다");
		return 0;
	}
	@Override
	public void exercise() {
		//부모의 메소드를 그대로 사용하도록 재정의
		//super.exercise();
		//부모의 메소드를 그대로 사용하지 않고 새롭게 재 정의
		System.out.println("자식이 운동한다");
	}
	@Override
	String getParent() {		
		return super.getParent()+",자식 멤버변수:"+newExtendVar;
	}
	@Override
	void printParent() {
		System.out.println(getParent());
	}
	
	//오버라이딩이 아님[x].
    //정적 메소드는 오버라이딩 불가
	static void staticMethod() {
		System.out.println("자식의 정적 메소드");
	}
	
	
}
