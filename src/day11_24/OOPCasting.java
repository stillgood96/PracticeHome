package day11_24;

/**
 * 클래스/인터페이스 형변환
 * 특정 객체가 자식클래스/인터페이스 타입에서
 * 부모클래스/인터페이스 타입 또는 반대로 형변환 하는 것을 의미
 */

public class OOPCasting {
    public static void main(String[] args) {
        Unit unit = new Unit();               //각각 클래스의 생성자를 이용해 attack메서드 써보기
        Marine mr = new Marine();
        Firebat fb = new Firebat();

        unit.attack();
        mr.attack();
        fb.attack();
        System.out.println("-------------");
        /**
         * 부모클래스의 데이터 타입은 자식클래스의 데이터 타입을 가져올 수 있고
         * Marine 객체는 자동으로 Unit 객체로 형변환
         * 이처럼 상속관계에 있는 클래스간의 객체 생성시
         * 자식 클래스타입의 객체가 부모클래스 타입의 객체로 선언하는 경우
         * 업캐스팅이라 (upcasting)라 고 함
         */
        Unit unit1 = new Marine();
        unit1.attack();

        // Marine m3=(Marine) new Unit();
        //Firebat f2=(Firebat)new Unit();
        // Unit 객체는 Firebat 객체로 형변환 하려면
        // 명시적 형변환을 필요하다.
        // 부모클래스타입의 객체를 자식클래스타입의 객체로
        // 선언하는 경우 다운캐스팅(downcasting)이라고 함.
        // 단, 컴파일시에는 오류가 나지 않지만
        // 실행시 오류 발생!

        /**
         * 부모클래스의 데이터타입을 자식 클래스의 객체에서 선언하려고하면  위에 방법으로는 오류가나오는데
         * 이렇게 해결하면 다운캐스팅 할 수 있따.
         */
        Marine m3=(Marine)unit1;
        m3.attack();
        unit1.attack();
    }
}

class Unit {
    protected int hp;
    protected int mp;

    public void attack(){
        System.out.println("공격중 입니다...");
    }
}
class Marine extends Unit {
    @Override
    public void attack() {
        System.out.println("해병대가 공격중...");
    }
}
class Firebat extends Unit {
    @Override
    public void attack() {
        System.out.println("불곰이 공격중...");
    }
}
