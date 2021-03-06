import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentReadAndWrite studentReadAndWrite;

    public StudentManager() {
        studentReadAndWrite = new StudentReadAndWrite();
        studentList = studentReadAndWrite.read();
    }

    public void add() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("student id + " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        int gpa = inputGpa();
        Student student = new Student(id, name, age, address, gpa);
        studentList.add(student);
        studentReadAndWrite.write(studentList);
    }

    public void edit(int id) {
        boolean isExited = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExited = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setGpa(inputGpa());
                break;
            }
        }
        if (!isExited) {
            System.out.printf("id = %d not existed .\n", id);
        } else {
            studentReadAndWrite.write(studentList);
        }
    }

    public void delete(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if(student !=null) {
            studentList.remove(student);
            studentReadAndWrite.write(studentList);
        }else {
            System.out.printf("id = %id ntn existed.\n", id);
       }
    }
       public void sortStudentByGPA(){
           Collections.sort(studentList, new SortStudentByGPA());
       }
       public void sortStudentByName(){
        Collections.sort(studentList, new SortStudentByName());
       }
public void show(){
    for (Student student:studentList) {
        System.out.println("========Danh s??ch h???c sinh=============");
        System.out.println();
        System.out.format("%3d | ", student.getId());
        System.out.format("%10s | ", student.getName());
        System.out.format("%3d | ", student.getAge());
        System.out.format("%10s | ", student.getAddress());
        System.out.format("%5d | ", student.getGpa());
        System.out.println();
    }
}
public int inputId() {
    System.out.print("nh???p id : ");
    while (true){
        try {
            int id = Integer.parseInt(scanner.nextLine());
            return id ;
        }catch (NumberFormatException ex){
            System.out.print("kh??ng h???p l???! Nh???p ID sinh v??o m???t l???n n???a:");
        }
    }
}
    private int inputGpa() {
        System.out.print("Nh???p ??i???m s??? trung b??nh  :");
        while (true){
            try {
                Integer gpa = Integer.parseInt((scanner.nextLine()));
                if (gpa < 0 && gpa >  10){
                    throw new NumberFormatException();
                }
                return gpa;
            }catch (NumberFormatException ex){
                System.out.print("Kh??ng h???p l??? ! Vui l??ng nh???p l???i ??i???m");
            }
        }
    }

    private String inputAddress() {
        System.out.print("Nh???p ?????a ch??? :");
        return scanner.nextLine();
    }

    private byte inputAge() {
        System.out.print("Nh???p tu???i : ");
        while (true){
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age  >100){
                    throw new NumberFormatException();
                }
                return age ;
            }catch (NumberFormatException ex){
                System.out.print ("kh??ng h???p l???! Nh???p ID sinh v??o m???t l???n n???a:");
            }
        }
    }

    private String inputName() {
        System.out.print("Nh???p t??n h???c sinh : ");
        return scanner.nextLine();
    }
    public List<Student> getStudentList(){
        return studentList;
    }
    private void setStudentList(List<Student> studentList){
        this.studentList = studentList;

    }
}

