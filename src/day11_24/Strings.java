package day11_24;

/**
 * String 클래스
 * C언어에서는 문자열은 char형 배열로 표현
 * 자바에서는 문자열처리를 위한 별도의 String 클래스 제공
 *
 * String클래스의 객체는 한번 생성되면
 * 그 값을 읽기만 가능하고 변경할 수 없는 불변객체임
 * 따라서, +연산자로 문자열을 결합하는 경우
 * 기존의 문자열이 변경되는 것이 아니고
 * 각각의 내용을 합쳐 새로운 객체를 생성함
 */
public class Strings {
    public static void main(String[] args) {
        String str1="Hello";
        String str2="World";

        str1 = str1 + str2;
        System.out.println(str1);
        str1 = str1 + "Wow~";
        System.out.println(str1);

        /**
         *  '+'연산자 사용시 위에서 설명했듯
         *  내용이 합쳐지는 것이 아닌 연결해서 새로운 객체를 생성하기 때문에
         *  기존에 연결을 받는 객체들이 존재한상태에서 생성됨
         *  그래서 메모리 낭비가 심함 이럴때
         *  StringBuffer 메서드 or StringBuilder 메서드를 사용하는것을 추천한다.
         */

        StringBuffer sb = new StringBuffer();
        sb.append("Hello").append("World").append("Wow~");
        System.out.println(sb);

        /**
         * 문자열 간 비교
         * 문자열 상수 풀이라는 개념 이해 필요
         * a 객체 생성 => "Hello"를 StringConstantPool(SCP)상수풀 에 저장
         * b 객체 생성 => SCP에 이미 같은 내용인 "Hello" 가 존재하므로 같은 값을 참조 하도록 함.
         * c 객체 생성 => scp가 아닌 전혀 새로운 위치에 "Hello"를 생성
         */
        String a="Hello";
        String b="Hello";
        String c=new String("Hello");

        /**
         * String a 와 String b는 같을까 또한 a와 c도 같을까 ?
         * 라는 물음에 문자열간 비교 하기위해서 '==' 연산자를 사용할법한데
         * 사용하면 안된다. 문자열간 '==' 연산자를 사용하면 문자열의 값과의 비교가아닌
         * 문자열의 값이 저장되어있는 위치들로 서로 비교를 하기때문에 정확한 비교가 어렵다.
         * 문자열의 값을 비교하려면 'eqauls' 메서드를 사용해서 비교해야한다.
         */
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c); //문자열의 값 저장 위치를 비교

        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.equals(c)); // 문자열의 값이 같다면 'true'를 다르다면 'false'가 출력된다.
    }

}
