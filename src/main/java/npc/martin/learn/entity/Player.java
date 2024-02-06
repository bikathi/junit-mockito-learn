package npc.martin.learn.entity;

import java.util.Objects;

public class Player {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Player p = (Player) o;
        return Objects.equals(p.getName(), this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
