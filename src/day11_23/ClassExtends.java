package day11_23;
// 상속(확장)
// 객체지향 3대 개념 중 하나
// 기존 클래스에 기능을 추가하거나 재정의해서
// 새로운 클래스를 만드는 것.

// 상속을 이용하면 기존의 정의되어 있는
// 클래스의 모든 필드와 메서드를 물려받음.
// 기존클래스를 부모/상위/슈퍼 클래스라 하고
// 새롭게 작성된 클래스를 자식/하위/서브 클래스라 함.



// 상속의 장점
// 기존 작성된 클래스 재활용
// 클래스의 계층적 구조파악 용이
// 소프트웨어 생산성 향상
public class ClassExtends {
    public static void main(String[] args) {
        Student st=new Student();
        StudentWorker sw=new StudentWorker();
        Researcher rs=new Researcher();
        Professeors ps=new Professeors();

        System.out.println(st.study());
        System.out.println(sw.work());
        System.out.println(rs.research());
        System.out.println(ps.teach());
    }
}

class Persons{
    protected String name;
    public Persons() {
    }

    public Persons(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String say(){return "나는 말하는중...";}
    public String eat(){return "나느 먹는중...";}
    public String walk(){return "나는 걷는중...";}
    public String sleep(){return "나는 자는중...";}
}

class Student extends Persons {
    public String study(){return "나는 공부중...";};
}
class StudentWorker extends Student {
    public String work(){return "나는 일하는중...";};
}
class Researcher extends Persons{
    public String research(){return "나는 연구중...";};
}
class Professeors extends Persons{
    public String teach(){return "나는 강의중...";};
}
