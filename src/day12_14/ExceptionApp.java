package day12_14;

public class ExceptionApp {
//1
    // 자바에서는 0을 나눌수 없다 그래서 오류가 뜬다.
// 허나 어떤 프로그램은 24시간 돌아가야한다면
// 이런 오류를 만나 프로그램이 작동이 안하면 난감할 것이다.
// 이럴때 예외처리를 통해 오류가 발생하여도 그다음 프로그램이 작동하게
// 하는 것도 예외처리의 한 방법이 될 수 있다

//2
// 아래를 보면 알수있듯이 2를0으로 나누면 자바에서는 오류가 나오는데(ArithmeticException)
    // 이럴때 예외처리인 try /catch문으로 감싸면 오류를 예외처리로 처리하고
    // catch문을 작성할때 오류에 맞는 예외처리를 넣는것이 좋다. 그리고
    // 안에 있는 코드를 실행후 그다음 코드가 실행되는 것을 볼 수 있다.

    //3
    // 하나의 try문의 예외처리할 문장을 여러개 넣는다면
    // 첫번째 예외처리문을 만났을때 catch문을 실행후
    // 바로 try/catch문을 빠져나간다. 그 다음 예외처리할 문장이
    // 실행조차 안되는 것 같다.



    public static void main(String[] args) {
        //1
        System.out.println(1);
        try {
            System.out.println(2 / 0);  // ArithmeticException
        }catch(ArithmeticException e){
            System.out.println("잘못된 계산이네요");
        }
        System.out.println(3);
        System.out.println(4);


        //2
        int [] scores = {10,20,30};    // 배열의 저장범위 바깥 데이터를 가져오려 할 때
        try {
            System.out.println(scores[3]); // ArrayIndexOutOfBoundsException
        }catch(ArrayIndexOutOfBoundsException aiob){
            System.out.println("없는 값을 찾고 계시네요~ ^^");
        }

        //3
        try {
            System.out.println(10);
            System.out.println(2 / 0);
            int[] scores2 = {10, 20, 30};
        }catch(ArithmeticException e2){
            System.out.println("헛짓거리하시네 ~");
        }catch(ArrayIndexOutOfBoundsException ad){
            System.out.println("그러게말여~");
        }
        System.out.println(15);


    }
}
