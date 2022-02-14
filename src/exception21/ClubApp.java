package exception21;

public class ClubApp {

	public static void main(String[] args) {
		Club club= new Club();
		try {
			club.entrace("남루", 25);
		}
		catch(NotGoodAppearanceException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			club.entrace("정장", 15);
		}
		catch(NotGoodAppearanceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrace("정장", 45);
		}
		catch(NotGoodAppearanceException e) {
			System.out.println(e.getMessage());
		}
		try {
			club.entrace("정장", 25);
		}
		catch(NotGoodAppearanceException e) {
			System.out.println(e.getMessage());
		}

	}

}
