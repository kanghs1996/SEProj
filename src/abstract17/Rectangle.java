package abstract17;

public class Rectangle extends Figure {

	//[인자 생성자]
	public Rectangle(int width, int height) {
		super(width, height);
		System.out.println("Rectangle의 인자 생성자");
	}
	@Override
	void area(String figureName) {
		System.out.println(figureName+"의 면적:"+width*height);
	}

	

}
