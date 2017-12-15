package arhip.barber.entity;

import javax.persistence.*;

@Entity
@Table(name = "working_hours")
public class WorkingHours {
    @Id
    private long id;

    @Column(name = "monday", length = 20)
    private String monday;

    @Column(name = "tuesday", length = 20)
    private String tuesday;

    @Column(name = "wednesday", length = 20)
    private String wednesday;

    @Column(name = "thursday", length = 20)
    private String thursday;

    @Column(name = "friday", length = 20)
    private String friday;

    @Column(name = "saturday", length = 20)
    private String saturday;

    @Column(name = "sunday", length = 20)
    private String sunday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }
}
