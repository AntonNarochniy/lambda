package kg.megacom;

import java.util.ArrayList;

public class Student {
    String name;
    char sex;
    int age;
    int course;
    double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;

    }

    public Student() {
    }
}

class StudentInfo {
 void printStudentInfo(Student st) {
        System.out.println("Имя студента: " + st.name + ", пол: " + st.sex + ", возраст: " + st.age + ", курс: " + st.course + ", средняя оценка: " + st.avgGrade);
    }

void testStudents (ArrayList<Student> students, StudentCheck sc ){
        for (Student s: students){
            if (sc.test(s)){
                printStudentInfo(s);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Ivan", 'm', 22, 3, 8.3));
        list.add(new Student("Nikolay", 'm', 28, 2, 6.4));
        list.add(new Student("Elena", 'f', 19, 1, 8.9));
        list.add(new Student("Petr", 'м', 35, 4, 4.7));
        list.add(new Student("Mariya", 'f', 25, 3, 9.1));
        StudentInfo si = new StudentInfo();

        si.testStudents(list, (Student st) -> {return st.avgGrade > 8.5;});
        System.out.println("--------------------------------------------");
        si.testStudents(list, st -> st.avgGrade < 8);
        System.out.println("--------------------------------------------");
        si.testStudents(list, (Student st) -> st.age < 20);
        System.out.println("--------------------------------------------");
        si.testStudents(list, st -> {return st.age < 20;});
        System.out.println("--------------------------------------------");
        si.testStudents(list, st -> st.sex == 'm');
        System.out.println("--------------------------------------------");
        si.testStudents(list, st ->  {return st.age > 19 && st.sex == 'm' && st.avgGrade > 7;} );


    }

}

@FunctionalInterface
interface StudentCheck{
    boolean test (Student student);
}


