package org.library;

import org.library.entity.Student;
import org.library.entity.Teacher;
import org.library.entity.User;

import java.util.Comparator;


public class BookRequestPriorityHandler implements Comparator<BookRequest> {

    @Override
    public int compare(BookRequest r1, BookRequest r2) {
        User u1 = r1.getUser();
        User u2 = r2.getUser();

        // Teachers before students
        if (u1 instanceof Teacher && u2 instanceof Student) {
            return -1;
        } else if (u1 instanceof Student && u2 instanceof Teacher) {
            return 1;
        }

        // If both are students. Seniors first
        if (u1 instanceof Student s1 && u2 instanceof Student s2) {
            return Integer.compare(s2.getStudentClass(), s1.getStudentClass());
        }

        // Otherwise; first come, first serve
        return r1.getRequestTime().compareTo(r2.getRequestTime());
    }

}
