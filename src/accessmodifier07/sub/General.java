package accessmodifier07.sub;

import accessmodifier07.Super;

public class General{
	/*
	 * private 멤버만 접근 불가
	 * 같은 패키지에 있음으로  생략형 및 protected 및 public
	 * 모두 접근 가능.
	 * 또한 같은 패키지에 있기때문에 import할 필요 없다.
	 */
	void access() {
		
		Super sup = new Super();
		//sup.packageMethod();//[x]is not visible
		//sup.protectedMethod();//[x]is not visible
		
		sup.publicMethod();
	}
}
