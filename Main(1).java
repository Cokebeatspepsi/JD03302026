// ================================================================
//  "That Time I Got Reincarnated as a Slime" – Java OOP Demo
//   Concepts covered: Interfaces, Abstract Classes, Inheritance
// ================================================================


// ----------------------------------------------------------------
//  WHAT IS AN INTERFACE?
//  An interface is a "promise". If a class implements an interface,
//  it MUST include the methods listed inside it.
//  Think of it like a job description — it says what you can do.
// ----------------------------------------------------------------

interface SkillUser {
    // Any class that implements SkillUser MUST have this method
    void useSkill();
}

interface Loyal {
    // Any class that implements Loyal MUST have this method
    void pledgeLoyalty();
}


// ----------------------------------------------------------------
//  WHAT IS AN ABSTRACT CLASS?
//  An abstract class is a template. You cannot create an object
//  directly from it — it must be extended by another class first.
//  It can have:
//    - abstract methods (no body — subclasses MUST fill these in)
//    - regular methods  (have a body — subclasses inherit these)
// ----------------------------------------------------------------

abstract class Monster {

    // Every monster has a name and a species
    String name;
    String species;

    // Constructor — sets the fields when a monster is created
    public Monster(String name, String species) {
        this.name    = name;
        this.species = species;
    }

    // ABSTRACT METHOD — no body here.
    // Every subclass must write its own version of this.
    public abstract void introduce();

    // REGULAR METHOD — already has a body.
    // Every subclass inherits this automatically.
    public void roar() {
        System.out.println(name + " lets out a fearsome roar!");
    }
}


// ----------------------------------------------------------------
//  WHAT IS INHERITANCE?
//  When a class "extends" another, it inherits all of its fields
//  and methods. The child class can also add new things or
//  override (replace) methods from the parent.
// ----------------------------------------------------------------


// Slime extends Monster  →  Slime IS-A Monster
// Slime implements SkillUser  →  it promises to have useSkill()
class Slime extends Monster implements SkillUser {

    public Slime(String name) {
        super(name, "Slime"); // call the Monster constructor
    }

    // We MUST fill in the abstract method from Monster
    @Override
    public void introduce() {
        System.out.println("Hi! I'm " + name + " — just a humble slime.");
        System.out.println("  Species: " + species);
    }

    // We MUST fill in useSkill() because we implemented SkillUser
    @Override
    public void useSkill() {
        System.out.println(name + " activates [Great Sage]: \"Understood!\"");
    }
}


// Dragon extends Monster  →  Dragon IS-A Monster
class Dragon extends Monster implements SkillUser {

    public Dragon(String name) {
        super(name, "Storm Dragon");
    }

    @Override
    public void introduce() {
        System.out.println("ROAR! I am " + name + ", the mighty Storm Dragon!");
        System.out.println("  Species: " + species);
    }

    @Override
    public void useSkill() {
        System.out.println(name + " activates [Unlimited Imprisonment]!");
    }
}


// Goblin extends Monster  →  Goblin IS-A Monster
// Goblin implements Loyal  →  it promises to have pledgeLoyalty()
class Goblin extends Monster implements Loyal {

    public Goblin(String name) {
        super(name, "Goblin");
    }

    @Override
    public void introduce() {
        System.out.println("U-um, hi! I'm " + name + "... just a goblin.");
        System.out.println("  Species: " + species);
    }

    @Override
    public void pledgeLoyalty() {
        System.out.println(name + " bows: \"I swear loyalty to Lord Rimuru!\"");
    }
}


// Kijin extends Monster  →  Kijin IS-A Monster
// Kijin implements BOTH interfaces — a class can implement many!
class Kijin extends Monster implements SkillUser, Loyal {

    public Kijin(String name) {
        super(name, "Kijin (Evolved Ogre)");
    }

    @Override
    public void introduce() {
        System.out.println("I am " + name + ", a Kijin who serves Lord Rimuru.");
        System.out.println("  Species: " + species);
    }

    @Override
    public void useSkill() {
        System.out.println(name + " activates [Hellflame] — everything burns!");
    }

    @Override
    public void pledgeLoyalty() {
        System.out.println(name + " kneels: \"My blade belongs to Lord Rimuru alone.\"");
    }
}


// ================================================================
//  MAIN — this is where the program starts running
// ================================================================

public class Main {

    public static void main(String[] args) {

        // Create one object of each type
        Slime  rimuru  = new Slime ("Rimuru");
        Dragon veldora = new Dragon("Veldora");
        Goblin gobta   = new Goblin("Gobta");
        Kijin  beni    = new Kijin ("Benimaru");


        // ------------------------------------------------------------
        //  POLYMORPHISM
        //  Because all four classes extend Monster, we can store them
        //  together in a Monster array. Java will automatically call
        //  the correct introduce() method for each one at runtime.
        // ------------------------------------------------------------
        System.out.println("=== Meet the Tempest Federation ===\n");

        Monster[] monsters = { rimuru, veldora, gobta, beni };

        for (Monster m : monsters) {
            m.introduce(); // calls the right version for each class
            m.roar();      // inherited from Monster — same for all
            System.out.println();
        }


        // ------------------------------------------------------------
        //  INTERFACE — SkillUser
        //  Only monsters that implement SkillUser go in this array.
        //  Goblin does not implement it, so it is left out.
        // ------------------------------------------------------------
        System.out.println("=== Unique Skills ===\n");

        SkillUser[] skillUsers = { rimuru, veldora, beni };

        for (SkillUser s : skillUsers) {
            s.useSkill();
        }


        // ------------------------------------------------------------
        //  INTERFACE — Loyal
        //  Only monsters that implement Loyal go in this array.
        //  Dragon does not implement it, so it is left out.
        // ------------------------------------------------------------
        System.out.println("\n=== Pledging Loyalty to Rimuru ===\n");

        Loyal[] loyalOnes = { gobta, beni };

        for (Loyal l : loyalOnes) {
            l.pledgeLoyalty();
        }


        // ------------------------------------------------------------
        //  instanceof — check what a class IS at runtime
        // ------------------------------------------------------------
        System.out.println("\n=== Type Checks (instanceof) ===\n");

        for (Monster m : monsters) {
            System.out.println(m.name + ":");
            System.out.println("  Is a SkillUser? " + (m instanceof SkillUser));
            System.out.println("  Is Loyal?       " + (m instanceof Loyal));
            System.out.println();
        }
    }
}
