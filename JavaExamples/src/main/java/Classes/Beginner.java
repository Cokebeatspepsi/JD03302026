package Classes;

public class Beginner {
    private String name;
    private int level;
    private int attack;
    private int defence;

    public Beginner() {}

    public Beginner(String name, int level, int attack, int defence) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getDefence() {
        return defence;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}








