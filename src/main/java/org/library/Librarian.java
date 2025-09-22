package org.library;
import org.library.entity.User;

import java.util.PriorityQueue;

public class Librarian extends User {

    private final PriorityQueue<BookRequest> requestQueue;

    public Librarian(String name) {
        super(name);
        this.requestQueue = new PriorityQueue<>(new BookRequestPriorityHandler());
    }

    public void addBookRequest(User user, String book) {
        requestQueue.add(new BookRequest(user, book));
    }

    public BookRequest processNextRequest() {
        return requestQueue.poll();
    }
}
