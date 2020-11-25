package day11_25;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 지네릭Generic
 * 데이터 유형을 일반화(통일) 한다는 것을 의미
 * 1. 여러 유형의 데이터를 사용하는 클래스의 경우
 * 2. 매개변수의 유형을 Object로 선언하는 경우
 * 경우에 따라 원래의 유형으로 변화해야하는
 * 번거로움이 존재하고 오류가 발생할 수 있는 가능성 존재
 */
public class Collections {
    public static void main(String[] args) {
        //오브젝트형의 변수,클래스는 모든 종류의 변수를 다담을 수 있다. 최고봉 조상격
        Object zoo[] = new Object[10];
        /**
         * 일반적으로 배열은 동일한 유형의
         * 자료들을 저장하는 자료구조이지만
         * 배열의 유형을 'Object'로 선언하면
         * 온갖 종류의 데이터들을 저장할 수 있음
         */
        // 동물들을 동물원 우리에 가둠
        zoo[0] = new Tiger(); // upcasting 적용 Object형은 맨꼭대기에 있으니까 조상님
        zoo[1] = new Lion();
        zoo[2] = new Zebra();

        /**
         * 하지만, 배열에 저장된 데이터를 빼낼때는
         * 적절한 형변환이 필요함!!(downcasting)
         */
        // 동물원 우리에서 동물들을 하나씩 빼냄
        //Tiger t1 = zoo[0]; //오류가 나오는것을 확인된다 다운캐스팅이 필요
        Tiger t1 = (Tiger) zoo[0];
        Lion l1 = (Lion) zoo[1];
        Zebra z1 = (Zebra) zoo[2];

        /**
         * 컬렉션 프레임 워크
         * 다수의 데이터를 쉽고 효과적으로
         * 처리할 수 있도록 표준화 방법을 제공하는 클래스
         * 데이터를 저장하는 자료구조와 처리하는
         * 각종 알고리즘을 구조화하여 클래스로 구현해 놓은 것
         * 동적배열, 집합, 해시맵(HashMap), 트리, 큐
         */

        /**
         * ArrayList(동적배열의 한종류) -컬렉션 프레임워크에서 제공하는 동적배열
         * 위에서 동물원(zoo)배열을 만들었을 때는 배열 순서를 정해줘서 저장했지만
         * 여기서는 알아서 순서를 정해서 들어간다.(기준10개)
         * 집어넣는 데이터가 11개째가 되면 10개가 추가생성되어 20개가 생성된 상태에서 들어가게 된다.
         * 동적 배열의 자료형은 기본적으로 Object이다.
         *
         * import java.utill.ArrayList; 전에 스캐너를 사용할때 가져오는 것처럼 이것 역시 가져와서 써야한다.
         */
        ArrayList zoo2 = new ArrayList();

        // add 메서드를 이용해서 zoo2 동적배열에 값을 넣어보자
        zoo2.add( new Tiger() );
        zoo2.add( new Lion() );
        zoo2.add( new Zebra() );

        // 동적배열 사용시 zoo 배열에서와 마찬가지로 형변환 안하면 오류가나온다.
        //t1 =  zoo2.get(0);
        t1 = (Tiger) zoo2.get(0);
        l1 = (Lion) zoo2.get(1);
        z1 = (Zebra) zoo2.get(2);

        /**
         * 지네릭을 이용하면 데이터의 타입을 통일시켜
         * 컴팡리시 타입체크 오류방지와
         * 불필요한 형변환을 없앨 수 있음
         * 어떻게?
         * type-parameter '<>' 을 이용해서 자료구조의
         * 데이터 유형을 미리 설정해둠
         */
        ArrayList<Tiger> zoo3 = new ArrayList<>();
        zoo3.add( new Tiger() );
        zoo3.add( new Tiger() );
        //zoo3.add( new Lion() );  // '<>' 을통해 Tiger 클래스만 들어올수있게 해놔서 Lion은 들어올 수 없다.
        t1 = zoo3.get(0);   // 위에 설명했듯이 자동으로형변환이 되기때문에 오류없이 처리가 가능






    }
}

class Tiger{}
class Lion{}
class Zebra{}