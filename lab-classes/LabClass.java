import java.util.*;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * 
 * @author Michael Kolling and David Barnes
 * @version 2008.03.30
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    private List<Student> students;
    private int capacity;
    
    /**
     * Create a LabClass with a maximum number of enrolments. All other details
     * are set to default values.
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "unknown";
        room = "unknown";
        timeAndDay = "unknown";
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }
    

    /**
     * Add a student to this LabClass.
     */
    public void enrollStudent(Student newStudent, int studentCredits)
    {
        if(students.size() == capacity) {
            System.out.println("The class is full, you cannot enrol.");
        }
        else {
            newStudent.addCredits(studentCredits);
            students.add(newStudent);
        }
    }
    
    /**
     * Return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents()
    {
        return students.size();
    }
    
    /**
     * Set the room number for this LabClass.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }
    
    /**
     * Set the time for this LabClass. The parameter should define the day
     * and the time of day, such as "Friday, 10am".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }
    
    /**
     * Set the name of the instructor for this LabClass.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }
    
    /**
     * Print out a class list with other LabClass details to the standard
     * terminal.
     */
    public void printList()
    {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor + "   room: " + room);
        System.out.println("Class list:");
        for(Student student : students) {
            student.print();
        }
        System.out.println("Number of students: " + numberOfStudents());
    }
    
    public void autoLab() {
        capacity = 5;
        setInstructor("Simon Smith");
        setRoom("AB123");
        setTime("Monday, 11am");
        Student s1 = new Student("Charlie", "qwer");
        Student s2 = new Student("Sophie", "asdf");
        Student s3 = new Student("Dom", "zxcv");
        enrollStudent(s1, 100);
        enrollStudent(s2, 50);
        enrollStudent(s3, 120);
        printList();
    } 
        
    public void changeCapacity(int newCapacity){
        capacity = newCapacity;
    }
    
    public void printCredits(){
        for(Student student : students) {
            student.print();
            System.out.println(student.getCredits());
        }

    }
    
    public void changeCredits(int studentCredits, String studentID){
        for (Student student : students){
            if (student.getStudentID() == studentID){
                student.addCredits(studentCredits);
            }
        }
    }
 
    public void getAvgScore(){
        int avg = 0;
        for(Student student : students){
            avg += student.getCredits();
        }
        avg /= students.size();
        System.out.println("Average score is: " + avg);
    }
}







