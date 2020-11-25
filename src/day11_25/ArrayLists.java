package day11_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList
 * 동적배열의 한 종류
 * List 인터페이스를 구현해서 만든 컬렉션 프레임워크
 * 요소의 저장순서가 유지
 * 중복으로 데이터를 저장할 수 있음
 * 크기가 늘어나면 새로운 배열을 생성하고
 * 기존의 요소들을 옮겨야 하는 복잡한 과정이 동반됨.
 *
 * 데이터 추가 : add(대상)
 * 특정 위치에 데이터 추가 : add(위치,대상);
 * 특정 위치 요소 추출 : get(위치);
 * 요소 수정 : set(위치, 대상)
 * 요소삭제 : remove(위치);
 * 요소 모두 삭제 : clear();
 *
 * 컬렉션 자료구조에 저장된 데이터를
 * 출력하려면 foreach 구문사용 (향상된 for문??)
 * 출력하려면 출력문을 담을 새로운 참조변수형이 (ex: String str) 필요
 *
 * 데이터 검색하기
 * 배열에서 원하는 데이터를 찾는 방법은 2가지
 * 위치로 찾음 : get(위치)
 * 실제값 으로 찾음 : contains, indexOf
 */
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();

        // 배열에 데이터 추가
        name.add("제니");
        name.add("지수");
        name.add("로제");
        // 특정위치 데이터 추가
        name.add(3,"리사");

        // foreach문 써서 배열 출력 저장순서대로 출력이 되는걸 확인할 수 있다.
        for(String names : name){
            System.out.println(name);
        }
        // 특정 위치 요소 출력
        System.out.println( name.get(3) );

        // 특정 위치 요소 수정
        name.set(3,"수지");
        System.out.println( name.get(3) ); // 수지 출력을 확인할 수 있다.

        // 요소 삭제
        name.remove(2);
        System.out.println( name.get(2) ); // 기존 2에 저장된 지수가 삭제되고 3에 존재하던 수지가 당겨져 2에 위치하는걸 확인가능

        // 요소 모두 삭제
        name.clear();
        //System.out.println( name.get(0) ); //모두 삭제되어 존재하지않아 오류가 나오는걸 확인 가능

        System.out.println("-----------------------------------------------------------------");

        /**
         * 일반 배열을 ArrayList(동적배열)로 바꾸기
         * ArrayList<String> games = (ArrayList<String>) Arrays.asList(game);
         * 이렇게 작성한다고 하면 문법적으로는 문제가 없지만 실행시 다운캐스팅 오류가 발생한다.
         * Arrays > ArrayList ?? 라서 그런가
         *
         * 배열중에서는 'List'가 조상격이라서 Object를 가져와서 쓰듯 List로 변경해서 가져와서 써도 된다고한다
         * List > Arrays > ArrayList ??
         * 일단 일반배열에서 동적배열로 변환하려면 Arrays 클래스의 asList 메서드를 사용한다.
         * 동적배열의 크기는 .size 메서드를 이용해서 알 수 있다.
         */
        String [] game = { "리그오브레전드","서든어택","배틀그라운드" };

        List <String> games = Arrays.asList(game); // Arrays클래스의 asList 메서드를 사용\
        System.out.println( games );  // game의 배열 값들이 출력되는 것을 확인할 수 있다.
        System.out.println("-----------------------------------------------------------------");


        /**
         * 배열데이터 값들중 원하는 값의 위치를 알아내기
         * 우리가 알던 기존 for 문으로 '위치기반'으로 찾으려 하면
         * 배열 전체를 훑기 때문에 성능이 좋지 못하다.
         * 그런데 '값을 기반'하여 찾으려면 향상된 for문 foreach문으로 찾아 볼 수도 있따.
         * 그외로 if문에 .contains 메서드를 이용해 간단하게 값이 있는지 여부를 알 수 있고
         * 마찬가지로 간단하게 위치를 기반으로 .indexOf 메서드를 이용해서 위치기반으로 알 수 있다.
         */

        for ( int i = 0; i < games.size(); i++ ) {
            if ( games.get(i).equals("리그오브레전드") ){
                System.out.println( i+1 + "번째에서 찾음");
            }
        } //위치기반

        for ( String g : games ) {
            if ( g.equals("리그오브레전드") ){
                System.out.println( "값 존재" );
                break;
            }
        } //값 기반

        if ( games.contains( "리그오브레전드" ) ){
            System.out.println( "데이터 찾음 !!" );
        } // .contains를 이용해서 간단히 값을 기반으로 존재유무 찾기

        // .indexOf 를 이용해서 위치찾기
        System.out.println( games.indexOf( "리그오브레전드" ) );
        System.out.println("-----------------------------------------------------------------");

        /**
         * 게임정보에 ( 게임이름, 가격 ) 의 객체 생성을 위해 class ( GameInfo )를 생성후
         * 멤버변수로 게임이름과 가격을 만들고
         * 매개변수를 받는 생성자를 만든다.
         * 이후 3가지 게임에 대한 이름과 가격 정보를 생성자를 이용해 객체를 만들고
         * 생성한 객체들을 동적배열에 저장한다 List 클래스를 활용해서 (업캐스팅 해서 작성하는게 더 용이하고 편리함)
         */
        // 객체 생성
        GameInfo g1 = new GameInfo("배틀그라운드",45000);
        GameInfo g2 = new GameInfo("피파21",55000);
        GameInfo g3 = new GameInfo("디아블로",35000);

        // GameInfo 클래스 동적배열로 만들기 List활용
        List <GameInfo> games2 = new ArrayList<>();

        // add 메서드를 통한 데이터 추가
        games2.add( g1 );
        games2.add( g2 );
        games2.add( g3 );

        /**
         * 배열화된 데이터 값들을 출력하려면
         * GameInfo클래스의 멤버변수인 name,price 를 .name .price 이런식으로 붙여줘야함
         * ArrayList의 요소가 GameInfo의 객체이므로 GameInfo의 주소값이 저장되기 때문에
         * + 지금 만든 GameInfo 클래스의 멤버변수들은 디폴트 값으로 선언해서 그렇지
         * private등 으로 접근제한자가 높은 애들로 선언하면 getter 를 만들어서 받아야함.
         */
        // 배열화시킨 데이터 값들 출력해보기
        System.out.println( games2.get(1).name );
        System.out.println( games2.get(1).price );


        /**
         * 실습)
         * 특정 요소를 검색하는 코드를 4가지 ( for, foreach, contains, indexOf ) 버전으로 작성
         * 위에서의 'game' 배열예제는 String을 받았지만 지금은 객체를 받기 때문에 .name이 붙음
         */

        // for 사용
        for ( int i = 0; i < games2.size(); i++) {
            if ( games2.get(i).name.equals("배틀그라운드")) {
                System.out.println( "--------------for사용------------" );
                System.out.println( "데이터 찾음 !!" );
                break;
            }else {
                System.out.println( "--------------for사용------------" );
                System.out.println( "데이터 못찾음 !!" );
                break;
            }
        }

        // foreach 사용
        for ( GameInfo g : games2 ) {
            if ( g.name.contains("배틀그라운드") ) {
                System.out.println( "--------------foreach 사용------------" );
                System.out.println( "데이터 찾음 !!" );
                break;
            }else{
                System.out.println( "--------------foreach 사용------------" );
                System.out.println( "데이터 못찾음 !!" );
                break;
            }
        }

        // contains 사용

        for(GameInfo g: games2) {
            if (g.name.contains("배틀그라운드")) {
                System.out.println("-------contains-------");
                System.out.println("데이터 값 찾음 !!!");
                break;
            } else {
                System.out.println("-------contains-------");
                System.out.println("데이터 값 못찾음 !!!");
                break;
            }
        }
        // indexOf 사용
        for(GameInfo g: games2){
            if( g.name.indexOf("배틀그라운드")>=0){
                System.out.println("-----------indexOf---------");
                System.out.println("데이터 찾음!");
            }
        }










    }
}
class GameInfo{
    String name;
    int price;

    public GameInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
