package org.startsteps.week7.class_01;

/**
 * @version : 1.0
 * This class is about members
 */
public class Member {
    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
