package dk.easv.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Rating> ratings;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.ratings = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id +
                ", '" + name + '\'' +
                ", ratings=" + ratings.size();
    }
}
