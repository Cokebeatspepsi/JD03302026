package Classes;

import java.util.Objects;

public class Warrior extends Beginner {
    private String ability;
    private int stamina;


    public Warrior(String name,String ability,int level,int attack, int defence, int stamina) {
        super(name, level, attack, defence);
        this.ability = ability;
        this.stamina = stamina;
    }


    public String getAbility() {
        return ability;
    }
    public void setAbility(String ability) {
        this.ability = ability;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Warrior warrior = (Warrior) o;
        return getStamina() == warrior.getStamina() && Objects.equals(getAbility(), warrior.getAbility());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbility(), getStamina());
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "ability='" + ability + '\'' +
                ", stamina=" + stamina +
                '}';
    }
}
