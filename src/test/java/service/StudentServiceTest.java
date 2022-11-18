package service;

import com.example.dto.StudentDTO;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.EmployeeService;
import com.example.service.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentServiceTest {

   @Mock
   private StudentRepository studentRepository;

   @InjectMocks
   private EmployeeService studentService = new StudentServiceImpl();

   @BeforeEach
   public void setUp(){
       MockitoAnnotations.openMocks(this);
   }


   /* @Test
    public void testCreateStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("shree");
        studentDTO.setPhoneNumber("123234");
        boolean result = studentService.createStudent(studentDTO);
        Assertions.assertTrue(result);
    }

    @Test
    public void getStudent(){
       List<Student> studentList = new ArrayList<>();
       Student student = new Student();
       Student student1 = new Student();
       studentList.add(student1);
       studentList.add(student);

        Mockito.when(studentRepository.findAll()).thenReturn(studentList);

        List<Student> students = studentService.getStudents();
        Assertions.assertNotNull(students);
        Assertions.assertEquals(2, students.size());
    }

    @Test
    public void testGetStudentById(){
       Student student = new Student();
       student.setName("shree");
       student.setStudentId(5);

       Mockito.when(studentRepository.findById(5)).thenReturn(Optional.of(student));

       Student students = studentService.getStudentById(5);
       Assertions.assertNotNull(students);
       Assertions.assertEquals(5, students.getStudentId());
       Assertions.assertEquals("shree", student.getName());
    }*/

    @Test
    public void testCalculate(){
        Student student = new Student();
        student.setStudentId(5);
        student.setName("ram");

        Mockito.when(studentRepository.findById(2)).thenReturn(Optional.of(student));


        int result = studentService.getCalculationResult(2);
        Assertions.assertEquals(50, result);
    }


}
