package org.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void teacherIsAUser() {
        User teacher = new Teacher("Mr. Michael");
        assertNotNull(teacher);
        assertInstanceOf(Teacher.class, teacher);
        assertEquals("Mr. Michael", teacher.getName());
    }

    @Test
    void studentIsAUser() {
        User student = new Student("Mike", 2); // name and class
        assertNotNull(student);
        assertInstanceOf(Student.class, student);
        assertEquals("Mike", student.getName());
        assertEquals(2, ((Student) student).getStudentClass());
    }

    @Test
    void librarianIsAUser() {
        User librarian = new Librarian("Library Man");
        assertNotNull(librarian);
        assertInstanceOf(Librarian.class, librarian);
        assertEquals("Library Man", librarian.getName());
    }
}
