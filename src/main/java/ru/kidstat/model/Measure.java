package ru.kidstat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Min;
import java.util.Date;


/**
 * Created by darya on 28/01/15.
 */

@Entity(name = "measure")
public class Measure {


    @Id
    @GeneratedValue
    private int id;

    @Min(2)
    private int weight;
    private int high;
    private int age;

    private Date date;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }


    public Date getDate() {
        return date;
    }

    @PrePersist
    public void setDate() {
        date = new Date();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
