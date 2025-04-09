public class ComicBookBin {
    public Superhero[] mergeSortHeroes(Superhero[] heroes) {
        if (heroes.length <= 1) {
            return heroes;
        }

        int mid = heroes.length / 2;
        Superhero[] left = new Superhero[mid];
        Superhero[] right = new Superhero[heroes.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = heroes[i];
        }
        for (int i = mid; i < heroes.length; i++) {
            right[i - mid] = heroes[i];
        }

        return merge(mergeSortHeroes(left), mergeSortHeroes(right));
    }
}
