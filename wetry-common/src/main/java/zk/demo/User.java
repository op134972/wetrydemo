package zk.demo;

import java.io.Serializable;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-07 16:28
 */
public class User implements Serializable {
    int userid;
    String userName;

    public int getUserid() {
        return userid;
    }

    public User setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", userName='" + userName + '\'' +
                '}';
    }
}
