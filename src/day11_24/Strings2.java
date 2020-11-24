package day11_24;

/**
 * 문자열 처리시 유용한 기능을 제공하는 메서드
 */
public class Strings2 {
    public static void main(String[] args) {
        /**
         * 문자열 길이 : length
         */

        String str = "Hello, World~~~~";
        System.out.println( str.length() );

        /**
         * 문자열 검색
         * indexOf(문자) : 왼쪽 기준 지정한 문자 찾기, 위치값 출력 ( 0부터 시작 )
         * lastIndexOf(문자) : 오른쪽 기준 지정한 문자 찾기 , 위치값 출력 ( 0 부터 시작 )
         */

        System.out.println(str.indexOf('d'));

        System.out.println(str.lastIndexOf('d'));
        System.out.println("-----------------------");


        /**
         * 문자 바꾸기 : replace
         * replace( 찾을 문자열, 바꿀 문자열 )
         */
        str = "a*b*c*d";
        str = str.replace("*","-");
        System.out.println( str );


        /**
         * 문자열 분리 : split
         * 지정한 문자를 기준으로 문자열을 나눠 배열에 저장
         * split( 구분기호 )
         */

        str = "2020123,김태희,경기도,1985.3.22,컴퓨터,504";
        String [] result = str.split(",");

        //예전 for문
//        for( int i = 0; i < result.length ; i++){
//            System.out.println( result[i] );
//        }

        //향상된 for문
        for( String data : result ) {
            System.out.println( data );
        }
        System.out.println("---------------------");


        /**
         * 문자열 추출 : substring
         * substring( 시작위치, 끝위치-1 )
         */

        str = "Hello, World!!";
        //System.out.println( str.substring(0,2) );

        /**
         * 문자열 추출을 이용해서 주민등록번호에서 성별체크하는 코드작성
         * ex) 123456-123456 , 987654-3212311
         * 1,2 : 2000년 이전 남여 구분
         * 3,4 : 2000년 이후 남여 구분
         */

        str = "960506-1234567";
        String substring;
        String sex="";
        //생년월일
        String year=str.substring(0,2);
        String month=str.substring(2,4);
        String day=str.substring(4,6);
        substring=str.substring(7,8);

        switch (substring){
            case "1" : sex= "남자";break;
            case "2" : sex= "여자";break;
            case "3" : sex= "남자";break;
            case "4" : sex= "여자";break;
        }
        System.out.printf("%s년 %s월 %s일생 %s입니다.",year,month,day,sex);


        /**
         * 문자 하나 뽑는데 위와같이 코드를 짜면 낭비다 그럴때는 다른방법을 사용
         * 지정한 위치의 문자추출 : charAt
         */
        str = "123456-1234567";
        System.out.println( str.charAt(7) ); // 문자를 뽑아낼 위치 입력 (0부터 시작)
        System.out.println("-------------------");


        /**
         * 정규표현식에 따라 일치여부 확인 : matches
         * 정규식 사용가능한 메서드 : split replaceAll
         */
        int num = 12345678;
        String str1 = String.format("%d",num);
        String str2 = "12345678";
        System.out.println( str1.matches( str2 ));
        System.out.println( str1.matches( "[a-z].+" )); //a~z까지 한번이상 반복이 이루어 져있나 true or false
        System.out.println( str1.matches( "[0-9].+")); //0~9까지 한번이상 반복이 이루어 져있나 true or false
        System.out.println("----------------------------------");


        /**
         * 정규 표현식 regular expression
         * 특정한 규칙을 가진 문자열의 집합을 표현하기
         * 위해 사용하는 형식언어
         * [] : 문자집합이나 표현, -는 두문자 사이의 범위를 나타냄
         * [0-9] : 숫자집합 ([0123456789])
         * [a-zA-Z] : 영문자집합
         * [가-힣] : 한글 집합
         *
         * * : 0개 이상 무한개의 임의의 문자 반복
         * ab* : ab abababba ababa ababsdfsdf   // ab가 한번나오고 그 다음은 무엇이 나와도 ok
         *
         * + : 1개이상 무한개의 임의의 문자 반복
         * ab+ : abs abc abd abc  // ab가 한번 나오고 그 다음은 1개이상 무엇이 나와도 ok
         *
         * ? : 0개 또는 1개의 임의의 문자 반복
         * ab? : ab ab1 ab2 abc   // ab가 한번 나오고 그 다음은 0개또는 1개의 문자 아무거나 나와도 ok
         *
         * {n,m} : 최소 n개이상 m개 이하 반복
         * [0-9]{3,4} : 0123 , 123, 552    //0~9까지 3개이상 4개이하 아무거나  ㄱㄱ
         *
         * ^ : 문자열 시작
         * ^123 : 123으로 시작하는 문자열 의미
         *
         * $ : 문자열 끝
         * 123$ : 123으로 끝나는 문자열 의미
         *
         * . : 임의의 문자를 의미
         * .{3, } : 문자의 최소 길이는 3임
         */


        /**
         * 다음 문자열이 전화번호형식에 맞게 작성되었는지
         * 알아보는 정규식을 작성하세요
         * 010-123-1234
         */

        String phone = "010-123-1234";
        String pattern1 = "[0-9]{3}-[0-9]{3}-[0-9]{4}";  //0~9까지 3자리 인지 x2 0~9까지 4자리인지
        System.out.println(phone.matches(pattern1));
        System.out.println("-------------------------");

        /**
         * ex) 사용자 아이디가 다음 규칙에 적합하게 작성되었는지 확인
         * 영문자 소문자/대문자 숫자 특수기호 등으로
         * abc123!XYZ
         */
        String uid = "abc123!XYZ";
        String pattern2 = "[a-zA-Z0-9!@#!@#]+";  // a~z , A~Z, 0~9, !@#!@# 특수기호가 1개이상씩 반복되어쓴지
        System.out.println(uid.matches(pattern2));
        /**
         *  첫글자는 영문자 소문자/대문자
         *  두번째문자는 숫자, 특수기호() 등이 포함
         *  최소 길이는 6자~18자
         *
         */
        uid = "A123123123123!@";
        String pattern3 = "[a-zA-Z]{1}[0-9!@#!@#!@]{5,17}";
        System.out.println(uid.matches(pattern3));










    }
}
