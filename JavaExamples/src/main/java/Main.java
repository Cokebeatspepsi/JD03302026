import Classes.Mage;
import Classes.Warrior;

public class Main {
    public static void main(String[] args) {
        Mage myMage = new Mage("Kwaku", "Fire Ball", 80, 200, 12, 8, 18);
        Warrior myWarrior = new Warrior("Cloud", "Omni-slash", 13, 14, 23, 100);

            System.out.printf("Name: %s%n", myMage.getName());
            System.out.println("Spell: " + myMage.getSpell());
            System.out.println("Level: " + myMage.getLevel());
            System.out.println("MaxMana: " + myMage.getMaxMana());
            System.out.println("Attack: " + myMage.getAttack());
            System.out.println("Defence: " + myMage.getDefence());
            System.out.println("--------------------------------");
            System.out.println("Name: " + myWarrior.getName());
            System.out.println("Ability: " + myWarrior.getAbility());
            System.out.println("Level: " + myWarrior.getLevel());
            System.out.println("Stamina: " + myWarrior.getStamina());
            System.out.println("Attack: "+myWarrior.getAttack());
            System.out.println("Defence: "+myWarrior.getDefence());

    }
}

