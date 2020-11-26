package day11_26;

public class EmployeeVO {
    private int epNum;
    private String epName;
    private String startDay;
    private String job;
    private String salary;
    private String phone;


    public EmployeeVO() {
    }

    public EmployeeVO(int epNum, String epName, String startDay, String job, String salary, String phone) {
        this.epNum = epNum;
        this.epName = epName;
        this.startDay = startDay;
        this.job = job;
        this.salary = salary;
        this.phone = phone;
    }

    public int getEpNum() {
        return epNum;
    }

    public void setEpNum(int epNum) {
        this.epNum = epNum;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
