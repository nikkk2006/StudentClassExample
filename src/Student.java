public class Student {

    private String name;
    private int age;
    private int grade;

    public void Student(String name, int age, int grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() {return age; }
    public int getGrade() { return grade; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {this.age = age; }
    public void setGrade(int grade) { this.grade = grade; }
}
