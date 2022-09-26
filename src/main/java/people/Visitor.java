package people;

import attractions.Attraction;

import java.util.ArrayList;
import java.util.List;

public class Visitor {

    private int age;
    private double height;
    private double money;
    private List<Attraction> visited;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visited = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public int getVisitedCount() {
        return visited.size();
    }

    public void addVisited(Attraction attraction) {
        visited.add(attraction);
    }

}
