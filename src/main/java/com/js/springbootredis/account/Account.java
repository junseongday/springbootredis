package com.js.springbootredis.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Objects;

@RedisHash("accounts")
public class Account {
    @Id
    private String id;

    private String userName;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) &&
                Objects.equals(getUserName(), account.getUserName()) &&
                Objects.equals(getEmail(), account.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getEmail());
    }
}
