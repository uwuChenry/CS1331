public class Card {
    private int hitpoints;
    private String pokemonName;
    private PokemonType pokemonType;
    private String attack;
    private int condition;

    public Card(int hitpoints, String pokemonName, PokemonType pokemonType, String attack, int condition) {
        this.hitpoints = hitpoints;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.attack = attack;
        if (condition < 40) {
            this.condition = 80;
        } else if (condition > 100) {
            this.condition = 80;
        } else {
            this.condition = condition;
        }
        if (this.condition >= 90 && this.condition <= 100) {
            System.out.println("Card condition: Mint");
        } else if (this.condition >= 80 && this.condition <= 89) {
            System.out.println("Card condition: Excellent");
        } else if (this.condition >= 70 && this.condition <= 79) {
            System.out.println("Card condition: Very Good");
        } else if (this.condition >= 60 && this.condition <= 69) {
            System.out.println("Card condition: Good");
        } else if (this.condition >= 50 && this.condition <= 59) {
            System.out.println("Card condition: Fine");
        } else if (this.condition >= 40 && this.condition <= 49) {
            System.out.println("Card condition: Damaged");
        }
    }

    public Card(int hitpoints, String pokemonName, PokemonType pokemonType) {
        this(hitpoints, pokemonName, pokemonType, "Hyperbeam", 80);
    }
    public Card() {
        this(120, "Ditto", PokemonType.NORMAL, "Imposter", 89);
    }

    public boolean isRestorable() {
        return condition <= 89 && condition >= 50;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int newCondition) {
        if (newCondition >= 40 && newCondition <= 100) {
            condition = newCondition;
        }
    }

    public String toString() {
        return String.format("<%d,%s,%s,%s,%d,%b>", hitpoints,
        pokemonName, pokemonType, attack, condition, isRestorable());
    }

}