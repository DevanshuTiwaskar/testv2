package com.piggybank.piggybank.dto;

public class User {
    
    private int userid;
    private String username;
    private String userpassword;
    public User(int userid, String username, String userpassword) {
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
    }
    public User(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + userid;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((userpassword == null) ? 0 : userpassword.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userid != other.userid)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (userpassword == null) {
            if (other.userpassword != null)
                return false;
        } else if (!userpassword.equals(other.userpassword))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword + "]";
    } 
    
}
