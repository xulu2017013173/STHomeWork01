//把Student类 ,StudentManagement保存，方便的调用。
package StudentJavaSE;
//通过 Scanner 类来获取用户的输入
import java.util.Scanner;
//创一个列表，用来存放其它java对象的，只要是java对象就可以往ArrayList里面放
import java.util.ArrayList;
//Collections类提供了一些操作集合的方法
import java.util.Collections;
//利用comparator能实现排序功能
import java.util.Comparator;
public class StudentAdmin {
    //主方法
    public static void main(String[] args) {
        // 创建集合对象，用于存储学生数据
        ArrayList<Student> list = new ArrayList<Student>();
        // 使用循环让程序回到此处
        while (true) {
            // 这是学生管理系统的主界面
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 按成绩降序查看所有学生");
            System.out.println("6 退出学生管理系统");
            System.out.println("请输入你的选择：");
            // 创建键盘录入对象Scanner
            Scanner sc = new Scanner(System.in);
            //snextLine()扫描此行输入所有字符串直到遇到回车为止
            String choiceString = sc.nextLine();
            // 用switch语句实现选择
            switch (choiceString) {
                case "1":
                    // 调用查看所有学生的函数
                    findAllStudent(list);
                    break;
                case "2":
                    // 添加学生
                    addStudent(list);
                    break;
                case "3":
                    // 删除学生
                    deleteStudent(list);
                    break;
                case "4":
                    // 修改学生
                    updateStudent(list);
                    break;
                case "5":
                    // 按照分数排序查询
                    orderByScore(list);
                    break;
                case "6":
                     //退出
                     System.out.println("谢谢你的使用");
                     break;

                default:
                    System.out.println("你乱按了键盘莫得这个功能");
//                    System.exit(0); // JVM退出
                    break;
            }
        }
    }
    /*
     * 修改学生的方法 修改学生的思路：键盘录入一个学号，到集合中去查找，看是否有学生使用的是该学号，如果有就修改该学生
     */
    public static void updateStudent(ArrayList<Student> list) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String id = sc.nextLine();
        // 定义一个索引
        int index = -1;
        // 遍历集合
        for (int x = 0; x < list.size(); x++) {
            // 获取每一个学生对象
            Student s = list.get(x);
            // 拿学生对象的学号和键盘录入的学号进行比较
            if (s.getId().equals(id)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("你要修改的学号对应的学生信息不存在,请回去重新你的选择");
        }
        else {
            System.out.println("请输入学生新姓名：");
            String name = sc.nextLine();
            System.out.println("请输入学生新成绩：");
            String score = sc.nextLine();
            // 创建学生对象
            Student s = new Student();
            s.setId(id);
            s.setName(name);
            s.setScore(score);
            // 修改集合中的学生对象
            list.set(index, s);
            // 给出提示
            System.out.println("修改学生成功");
        }
    }
    /*
     * 删除学生的方法 删除学生的思路：键盘录入一个学号，到集合中去查找，看是否有学生使用的是该学号，如果有就删除该学生
     */
    public static void deleteStudent(ArrayList<Student> list) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号：");
        String id = sc.nextLine();
        // 我们必须给出学号不存在的时候的提示
        // 定义一个索引
        int index = -1;
        // 遍历集合
        for (int x = 0; x < list.size(); x++) {
            // 获取到每一个学生对象
            Student s = list.get(x);
            // 拿这个学生对象的学号和键盘录入的学号进行比较
            if (s.getId().equals(id)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("不好意思,你要删除的学号对应的学生信息不存在,请回去重新你的选择");
        } else {
            list.remove(index);
            System.out.println("删除学生成功");
        }
    }
    // 添加学生的方法
    public static void addStudent(ArrayList<Student> list) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // 为了让id能够被访问到，我们就把id定义在了循环的外面
        String id;
        // 为了让代码能够回到这里，用循环
        while (true) {
            System.out.println("请输入学生学号：");
            // String id = sc.nextLine();
            id = sc.nextLine();
            // 判断学号有没有被人占用
            // 定义标记
            boolean flag = false;
            // 遍历集合，得到每一个学生
            for (int x = 0; x < list.size(); x++) {
                Student s = list.get(x);
                // 获取该学生的学号，和键盘录入的学号进行比较
                if (s.getId().equals(id)) {
                    flag = true; // 说明学号被占用了
                    break;
                }
            }
            if (flag) {
                System.out.println("你输入的学号已经被占用,请重新输入");
            }
            else {
                break; // 结束循环
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生成绩：");
        String score = sc.nextLine();
        // 创建学生对象
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setScore(score);
        // 把学生对象作为元素添加到集合
        list.add(s);
        // 给出提示
        System.out.println("添加学生成功");
    }
    // 查看所有学生
    public static void findAllStudent(ArrayList<Student> list)
    {
        // 首先来判断集合中是否有数据，如果没有数据，就给出提示，并让该方法不继续往下执行
        if (list.size() == 0) {
            System.out.println("不好意思,目前没有学生信息可供查询,请回去重新选择你的操作");
            return;
        }
        // \t 其实就是一个tab键的位置
        System.out.println("学号\t\t姓名\t成绩");
        for (int x = 0; x < list.size(); x++)
        {
            Student s = list.get(x);
            System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getScore() );
        }
    }
    // 根据分数排序
    private static void orderByScore(ArrayList<Student> list ) {
        if (list.size() <= 0) {
            System.out.println("数据库为空!!");
            return;
        }

        // 克隆副本进行排序，避免对原始数据更改
        ArrayList<Student> cList = (ArrayList<Student>) list.clone();

        // 排序按照分数
        Collections.sort(cList, new Comparator<Student>() {

            public int compare(Student s1, Student s2) {
                Double id1 = new Double(s1.getScore());
                Double id2 = new Double(s2.getScore());
                Integer result = id1 < id2 ? 1 : id1 > id2 ? -1 : 0;
                return result;
            }
        });

        // 打印输出分数
        System.out.println("学号\t\t姓名\t成绩");
        for (int i = 0; i < cList.size(); i++) {
            Student s = cList.get(i);
            System.out.println(s.getId() + "\t" + "\t" + s.getName() + "\t" + "\t" + s.getScore());
        }
    }}
