package sba.sms.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sba.sms.models.Course;
import sba.sms.models.Student;
import sba.sms.utils.CommandLine;
import sba.sms.utils.HibernateUtil;

import java.util.*;

import static org.assertj.core.api.Assertions.*;


class StudentServiceTest {


    static StudentService studentService;

    @BeforeAll
    public static void setUp() {
        studentService = new StudentService(HibernateUtil.getSessionFactory());
    }

    @Test
    public void testCreateStudent() {
        Student student = new Student("test@gmail.com", "Student", "password");

        // Simulate a successful creation
        assertThatCode(() -> studentService.createStudent(student)).doesNotThrowAnyException();
    }

    @Test
    public void testGetAllStudents() {
        // Sample students
        List<Student> students = Arrays.asList(
                new Student("test1@gmail.com", "Student One", "password123"),
                new Student("test2@gmail.com", "Student Two", "password987")
        );

        assertThat(studentService.getAllStudents()).isEqualTo(students);
    }

    @Test
    public void testGetStudentByEmail() {
        Student student = new Student("test@gmail.com", "Student", "password");

        assertThat(studentService.getStudentByEmail("test@gmail.com")).isEqualTo(student);
    }

    @Test
    public void testValidateStudent() {
        // Simulate valid credentials
        assertThat(studentService.validateStudent("test@gmail.com", "password")).isTrue();
    }

    @Test
    public void testRegisterStudentToCourse() {
        Student student = new Student("test@gmail.com", "Student", "password");
        Set<Student> students = new HashSet<>(Arrays.asList(student));
        Course course = new Course(1, "Math 101", "Dr. Smith", students);

        // Simulate registering a student to a course
        assertThatCode(() -> studentService.registerStudentToCourse("test@gmail.com", 1)).doesNotThrowAnyException();


    }

    @Test
    public void testGetStudentCourses() {
        Student student = new Student("test@gmail.com", "Student", "password");
        Set<Student> students = new HashSet<>(Arrays.asList(student));
        List<Course> courses = Arrays.asList(
                new Course(1, "Math 101", "Dr. Smith", students),
                new Course(2, "History 101", "Dr. Johnson", students)
        );

        // Simulate retrieval of student courses
        assertThat(studentService.getStudentCourses("test@gmail.com")).isEqualTo(courses);
    }








}