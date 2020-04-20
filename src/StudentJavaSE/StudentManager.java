package StudentJavaSE;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class StudentManager {
    public static void App() {
        ArrayList<Student> list = new ArrayList<Student>();
        while (true) {
            System.out.println("**��ѡ�������*************");
            System.out.println("*       1 ����                   *");
            System.out.println("*       2 ����                   *");
            System.out.println("*       3 ɾ��                   *");
            System.out.println("*       4 �޸�                   *");
            System.out.println("*       5 ���                   *");
            System.out.println("*       6 �˳�                   *");
            System.out.println("************************");
            Scanner sc = new Scanner(System.in);
            String choiceString = sc.nextLine();
            switch (choiceString) {
                case "1":
                    // ����
                    addStudent(list);
                    break;
                case "2":
                	//����
                	searchStudent(list);
                	break;
                case "3":
                    // ɾ��
                    deleteStudent(list);
                    break;
                case "4":
                    // �޸�
                    updateStudent(list);
                    break;
                case "5":
                    // ���
                    orderByScore(list);
                    break;
                case "6":
                     //�˳�
                     System.out.println("�˳��ɹ���");
                     break;

                default:
                    System.out.println("������������������");
                    break;
            }
        }
    }

    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ�޸ĵ�������");
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
            System.out.println("��Ҫ�޸�ѧ����Ϣ������,����ѡ");
        }
        else {
            System.out.println("�������޸ĵ�ѧ�ţ�");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("�������޸ĵĳ������ڣ�");
            String birDate = sc.nextLine();
            System.out.println("�������޸ĵ��Ա�");
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
            System.out.println("�޸ĳɹ�");
        }
    }

    public static void searchStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ���ҵ�ѧ����������");
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
            System.out.println("��Ҫ����ѧ����Ϣ������,����ѡ");
        }
    }
    
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫɾ����ѧ����������");
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
            System.out.println("������˼,��Ҫɾ��ѧ����Ϣ������,����ѡ");
        } else {
            list.remove(index);
            System.out.println("ɾ��ѧ���ɹ�");
        }
    }

    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("������ѧ��������");
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
                System.out.println("������������Ѿ���ռ��,����������");
            }
            else {
                break;
            }
        }
        System.out.println("������ѧ��ѧ�ţ�");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("������ѧ���������ڣ�");
        String birDate = sc.nextLine();
        System.out.println("������ѧ���Ա�");
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
        System.out.println("���ѧ���ɹ�");
    }

    private static void orderByScore(ArrayList<Student> list ) {
        if (list.size() <= 0) {
            System.out.println("����Ϣ����");
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

        System.out.println("ѧ��\t\t����\t\t��������\t\t�Ա�");
        for (int i = 0; i < cList.size(); i++) {
            Student s = cList.get(i);
            System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getBirDate() + "\t" +"\t"+ s.getGender() );
        }
    }}