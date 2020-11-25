package day11_25;

import java.util.*;

public class AdvCollection {
    public static void main(String[] args) {
        /**
         * Set : 집합
         * Set 인터페이스를 구현한 컬렉션 클래스
         * 요소의 저장순서가 유지 안됨
         * 데이터를 중복으로 저장불가
         *
         * HashSet : 해쉬 알고리즘을 이용해서
         * 데이터를 저장하기 때문에 검색 속도가 빠름
         *
         * 일반적으로 저장된 자료의 양에 상관없이
         * 특정 데이터를 찾는데 걸리는 시간이
         * 항상 일정할 순 없을까 ?
         * => 해쉬 알고리즘을 이용해서 실현
         *
         * // import java.util.HashSet;
         * // import java.util.Set;
         */

        Set<String> names = new HashSet<>();

        //데이터 추가
        names.add( "모모" );
        names.add( "정연" );
        names.add( "사나" );
        names.add( "사나" ); // 중복 데이터 추가

        //데이터 모두 출력
        /**
         * HashSet에서는 get을 사용못하므로 foreach문으로 사용
         */
        for ( String name : names ) {
            System.out.println( name );
        }
        System.out.println("---------------------------------");

        /**
         * 컬렉션 요소 순회 iterate 하기
         * 컬렉션 프레임워크에 저장된 각 요소들을
         * 읽어오는 방법을 표준화한 것.
         *
         * Iterator는 OOP프로그래밍에서 배열이나
         * 그와 유사한 자료구조의 내부 요소를
         * 순회하는 객체를 의미
         *
         * hasNext() 메서드는  다음 요소가 있는지 없는지 확인하는 메서드
         * 다음으로 이동하는 next() 메서드
         * 읽어온 요소를 삭제하는 remove() 메서드가 제공된다.
         */
        Iterator<String> itr = names.iterator();

        while ( itr.hasNext() ) {
            System.out.println( itr.next() );
        }
        System.out.println("-------------------------------");

        /**
         * 데이터 수정 하려면 set 을 이용할거라 생각하는데
         * Set에서는 set메서드 사용불가
         * 따라서 간단하게 기존값 삭제후 추가로 수정해야 함.
         */

        names.remove( "모모" );
        names.add( "미나" );

        // hashset에 다양한 유형의 값을 추가해 봄

        names.add( "여자친구" );
        names.add( "신비" );
        names.add( "유주" );
        names.add( "볼빨간사춘기" );

        names.add( "123" );
        names.add( "123123" );
        names.add( "12312512" );

        // iterator로 또 출력해보기

        Iterator <String> itr2 = names.iterator();
        while(itr2.hasNext()) {
            System.out.println(itr2.next());
        } // 값들이 특이한 순서로 출력됨

        //=> 결과는 각 데이터의 고유 해쉬값에 의해 정렬되어 출력된다는걸 확인가능..
        System.out.println("----------------------------------");



        /**
         * HashMap
         * 키와 값으로 저장하는 컬렉션 클래스
         * Map 인터페이스를 구현한 컬렉션 클래스
         * 키와 값을 하나의 쌍으로 저장하는 방식을 사용
         * 키는 실질적으로 값을 찾기 위한 방편으로 사용
         * 요소의 저장순서는 유지되지 않음
         * 키는 중복 데이터를 저장할 수 없음
         * 단, 값은 중복으로 저장할 수 있음
         * 해시 알고리즘을 사용하기 때문에
         * 검색속도가 매우 빠름
         *
         * 데이터 추가 : put(키,값);
         * 게임이름과 가격을 저장하는 해시맵을 생성
         *
         * 값 조회 : get(키)
         *
         * 모든 키 확인 : keySet 메서드 사용
         * keySeT 메서드의 리턴 값은 set임
         *
         * 모든 값 확인 : values
         * values의 메서드 리턴값은 Collection
         *
         *
         * 해시맵에서는 제네릭 표기형인 Integer 형식으로 써야한다. int가 아닌..
         *
         */

        Map<String, Integer> game1 = new HashMap<>();

        // 값 넣기
        game1.put( "리그오브레전드",45000 );
        game1.put( "배틀그라운드",35000 );
        game1.put( "GTA5",55000 );

        // 값 조회
        System.out.println( game1.get("배틀그라운드") );

        // 모든 키 조회 keySet
        Set <String> key = game1.keySet();
        for ( String keys : key ) {
            System.out.println( key );
        }

        // 모든 값 조회 values
        Collection <Integer> value = game1.values();
        for ( Integer values : value ) {
            System.out.println( value );
        }

        System.out.println("--------------------------------");

        Map < Integer, GameInfo > product = new HashMap<>();

        product.put(143, new GameInfo("롤",45000)); // GameInfo의 매개변수 생성자를 통해 두개 값 입력
        product.put(123, new GameInfo("배그",25000));
        product.put(113, new GameInfo("메이플",15000));

        // 143인 키 게임의 정보 출력
        System.out.println( product.get(143).name + product.get(143).price );

        // product 게임 전부 출력
        Set < Integer > keys = product.keySet();
        for( Integer key2 : keys ) {
            System.out.print( "키가" + key2 + "인 게임정보: ");
            System.out.print( product.get(key2).name + product.get(key2).price );
            System.out.println("");
        }
        System.out.println("----------------------------------");
        /**
         * 실습)
         * 로또 1~45 사이 임의의 숫자 6개를 만드는 코드 작성
         * 단 중복 숫자는 허용하지 않음
         *
         * HashSet으로 만들면 중복된 값은 저장이 안되지만 6개를 뽑았을때 중복 숫자가
         * 있으면 5개 혹은 4개만 출력이 될 수 있을 것 같아
         * HashMap으로 1~6번을 키에넣고 키값으로 랜덤 번호를 뽑는걸로 구현해봄
         */
        Map < Integer, Integer > lotto = new HashMap<>();

        // 6개번호 설정
        for( int i = 0; i < 6; i++ ) {
            lotto.put( i, (int)(Math.random()*45)+1);
        }
        // 6개번호들중 중복번호 걸러내기
        // 전에 로또프로그램 처럼 반복문안의 반복문으로 랜덤숫자를 생성하고 중복되면 다시 생성하는
        // 방식은 HashMap에서는 안됨 => 하나뽑고 그다음꺼 뽑고 그전꺼랑 비교가 안되는 것 같다.

        for ( int i = 0 ; i < 6; i++ ) {
            for ( int j = i+1; j >= 0; j-- ) {
                if ( lotto.get(i).equals(lotto.get(j)) ) {
                    lotto.remove(i); // 지워줘야지 새 값 다시받을 수 있음
                    lotto.put( i, (int)(Math.random()*45)+1);
                }else break;
            }
        }

        Collection < Integer > print = lotto.values();
        System.out.println( print );


        /**
         * 해시알고리즘
         * 해시함수 : 임의의 길이를 갖는 임의의 데이터에 대해
         * 고정된 길이의 데이터로 매핑하는 함수
         * 해시값 : 해시함수를 적용해서 나온 값
         * 해시함수는 복잡한 알고리즘을 사용하지 않기 때문에
         * CPU연산이 많이 필요하지 않음
         * 같은 입력값에 대해서는 값은 출력값이 출력
         * 단, 해시함수 알고리즘에 따라 다르게 출력 가능
         * 간혹, 서로 다른 데이터에 대해 같은 결과 값이
         * 나오는 경우 발생 => 충돌
         * 대표적인 해시함수 :MD5, SHA256
         * 응용 분야 : 레코드 검색, 유사 레코드 비교 ,암화화화화
         *
         *    // https://url.kr/IJ7jdR
         *         // shar256 hash코드 생성기
         *         // sha (secure hash algorithm)
         *         // 256 : 256bit 길이의 코드생성성
         *         // 홈페이지에서 수지 지현, 등 설정한 이름들을의 코드값을 봐보면
         *         // 출력순서가 어떻게 되었는지 알 수 있다. 왜 뒤죽박죽 나왔는지
        */






    }
}
