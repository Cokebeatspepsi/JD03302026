// ================================================================
//  Dragon Ball Z – Java OOP Demo
//  Concepts covered: Interfaces, Abstract Classes, Inheritance
// ================================================================


// ----------------------------------------------------------------
//  INTERFACES
//  An interface is a "promise". Any class that implements one
//  MUST include the methods listed inside it.
// ----------------------------------------------------------------

interface Transformable {
    // Any class that implements this MUST have this method
    void transform();
}

interface EnergyUser {
    // Any class that implements this MUST have this method
    void chargeKi();
}


// ----------------------------------------------------------------
//  ABSTRACT CLASS
//  A template that cannot be used directly — it must be extended.
//  Abstract methods have no body; subclasses must fill them in.
//  Regular methods already have a body and are inherited for free.
// ----------------------------------------------------------------

abstract class Fighter {

    // Every fighter has a name and a race
    String name;
    String race;
    int    powerLevel;

    // Constructor — sets the fields when a fighter is created
    public Fighter(String name, String race, int powerLevel) {
        this.name       = name;
        this.race       = race;
        this.powerLevel = powerLevel;
    }

    // ABSTRACT METHOD — no body. Every subclass must write its own.
    public abstract void introduce();

    // ABSTRACT METHOD — every fighter has a signature move
    public abstract void signatureMove();

    // REGULAR METHOD — inherited by all subclasses automatically
    public void showPowerLevel() {
        System.out.println("  " + name + "'s power level: " + powerLevel + "!");
    }
}


// ----------------------------------------------------------------
//  INHERITANCE
//  Each class below "extends" Fighter, inheriting its fields and
//  regular methods, while providing its own introduce() and
//  signatureMove().
// ----------------------------------------------------------------


// Saiyan extends Fighter  →  Saiyan IS-A Fighter
// Saiyan implements Transformable and EnergyUser
class Saiyan extends Fighter implements Transformable, EnergyUser {

    public Saiyan(String name, int powerLevel) {
        super(name, "Saiyan", powerLevel); // call Fighter's constructor
    }

    // Fill in the abstract method from Fighter
    @Override
    public void introduce() {
        System.out.println("I am " + name + ", a proud Saiyan warrior!");
        System.out.println("  Race: " + race);
    }

    // Fill in the other abstract method from Fighter
    @Override
    public void signatureMove() {
        System.out.println(name + " launches a Kamehameha wave!");
    }

    // Fill in transform() because we implemented Transformable
    @Override
    public void transform() {
        System.out.println(name + " is transforming... Super Saiyan achieved!");
        System.out.println("  Power level has multiplied by 50!");
    }

    // Fill in chargeKi() because we implemented EnergyUser
    @Override
    public void chargeKi() {
        System.out.println(name + " cups hands to the side... KI IS CHARGING!");
    }
}


// Namekian extends Fighter  →  Namekian IS-A Fighter
// Namekians can use energy but cannot transform
class Namekian extends Fighter implements EnergyUser {

    public Namekian(String name, int powerLevel) {
        super(name, "Namekian", powerLevel);
    }

    @Override
    public void introduce() {
        System.out.println("I am " + name + ", a Namekian warrior and guardian!");
        System.out.println("  Race: " + race);
    }

    @Override
    public void signatureMove() {
        System.out.println(name + " stretches his arm and fires a Special Beam Cannon!");
    }

    @Override
    public void chargeKi() {
        System.out.println(name + " meditates and focuses his ki quietly...");
    }
}


// Android extends Fighter  →  Android IS-A Fighter
// Androids have no ki — they implement neither EnergyUser nor Transformable
class Android extends Fighter {

    public Android(String name, int powerLevel) {
        super(name, "Android", powerLevel);
    }

    @Override
    public void introduce() {
        System.out.println("I am " + name + ". I feel nothing. I need no ki.");
        System.out.println("  Race: " + race);
    }

    @Override
    public void signatureMove() {
        System.out.println(name + " fires a High-Power Energy Wave from their palm!");
    }
}


// Majin extends Fighter  →  Majin IS-A Fighter
// Majins can transform AND use energy
class Majin extends Fighter implements Transformable, EnergyUser {

    public Majin(String name, int powerLevel) {
        super(name, "Majin", powerLevel);
    }

    @Override
    public void introduce() {
        System.out.println("Buu is... " + name + "! " + name + " likes candy!");
        System.out.println("  Race: " + race);
    }

    @Override
    public void signatureMove() {
        System.out.println(name + " fires the Candy Beam — you are now a piece of candy!");
    }

    @Override
    public void transform() {
        System.out.println(name + " absorbs an enemy and transforms into a new form!");
        System.out.println("  Power level has grown dramatically!");
    }

    @Override
    public void chargeKi() {
        System.out.println(name + " bounces around giggling while somehow powering up...");
    }
}


// ================================================================
//  MAIN — the program starts here
// ================================================================

public class DragonBallZ {

    public static void main(String[] args) {

        // Create the fighters
        Saiyan   goku   = new Saiyan  ("Goku",   9_000);
        Saiyan   vegeta = new Saiyan  ("Vegeta",  8_500);
        Namekian piccolo= new Namekian("Piccolo", 3_500);
        Android  android18 = new Android("Android 18", 5_000);
        Majin    buu    = new Majin   ("Majin Buu", 10_000);


        // ------------------------------------------------------------
        //  POLYMORPHISM
        //  All classes extend Fighter, so we store them in one array.
        //  Java picks the correct introduce() and signatureMove()
        //  for each object automatically at runtime.
        // ------------------------------------------------------------
        System.out.println("=== Z Fighters – Roll Call ===\n");

        Fighter[] fighters = { goku, vegeta, piccolo, android18, buu };

        for (Fighter f : fighters) {
            f.introduce();       // the right version for each class
            f.showPowerLevel();  // inherited from Fighter — same for all
            f.signatureMove();   // the right version for each class
            System.out.println();
        }


        // ------------------------------------------------------------
        //  INTERFACE — Transformable
        //  Only fighters that implement Transformable go here.
        //  Piccolo and Android 18 do not, so they are left out.
        // ------------------------------------------------------------
        System.out.println("=== Transformation Sequence ===\n");

        Transformable[] transformers = { goku, vegeta, buu };

        for (Transformable t : transformers) {
            t.transform();
            System.out.println();
        }


        // ------------------------------------------------------------
        //  INTERFACE — EnergyUser
        //  Only fighters that implement EnergyUser go here.
        //  Android 18 has no ki, so she is left out.
        // ------------------------------------------------------------
        System.out.println("=== Charging Ki ===\n");

        EnergyUser[] energyUsers = { goku, vegeta, piccolo, buu };

        for (EnergyUser e : energyUsers) {
            e.chargeKi();
        }


        // ------------------------------------------------------------
        //  instanceof — check what a fighter IS at runtime
        // ------------------------------------------------------------
        System.out.println("\n=== Type Checks (instanceof) ===\n");

        for (Fighter f : fighters) {
            System.out.println(f.name + ":");
            System.out.println("  Can transform?  " + (f instanceof Transformable));
            System.out.println("  Uses ki energy? " + (f instanceof EnergyUser));
            System.out.println();
        }
    }
}
