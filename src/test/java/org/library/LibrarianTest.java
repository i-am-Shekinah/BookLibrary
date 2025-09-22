package org.library;

import org.junit.jupiter.api.Test;
import org.library.entity.Student;
import org.library.entity.Teacher;
import org.library.entity.User;

import static org.junit.jupiter.api.Assertions.*;

public class LibrarianTest {

    @Test
    void teacherGetsPriorityOverStudent() {
        Librarian librarian = new Librarian("Library Man");

        User teacher = new Teacher("Mr. Yakubu");
        User student = new Student("Mike", 2);

        librarian.addBookRequest(student, "Math Book");
        librarian.addBookRequest(teacher, "Math Book");

        // Teacher should be served first
        BookRequest first = librarian.processNextRequest();
        assertEquals("Mr. Yakubu", first.getUser().getName());

        // Student should be next
        BookRequest second = librarian.processNextRequest();
        assertEquals("Mike", second.getUser().getName());
    }

    @Test
    void seniorStudentGetsPriorityOverJuniorStudent() {
        Librarian librarian = new Librarian("Library Man");

        User junior = new Student("Junior Mike", 1);
        User senior = new Student("Senior John", 3);

        librarian.addBookRequest(junior, "Science Book");
        librarian.addBookRequest(senior, "Science Book");

        // Senior student should come first
        BookRequest first = librarian.processNextRequest();
        assertEquals("Senior John", first.getUser().getName());

        // Junior next
        BookRequest second = librarian.processNextRequest();
        assertEquals("Junior Mike", second.getUser().getName());
    }

    @Test
    void firstComeFirstServeWhenSamePriority() {
        Librarian librarian = new Librarian("Library Man");

        User s1 = new Student("Mike", 2);
        User s2 = new Student("John", 2);

        librarian.addBookRequest(s1, "English Book");
        librarian.addBookRequest(s2, "English Book");

        // Same role, same class → order of request decides
        BookRequest first = librarian.processNextRequest();
        assertEquals("Mike", first.getUser().getName());

        BookRequest second = librarian.processNextRequest();
        assertEquals("John", second.getUser().getName());
    }
}
