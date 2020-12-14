package day12_14;

import java.io.FileWriter;
import java.io.IOException;

public class Finally_and_Resource {
    // finally 와 resource
    // 자바가 외부 프로그램에 엑세스 할때 생길수 있는 예외처리
    // 대표적인 외부프로그램(리소스)으로는 파일, 네트워크, 데이터베이스가 있다.
    // 다시, 리소스는 자바 내부의 데이터가 아니기에 예외처리가 많이 발생할 수 있다.
    // 자바에서 리소스를 사용할때 자바는 리소스를 붙잡는 모종의 행위(?) 들이 있는데
    // 파일은 나만 파일을 쓰겠어 .. ? 네트워크는 커넥션.. ? 아무튼 붙잡는 작업을 다하고
    // 나면 리소스를 놔줘야하는데 놔주는 코드가 close() 이다.
    // close()를 써주기 위해서는 다소 복잡한 과정이 있다.


    // 일차적으로 아래에서 filewriter를 쓸때 예외가 발생할 수 있어 try/catch문으로 감싸고
    // try문에 close를 쓴다면 try문에서의 예외처리가 발생한다면 close는 실행이 되지 않는다.
    // 그렇기에 필요한것은 finally문안에다 close를 써주는 것인데 finally 문은 예외처리가 발생하건 안하건
    // 무조건 finally문 안에 있는 내용을 실행시켜주는 것인데 그렇기에 finally 문안에 넣으면 빨간밑줄이 기다리고 있을터인데
    // finally를 열고 close문을 쓰면 close가 try문안에서의 지역변수를 받을 수 없어 try문 밖에서 전역변수로 선언을 해야 오류가
    // 안나온다. 그렇게 밖에다 또 선언하고 나면 또 빨간줄이 나오는 것을 확인할 수있는데 ~ 이번에는 또 finally 안에서 close를
    // 실행하는데 있어서도 예외처리가 나올 수 있다는 것이다. 말은 그렇다 . 그래서 finally 안에서 또 예외처리를 해주어야 한다.
    // finally 문 안에서도 예외처리를 또 해주면 비로소 빨간 밑줄을 안보게 될 수 있는데 이와 같은 방법은 너무 복잡하고 장황하다 .
    // 이와 같은 방법을 해결하기 위해 try-with-resource 라는 신기술이 있다고 한다.

    // try-with-resource
    // java7 부터 추가함
    // 위에서 봤듯이 위의 방법은 코드가 매우 장황해진다.
    // 간단히 쓰는 방법을 사용하면
    // 일단 try (close가 필요한 코드) {} catch{} 문
    // 이런식으로 써놓으면 알아서 실행후 예외가 발생하건 안하건 마지막에 close를 실행해준다.
    // 확연히 위와 간단해진 코드를 확인할 수 있다 .


    public static void main(String[] args) {
        FileWriter fw=null;
        try {
             fw = new FileWriter("data2.dat");
            fw.write("hello");
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            // 만약에 fw가 null이 아니라면 close를 해라 ~
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        // try-with-resource
        // try with resource statements
        try (FileWriter f = new FileWriter("data.txt")){  // try 괄호 안에다가 close가 필요한클래스를 인스턴스하는 코드 입력
            f.write("HELLO");
            }catch(IOException e){
                e.printStackTrace();
        }




    }
}
