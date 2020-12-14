package day12_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CheckedExceptionApp {
    // IOException 을 발생시키는 코드를 발생해 보겠다
    // Checked exception vs unchecked exception
    // 전자의 경우 대표적으로 IOException이 있다.
    // 전자의 경우 컴파일러에서 직접 예외처리를 했는지 검사하기 때문에
    // 반드시 코드에서 예외 처리를 해주어야 한다.

    // 후자의 경우
    // 앞선 'Exception' 클래스에서 볼 수 있었던
    // ArrayIndexOutOfBoundsException 나 ArithmeticException 와 같은 경우로
    // 이와같은 예외처리는 따로 안해도 실행이 가능하지만
    // 실행후 오류메세지가 나온는 것을 확인할 수 있다.

    // 결과적으로 전자인 checked exception 같은 경우는 예외처리를 코드에서 무조건 해주어야하고
    // 후자인 unchecked exception 은 코드 안에서 예외처리를 꼭 안해도 된다는 것
    // 또한 이 두가지로 예외처리가 나뉜다는 정도를 알면 좋을 것 같다고 한다 생활코딩 따거께서

    public static void main(String[] args) {

        try {
            FileWriter f = null;
            f = new FileWriter("data.txt");
            f.write("hello");
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
