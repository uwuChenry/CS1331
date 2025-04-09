public class ComicBookBin {
    public static Superhero[] mergeSortHeroes(Superhero[] heroes) {
        if (heroes.length < 2) {
            return heroes;
        }
        int mid = heroes.length / 2;
        Superhero[] left = RecursionUtils.copyOfRange(heroes, 0, mid);
        Superhero[] right = RecursionUtils.copyOfRange(heroes, mid, heroes.length);
        return RecursionUtils.merge(mergeSortHeroes(left), mergeSortHeroes(right));
    }

    public static Superhero[] mergeHeroes(Superhero[][] teams) {
        if (teams.length == 0) {
            return new Superhero[0];
        }
        return mergeHeroesHelper(teams, 0, teams.length - 1);
    }

    private static Superhero[] mergeHeroesHelper(Superhero[][] teams, int start, int end) {
        if (start == end) {
            return teams[start];
        }
        int mid = (start + end) / 2;
        Superhero[] left = mergeHeroesHelper(teams, start, mid);
        Superhero[] right = mergeHeroesHelper(teams, mid + 1, end);
        return RecursionUtils.merge(left, right);
    }

    public static Superhero[] heroesOfAlliance(Superhero[] heroes, Alliance alliance) {
        return filterByAlliance(heroes, alliance, 0);
    }

    private static Superhero[] filterByAlliance(Superhero[] heroes, Alliance alliance, int index) {
        if (index == heroes.length) {
            return new Superhero[0];
        }
        Superhero[] filtered = filterByAlliance(heroes, alliance, index + 1);
        if (heroes[index].getAlliance() == alliance) {
            Superhero[] result = new Superhero[filtered.length + 1];
            System.arraycopy(filtered, 0, result, 1, filtered.length);
            result[0] = heroes[index];
            return result;
        }
        return filtered;
    }

    public static double totalStrength(Superhero[] heroes) {
        return totalStrengthHelper(heroes, 0);
    }

    private static double totalStrengthHelper(Superhero[] heroes, int index) {
        if (index == heroes.length) {
            return 0;
        }
        return heroes[index].getAlliance().getStrength() + totalStrengthHelper(heroes, index + 1);
    }

    public static void flip(Superhero[] heroes) {
        flipHelper(heroes, 0, heroes.length - 1);
    }

    private static void flipHelper(Superhero[] heroes, int start, int end) {
        if (start >= end) {
            return;
        }
        Superhero temp = heroes[start];
        heroes[start] = heroes[end];
        heroes[end] = temp;
        flipHelper(heroes, start + 1, end - 1);
    }
}