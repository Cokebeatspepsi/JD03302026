package Classes;

import java.util.Objects;

public class Mage extends Beginner {
    private String spell;
    private int mana;
    private int maxMana;

    public Mage(String name,String spell, int mana, int maxMana,int level,int attack, int defence) {
        super(name, level, attack, defence);
        this.spell = spell;
        this.mana = mana;
        this.maxMana = maxMana;
    }

    public int getMana() {return mana;}
    public void setMana(int mana) {this.mana = mana;}
    public int getMaxMana() {return maxMana;}
    public void setMaxMana(int maxMana) {this.maxMana = maxMana;}
    public String getSpell() {return spell;}
    public void setSpell(String spell) {this.spell = spell;}


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mage mage = (Mage) o;
        return getMana() == mage.getMana() && getMaxMana() == mage.getMaxMana() && Objects.equals(getSpell(), mage.getSpell());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpell(), getMana(), getMaxMana());
    }

    @Override
    public String toString() {
        return "Mage{" +
                "mana=" + mana +
                ", spell='" + spell + '\'' +
                ", maxMana=" + maxMana +
                '}';
    }
}
