package org.library;

import java.time.LocalDateTime;

public class BookRequest {
    private final User user;
    private final String book;
    private final String requestTime;

    public BookRequest(User user, String book) {
        this.user = user;
        this.book = book;
        this.requestTime = LocalDateTime.now().toString();
    }

    public User getUser() {
        return user;
    }

    public String getBook() {
        return book;
    }

    public String getRequestTime() {
        return requestTime;
    }
}
