/**
 * bin for sorting and filtering and stuff.
 * @author Po Cheng Chen
 * @version 1.0
 */
public class ComicBookBin {

    /**
     * Sorts an array of superheroes in ascending lexicographical order by name.
     *
     * @param heroes the array of superheroes to sort, must not be null or contain null elements
     * @return a sorted array of superheroes in ascending lexicographical order
     */
    public static Superhero[] mergeSortHeroes(Superhero[] heroes) {
        if (heroes.length < 2) {
            return heroes;
        }
        int mid = heroes.length / 2;
        Superhero[] left = RecursionUtils.copyOfRange(heroes, 0, mid);
        Superhero[] right = RecursionUtils.copyOfRange(heroes, mid, heroes.length);
        return RecursionUtils.merge(mergeSortHeroes(left), mergeSortHeroes(right));
    }

    /**
     * Merges multiple sorted arrays of superheroes into a single sorted array.
     *
     * @param teams a 2D array of superhero arrays, where each sub-array is sorted
     *              in ascending lexicographical order
     * @return a single sorted array containing all superheroes from the input arrays
     */
    public static Superhero[] mergeHeroes(Superhero[][] teams) {
        if (teams.length == 0) {
            return new Superhero[0];
        }
        return mergeHeroesHelper(teams, 0, teams.length - 1);
    }

    /**
     * A helper method for recursively flattening the array.
     *
     * @param teams a 2D array of superhero arrays
     * @param start the starting index of the range to merge
     * @param end   the ending index of the range to merge
     * @return a single sorted array containing all superheroes from the specified range
     */
    private static Superhero[] mergeHeroesHelper(Superhero[][] teams, int start, int end) {
        if (start == end) {
            return teams[start];
        }
        int mid = (start + end) / 2;
        Superhero[] left = mergeHeroesHelper(teams, start, mid);
        Superhero[] right = mergeHeroesHelper(teams, mid + 1, end);
        return RecursionUtils.merge(left, right);
    }

    /**
     * Filters an array of superheroes by alliance.
     *
     * @param heroes   the array of superheroes to filter
     * @param alliance the alliance to filter by
     * @return a new array containing only superheroes in the specified alliance
     */
    public static Superhero[] heroesOfAlliance(Superhero[] heroes, Alliance alliance) {
        return filterByAlliance(heroes, alliance, 0);
    }

    /**
     * A helper method for filtering superheroes by alliance.
     *
     * @param heroes   the array of superheroes to filter
     * @param alliance the alliance to filter by
     * @param index    the current index being processed
     * @return a new array containing only superheroes in the specified alliance
     */
    private static Superhero[] filterByAlliance(Superhero[] heroes, Alliance alliance, int index) {
        if (index == heroes.length) {
            return new Superhero[0];
        }
        Superhero[] filtered = filterByAlliance(heroes, alliance, index + 1);
        if (heroes[index].getAlliance() == alliance) {
            Superhero[] result = new Superhero[filtered.length + 1];
            recursiveCopy(filtered, result, 0, 1);
            result[0] = heroes[index];
            return result;
        }
        return filtered;
    }

    /**
     * Recursively copies elements from the source array to the destination array.
     *
     * @param source      the source array
     * @param destination the destination array
     * @param srcIndex    the current index in the source array
     * @param destIndex   the current index in the destination array
     */
    private static void recursiveCopy(Superhero[] source, Superhero[] destination, int srcIndex, int destIndex) {
        if (srcIndex >= source.length) {
            return;
        }
        destination[destIndex] = source[srcIndex];
        recursiveCopy(source, destination, srcIndex + 1, destIndex + 1);
    }

    /**
     * Calculates the total strength of an array of superheroes based on their alliances.
     *
     * @param heroes the array of superheroes
     * @return the total strength of all superheroes in the array
     */
    public static double totalStrength(Superhero[] heroes) {
        return totalStrengthHelper(heroes, 0);
    }

    /**
     * A helper method for strength calc.
     *
     * @param heroes the array of superheroes
     * @param index  the current index being processed
     * @return the total strength of all superheroes from the current index onward
     */
    private static double totalStrengthHelper(Superhero[] heroes, int index) {
        if (index == heroes.length) {
            return 0;
        }
        return heroes[index].getAlliance().getStrength() + totalStrengthHelper(heroes, index + 1);
    }

    /**
     * Reverses the order of an array of superheroes in place.
     *
     * @param heroes the array of superheroes to reverse
     */
    public static void flip(Superhero[] heroes) {
        flipHelper(heroes, 0, heroes.length - 1);
    }

    /**
     * A helper method for flip.
     *
     * @param heroes the array of superheroes to reverse
     * @param start  the starting index of the range to reverse
     * @param end    the ending index of the range to reverse
     */
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