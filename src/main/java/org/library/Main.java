package org.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.library.entity.Student;
import org.library.entity.Teacher;
import org.library.entity.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Librarian librarian = new Librarian("Library Man");

        User teacher = new Teacher("Mr. Yakubu");
        User student1 = new Student("Junior Mike", 1);
        User student2 = new Student("Senior John", 3);

        librarian.addBookRequest(student1, "Math Book");
        librarian.addBookRequest(teacher, "Math Book");
        librarian.addBookRequest(student2, "Math Book");

        logger.info(librarian.processNextRequest().getUser().getName()); // Mr. Yakubu (Teacher wins)
        logger.info(librarian.processNextRequest().getUser().getName()); // Senior John (Senior > Junior)
        logger.info(librarian.processNextRequest().getUser().getName()); // Junior Mike



    }
}