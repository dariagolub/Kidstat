package ru.kidstat.model;

import javax.persistence.*;

/**
 * Created by darya on 28/01/15.
 */

@Entity(name = "measure")
public class Measure {


    @Id
    @GeneratedValue
    private int id;

    private int weight;

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
}
