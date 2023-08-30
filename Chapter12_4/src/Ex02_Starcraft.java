//extends
//부모에서 선언 / 정의를 모두하며 자식은 메소드 / 변수를 그대로 사용할 수 있음
//자바는 "다중상속"을 지원하지 않는다는 점이다.

//implements (interface 구현)
//부모 객체는 선언만 하며 정의(내용)은 자식에서 오버라이딩 (재정의) 해서 사용해야함
//implements의 가장 큰 특징은 이렇게 부모의 메소드를 반드시 오버라이딩(재정의)해야 한다.
//또한 이 implements는 다중상속을 대신해준다.

//abstract
//extends와 interface 혼합. extends하되 몇 개는 추상 메소드로 구현되어 있음

//※ class가 class를 상속받을 땐 extends를 사용하고, 
//※ interface가 interface를 상속 받을 땐 extends를 사용한다.
//※ class가 interface를 사용할 땐 implements를 써야하고
//※ interface가 class를 사용할 땐 implements를 쓸수 없다.
//※ extends는 클래스 한 개만 상속 받을 수 있다.
//※ extends 자신 클래스는 부모 클래스의 기능을 사용한다.
//※ implements는 여러개 사용 가능하다.
//※ implements는 설계 목적으로 구현 가능하다.
//※ implements한 클래스는 implements의 내용을 다 사용해야 한다.
abstract class Building
{
	int health;

	abstract void doBuild();
}

interface Fly
{
	void flyBuilding();
}

class Barracks extends Building implements Fly
{
	void doBuild()
	{
		System.out.println("인간형 유닛 생산 건물을 짓습니다");
	}

	void doMakeMarine()
	{
		System.out.println("총쏘는 유닛을 생산합니다.");
	}

	public void flyBuilding()
	{
		System.out.println("건물이 날아서 이동하게 합니다.");
	}
}

class Factory extends Building implements Fly
{
	void doBuild()
	{
		System.out.println("기갑형 유닛 생산 건물을 짓습니다.");
	}

	void doMakeTank()
	{
		System.out.println("탱크 유닛을 생산합니다.");
	}

	public void flyBuilding()
	{
		System.out.println("건물이 날아서 이동하게 합니다.");
	}
}

class Bunker extends Building
{
	void doBuild()
	{
		System.out.println("인간형 유닛이 숨을 건물을 짓습니다.");
	}

	void doDefense()
	{
		System.out.println("숨을 유닛을 적의 공격으로부터 보호합니다.");
	}
}

public class Ex02_Starcraft
{

	public static void main(String[] args)
	{
		Barracks barracks = new Barracks();
		barracks.doBuild();
		barracks.doMakeMarine();
		barracks.flyBuilding();

		Factory factory = new Factory();
		factory.doBuild();
		factory.doMakeTank();
		factory.flyBuilding();

		Bunker bunker = new Bunker();
		bunker.doBuild();
		bunker.doDefense();
	}

}
