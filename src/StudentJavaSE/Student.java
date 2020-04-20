package StudentJavaSE;
public class Student {
    // 学号
    private String id;
    // 姓名
    private String name;
    // 分数
    private String score;
    public Student() {
    }
    public Student(String id, String name, String score)
    {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
}
