package encapsulation13;

/*
EncapsulationDTO 에 저장된 데이타를
가공 처리하는 로직을 갖는 클래스
 
-초기화 로직
-입금하는 로직
-인출하는로직
-통장 정보를 출력하는로직 
*/
public class EncapsulationDAO {
	//[멤버변수]
	private EncapsulationDTO capsule= new EncapsulationDTO();
	//[멤버 메소드]
	//-초기화
	public void initialize(String name,String accountNo,int balance) {
		capsule.setAccountNo(accountNo);
		capsule.setBalance(balance);
		capsule.setName(name);
	}////////////initialize
	//-입금하는 로직
	public void deposit(int money) {
		capsule.setBalance(capsule.getBalance()+money);
		System.out.println(money+"가 입금되었어요");
		
	}///////////deposit
	//-인출하는로직
	public void withDraw(int money) {
		if(money > capsule.getBalance()) {
			System.out.println("잔액이 부족해요");
			print();
			return;
		}
		capsule.setBalance(capsule.getBalance()-money);
		System.out.println(money+"가 출금되었어요");
		
	}
	//-통장 정보를 출력하는로직 
	public void print() {
		System.out.println(
				String.format("[%s님의 계좌정보]%n계좌번호:%s%n잔액:%s",
						capsule.getName(),
						capsule.getAccountNo(),
						capsule.getBalance()
						));
	}
}
