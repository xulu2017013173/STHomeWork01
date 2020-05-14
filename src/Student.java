
public class Student {
    private int ID; //学号
    private String name; //姓名
    private String birDate; //出生日期
    private boolean gender; //性别
/*public Student() {
}*/
public Student() {} //代码修改检查项：Ⅲ.(16)多余折行
    public Student(int ID, String name, String birDate, boolean gender)
    {
        this.ID = ID;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }
    public int getId() {
        return ID;
    }
    public void setId(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirDate() {
        return birDate;
    }
    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }
    public boolean getGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
