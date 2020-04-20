//��Student�� ,StudentManagement���棬����ĵ��á�
package StudentJavaSE;
//ͨ�� Scanner ������ȡ�û�������
import java.util.Scanner;
//��һ���б������������java����ģ�ֻҪ��java����Ϳ�����ArrayList�����
import java.util.ArrayList;
//Collections���ṩ��һЩ�������ϵķ���
import java.util.Collections;
//����comparator��ʵ��������
import java.util.Comparator;
public class StudentAdmin {
    //������
    public static void main(String[] args) {
        // �������϶������ڴ洢ѧ������
        ArrayList<Student> list = new ArrayList<Student>();
        // ʹ��ѭ���ó���ص��˴�
        while (true) {
            // ����ѧ������ϵͳ��������
            System.out.println("--------��ӭ����ѧ������ϵͳ--------");
            System.out.println("1 �鿴����ѧ��");
            System.out.println("2 ���ѧ��");
            System.out.println("3 ɾ��ѧ��");
            System.out.println("4 �޸�ѧ��");
            System.out.println("5 ���ɼ�����鿴����ѧ��");
            System.out.println("6 �˳�ѧ������ϵͳ");
            System.out.println("���������ѡ��");
            // ��������¼�����Scanner
            Scanner sc = new Scanner(System.in);
            //snextLine()ɨ��������������ַ���ֱ�������س�Ϊֹ
            String choiceString = sc.nextLine();
            // ��switch���ʵ��ѡ��
            switch (choiceString) {
                case "1":
                    // ���ò鿴����ѧ���ĺ���
                    findAllStudent(list);
                    break;
                case "2":
                    // ���ѧ��
                    addStudent(list);
                    break;
                case "3":
                    // ɾ��ѧ��
                    deleteStudent(list);
                    break;
                case "4":
                    // �޸�ѧ��
                    updateStudent(list);
                    break;
                case "5":
                    // ���շ��������ѯ
                    orderByScore(list);
                    break;
                case "6":
                     //�˳�
                     System.out.println("лл���ʹ��");
                     break;

                default:
                    System.out.println("���Ұ��˼���Ī���������");
//                    System.exit(0); // JVM�˳�
                    break;
            }
        }
    }
    /*
     * �޸�ѧ���ķ��� �޸�ѧ����˼·������¼��һ��ѧ�ţ���������ȥ���ң����Ƿ���ѧ��ʹ�õ��Ǹ�ѧ�ţ�����о��޸ĸ�ѧ��
     */
    public static void updateStudent(ArrayList<Student> list) {
        // ��������¼�����
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ�޸ĵ�ѧ����ѧ�ţ�");
        String id = sc.nextLine();
        // ����һ������
        int index = -1;
        // ��������
        for (int x = 0; x < list.size(); x++) {
            // ��ȡÿһ��ѧ������
            Student s = list.get(x);
            // ��ѧ�������ѧ�źͼ���¼���ѧ�Ž��бȽ�
            if (s.getId().equals(id)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("��Ҫ�޸ĵ�ѧ�Ŷ�Ӧ��ѧ����Ϣ������,���ȥ�������ѡ��");
        }
        else {
            System.out.println("������ѧ����������");
            String name = sc.nextLine();
            System.out.println("������ѧ���³ɼ���");
            String score = sc.nextLine();
            // ����ѧ������
            Student s = new Student();
            s.setId(id);
            s.setName(name);
            s.setScore(score);
            // �޸ļ����е�ѧ������
            list.set(index, s);
            // ������ʾ
            System.out.println("�޸�ѧ���ɹ�");
        }
    }
    /*
     * ɾ��ѧ���ķ��� ɾ��ѧ����˼·������¼��һ��ѧ�ţ���������ȥ���ң����Ƿ���ѧ��ʹ�õ��Ǹ�ѧ�ţ�����о�ɾ����ѧ��
     */
    public static void deleteStudent(ArrayList<Student> list) {
        // ��������¼�����
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
        String id = sc.nextLine();
        // ���Ǳ������ѧ�Ų����ڵ�ʱ�����ʾ
        // ����һ������
        int index = -1;
        // ��������
        for (int x = 0; x < list.size(); x++) {
            // ��ȡ��ÿһ��ѧ������
            Student s = list.get(x);
            // �����ѧ�������ѧ�źͼ���¼���ѧ�Ž��бȽ�
            if (s.getId().equals(id)) {
                index = x;
                break;
            }
        }
        if (index == -1) {
            System.out.println("������˼,��Ҫɾ����ѧ�Ŷ�Ӧ��ѧ����Ϣ������,���ȥ�������ѡ��");
        } else {
            list.remove(index);
            System.out.println("ɾ��ѧ���ɹ�");
        }
    }
    // ���ѧ���ķ���
    public static void addStudent(ArrayList<Student> list) {
        // ��������¼�����
        Scanner sc = new Scanner(System.in);
        // Ϊ����id�ܹ������ʵ������ǾͰ�id��������ѭ��������
        String id;
        // Ϊ���ô����ܹ��ص������ѭ��
        while (true) {
            System.out.println("������ѧ��ѧ�ţ�");
            // String id = sc.nextLine();
            id = sc.nextLine();
            // �ж�ѧ����û�б���ռ��
            // ������
            boolean flag = false;
            // �������ϣ��õ�ÿһ��ѧ��
            for (int x = 0; x < list.size(); x++) {
                Student s = list.get(x);
                // ��ȡ��ѧ����ѧ�ţ��ͼ���¼���ѧ�Ž��бȽ�
                if (s.getId().equals(id)) {
                    flag = true; // ˵��ѧ�ű�ռ����
                    break;
                }
            }
            if (flag) {
                System.out.println("�������ѧ���Ѿ���ռ��,����������");
            }
            else {
                break; // ����ѭ��
            }
        }
        System.out.println("������ѧ��������");
        String name = sc.nextLine();
        System.out.println("������ѧ���ɼ���");
        String score = sc.nextLine();
        // ����ѧ������
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setScore(score);
        // ��ѧ��������ΪԪ����ӵ�����
        list.add(s);
        // ������ʾ
        System.out.println("���ѧ���ɹ�");
    }
    // �鿴����ѧ��
    public static void findAllStudent(ArrayList<Student> list)
    {
        // �������жϼ������Ƿ������ݣ����û�����ݣ��͸�����ʾ�����ø÷�������������ִ��
        if (list.size() == 0) {
            System.out.println("������˼,Ŀǰû��ѧ����Ϣ�ɹ���ѯ,���ȥ����ѡ����Ĳ���");
            return;
        }
        // \t ��ʵ����һ��tab����λ��
        System.out.println("ѧ��\t\t����\t�ɼ�");
        for (int x = 0; x < list.size(); x++)
        {
            Student s = list.get(x);
            System.out.println(s.getId() + "\t"+ "\t"+s.getName() + "\t" +"\t"+ s.getScore() );
        }
    }
    // ���ݷ�������
    private static void orderByScore(ArrayList<Student> list ) {
        if (list.size() <= 0) {
            System.out.println("���ݿ�Ϊ��!!");
            return;
        }

        // ��¡�����������򣬱����ԭʼ���ݸ���
        ArrayList<Student> cList = (ArrayList<Student>) list.clone();

        // �����շ���
        Collections.sort(cList, new Comparator<Student>() {

            public int compare(Student s1, Student s2) {
                Double id1 = new Double(s1.getScore());
                Double id2 = new Double(s2.getScore());
                Integer result = id1 < id2 ? 1 : id1 > id2 ? -1 : 0;
                return result;
            }
        });

        // ��ӡ�������
        System.out.println("ѧ��\t\t����\t�ɼ�");
        for (int i = 0; i < cList.size(); i++) {
            Student s = cList.get(i);
            System.out.println(s.getId() + "\t" + "\t" + s.getName() + "\t" + "\t" + s.getScore());
        }
    }}
