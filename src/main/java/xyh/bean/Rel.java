package xyh.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Rel implements Serializable {
    private Integer sid;
    private Integer pid;
    private Timestamp enrollTime;

    public Rel() {

    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Timestamp getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Timestamp enrollTime) {
        this.enrollTime = enrollTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rel)) return false;
        Rel rel = (Rel) o;
        return Objects.equals(sid, rel.sid) &&
                Objects.equals(pid, rel.pid) &&
                Objects.equals(enrollTime, rel.enrollTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid, pid, enrollTime);
    }

    @Override
    public String toString() {
        return "Rel{" +
                "sid=" + sid +
                ", pid=" + pid +
                ", enrollTime=" + enrollTime +
                '}';
    }
}
