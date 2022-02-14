package thread23;


class Solidier{
	void longedMethod() {
		for(int i=0;i<=10;i++) {
			System.out.println(
					String.format("[현재 실행중인 스레드명:%s,i=%s]",
					Thread.currentThread().getName(),i));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

//1]Runnable인터페이스 상속
class Commander extends Solidier implements Runnable{
	//2]run()오버라이딩
	@Override
	public void run() {
		longedMethod();		
	}
	
	
}/////////////


public class RunnableApp {

	public static void main(String[] args) {
		Commander commander = new Commander();
		//commander.start();//[x]
		System.out.println(commander instanceof Commander);
		System.out.println(commander instanceof Solidier);
		System.out.println(commander instanceof Runnable);
		//Runnable타입을 Thread클래스의 인자 생성자를 이용해서 Thread타입으로 변환
		Thread th1 = new Thread(commander);
		th1.setName("첫번째 스레드");
		th1.start();
		Thread th2 = new Thread(commander,"두번째 스레드");
		th2.start();

	}////////main
}////////////class
