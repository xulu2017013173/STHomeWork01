package StudentJavaSE;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class StudentManager {
    public static void App() {
        ArrayList<Student> list = new ArrayList<Student>();
        while (true) {
            System.out.println("**请选择操作：*************");
            System.out.println("*       1 插入                   *");
            System.out.println("*       2 查找                   *");
            System.out.println("*       3 删除                   *");
            System.out.println("*       4 修改                   *");
            System.out.println("*       5 输出                   *");
            System.out.println("*       6 退出                   *");
            System.out.println("************************");
            Scanner sc = new Scanner(System.in);
            String choiceString = sc.nextLine();
            switch (choiceString) {
                case "1":
                    // 插入
                    addStudent(list);
                    break;
                case "2":
                	//查找
                	searchStudent(list);
                	break;
                case "3":
                    // 删除
                    deleteStudent(list);
                    break;
                case "4":
                    // 修改
                    updateStudent(list);
                    break;
                case "5":
                    // 输出
                    orderByScore(list);
                    break;
                case "6":
                     //退出
                     System.out.println("退出成功！");
                     break;

                default:
                    System.out.println("按键错误，请重新输入");
                    break;
            }
        }
    }

    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的姓名：");
        String name = sc.nextLine();
        int index = -1;
        for (int x = 0; x < list.size(); x++) {
            Student s = list.get(x);
            if (s.getName().equals(name)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("你要修改学生信息不存在,请重选");
        }
        else {
            System.out.println("请输入修改的学号：");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("请输入修改的出生日期：");
            String birDate = sc.nextLine();
            System.out.println("请输入修改的性别：");
            String input_gender = sc.nextLine();
            boolean gender = false;
            if(input_gender.equals("true"))
            	gender = true;
            if(input_gender.equals("false"))
            	gender = false;
            Student s = new Student();
            s.setName(name);
            s.setId(id);
            s.setBirDate(birDate);
            s.setGender(gender);
            list.set(index, s);
            System.out.println("修改成功");
        }
    }

    public static void searchStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的学生的姓名：");
        String name = sc.nextLine();
        int index = -1;
        for (int x = 0; x < list.size(); x++) {
            Student s = list.get(x);
            if (s.getName().equals(name)) {
                index = x;
                System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getBirDate() + "\t" +"\t"+ s.getGender() );
                break;
            }
        }
        if (index == -1) {
            System.out.println("你要查找学生信息不存在,请重选");
        }
    }
    
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的姓名：");
        String name = sc.nextLine();
        int index = -1;
        for (int x = 0; x < list.size(); x++) {
            Student s = list.get(x);
            if (s.getName().equals(name)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("不好意思,你要删除学生信息不存在,请重选");
        } else {
            list.remove(index);
            System.out.println("删除学生成功");
        }
    }

    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("请输入学生姓名：");
            name = sc.nextLine();

            boolean flag = false;
            for (int x = 0; x < list.size(); x++) {
                Student s = list.get(x);
                if (s.getName().equals(name)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("你输入的姓名已经被占用,请重新输入");
            }
            else {
                break;
            }
        }
        System.out.println("请输入学生学号：");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("请输入学生出生日期：");
        String birDate = sc.nextLine();
        System.out.println("请输入学生性别：");
        String input_gender = sc.nextLine();
        boolean gender = false;
        if(input_gender.equals("true"))
        	gender = true;
        if(input_gender.equals("false"))
        	gender = false;
        Student s = new Student();
        s.setName(name);
        s.setId(id);
        s.setBirDate(birDate);
        s.setGender(gender);
        list.add(s);
        System.out.println("添加学生成功");
    }

    private static void orderByScore(ArrayList<Student> list ) {
        if (list.size() <= 0) {
            System.out.println("无信息存在");
            return;
        }

        ArrayList<Student> cList = (ArrayList<Student>) list.clone();

        Collections.sort(cList, new Comparator<Student>() {

            public int compare(Student s1, Student s2) {
                Double id1 = new Double(s1.getId());
                Double id2 = new Double(s2.getId());
                Integer result = id1 < id2 ? 1 : id1 < id2 ? -1 : 0;
                return result;
            }
        });

        System.out.println("学号\t\t姓名\t\t出生日期\t\t性别");
        for (int i = 0; i < cList.size(); i++) {
            Student s = cList.get(i);
            System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getBirDate() + "\t" +"\t"+ s.getGender() );
        }
    }}