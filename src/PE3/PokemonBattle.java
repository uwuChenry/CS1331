package PE3;
import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String pokemonName1;
        String pokemonName2;
        int steps = 0;
        double pokemonHp2 = rand.nextInt(20) + 40; 
        System.out.print("Enter your Pokemon's nickname: ");
        pokemonName1 = scan.nextLine();
        System.out.print("Enter your rival's Pokemon's nickname: ");
        pokemonName2 = scan.nextLine();
        System.out.printf("Your rival has chosen %s to fight, which has %.2f health.\n", pokemonName2, pokemonHp2);
        do {
            steps++;
            AttackType attack = AttackType.values()[rand.nextInt(3)];
            double totalDmg = 0;
            if (attack == AttackType.SCRATCH) {
                int attacks = rand.nextInt(3) + 1;
                double dmg = rand.nextDouble()* 5 + 1;
                totalDmg = dmg * attacks;
            }
            if (attack == AttackType.SURF) {
                totalDmg = rand.nextDouble() * 9 + 2;
            }
            if (attack == AttackType.TACKLE) {
                totalDmg = rand.nextDouble() * 2 + 7;
            }
            pokemonHp2 -= totalDmg;
            System.out.printf("%s used %s and did %.2f damage. Your rival has %.2f health remaining.\n", pokemonName1, attack, totalDmg, pokemonHp2 < 0 ? 0 : pokemonHp2);
        } while(pokemonHp2 > 0);
        System.out.printf("%s fainted after %d turns!\n", pokemonName2, steps);
        double prize = 2400 - rand.nextDouble() * 1200;
        System.out.printf("You have earned $%.2f!", prize);
        scan.close();
    }
}
