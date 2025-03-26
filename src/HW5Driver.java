public class HW5Driver {
    
    public static void main(String[] args) {
        Media[] inventory1 = {new Movie(Genre.COMEDY, "Up", 9), //Second
                                new Movie(Genre.MYSTERY, "Knives Out", 7),//Fifth
                                new Movie(Genre.HORROR, "It", 8), //Fourth
                                new Movie(Genre.ACTION, "RRR", 9), //First
                                new Movie(Genre.SCI_FI, "Independence Day", 8), //Seventh
                                new Movie(Genre.FANTASY, "Harry Potter", 7), //Third
                                new Movie(Genre.ROMANCE, "When Harry met Sally", 5) //Sixth
                            };
        Media[] inventory2 = {new VideoGame(Genre.COMEDY, "Fortnite", 9, 10,
                                                                     1, true), //Second
                            new VideoGame(Genre.MYSTERY, "FNAF", 7, 5,
                                                                     1, false), //Fifth
                            new VideoGame(Genre.HORROR, "Poppy's Playtime", 8, 7,
                                                                     1, true), //Fourth
                            new VideoGame(Genre.ACTION, "Superhot", 9, 15,
                                                                     1, true), //First
                            new VideoGame(Genre.SCI_FI, "Portal 2", 8), //Seventh
                            new VideoGame(Genre.FANTASY, "Monster Hunter Wilds", 7, 23,
                                                                     1, true), //Third
                            new VideoGame(Genre.ROMANCE, "Doki Doki Literature Club", 5) //Sixth
                        };
        Media[] inventory3 = {new Movie(Genre.COMEDY, "Despicable Me", 9), //Second
                        new VideoGame(Genre.MYSTERY, "FNAF", 7, 5,
                                                         1, false), //Fifth
                        new Movie(Genre.HORROR, "Alien", 8), // Fourth
                        new VideoGame(Genre.ACTION, "Spiderman", 9, 60,
                                                                 1, true), //First
                        new Movie(Genre.SCI_FI, "Tron", 8), //Seventh
                        new VideoGame(Genre.FANTASY, "Monster Hunter Wilds", 7, 23,
                                                                 1, true), //Third
                        new Movie(Genre.ROMANCE, "Blended", 5) //Sixth
                    };
        Media[] inventory4 = {new Movie(Genre.COMEDY, "Despicable Me", 9), //Second
                    new Movie(Genre.MYSTERY, "FNAF", 7), //Fifth
                    new VideoGame(Genre.HORROR, "Alien", 8), //Fourth
                    new Movie(Genre.ACTION, "Spooderman", 9), //First
                    new VideoGame(Genre.SCI_FI, "Warzone", 8), //Seventh
                    new Movie(Genre.FANTASY, "Godzilla", 7), //Third
                    new VideoGame(Genre.ROMANCE, "Casual Dating Sim", 5) //Sixth
                };
        Blockbuster theFirstBlockBuster = new Blockbuster();
        Blockbuster the90sBlockBuster = new Blockbuster();
        Blockbuster the2000sBlockBuster = new Blockbuster();
        Blockbuster theLastBlockBuster = new Blockbuster();

        for (int i = 0; i < inventory1.length; i++) {
            theFirstBlockBuster.addMedia(inventory1[i]);
            the90sBlockBuster.addMedia(inventory2[i]);
            the2000sBlockBuster.addMedia(inventory3[i]);
            theLastBlockBuster.addMedia(inventory1[i]);
            theLastBlockBuster.addMedia(inventory2[i]);
            theLastBlockBuster.addMedia(inventory3[i]);
            theLastBlockBuster.addMedia(inventory4[i]);
        }
        Media wrongmedia = new Movie(null, null, 0);
        Media wrongvideogame = new VideoGame(null, null, 0);
        int test1 = inventory1[0].compareTo(inventory2[0]); 
        int test2 = inventory3[0].compareTo(inventory3[2]);
        boolean test3 = inventory1[0].equals(inventory1[0]);
        boolean test4 = inventory1[0].equals(inventory4[0]); 
        Movie movie1 = new Movie(Genre.ACTION, "Iron Man", 8, 6.0, 90);
        Movie movie2 = new Movie(Genre.COMEDY, "Monsters Inc.", 7);
        String movie1p = "Genre: ACTION, Name: Iron Man, Rating: 8, Rental Price: $6.00, Runtime: 90";
        String movie2p = "Genre: COMEDY, Name: Monsters Inc., Rating: 7, Rental Price: $5.00, Runtime: 111";
        // System.out.println(movie1p);
        // System.out.println(movie2p);
        // System.out.println(movie1.toString());
        // System.out.println(movie2.toString());
        System.out.println("Movie toString test: " + movie1p.equals(movie1.toString()));
        System.out.println("Movie toString test2: " + movie2p.equals(movie2.toString()));
        String videoString1 = "Genre: ACTION, Name: Skylanders, Rating: 6, Rental Price: $20.00, Players: 2," +
        " does need a console";
        String videoString2 = "Genre: MYSTERY, Name: Five Nights at Freddys, Rating: 6, Rental Price: $5.00, Players: 2," +
        " does not need a console";
        VideoGame videoGame1 = new VideoGame(Genre.ACTION, "Skylanders", 6, 20, 2, true);
        VideoGame videoGame2 = new VideoGame(Genre.MYSTERY, "Five Nights at Freddys", 6);
        System.out.println("Video Game toString test1: " + videoString1.equals(videoGame1.toString()));
        System.out.println("Video Game toString test2: " + videoString2.equals(videoGame2.toString()));
        // System.out.println(videoGame2.toString());
        // System.out.println(videoString2);
        // System.out.println("Original order: -------");
        // for (int i = 0; i < inventory1.length; i++) {
        //     System.out.println(inventory1[i].toString());
        // }
        theFirstBlockBuster.addMedia(inventory4[0]);
        System.out.println("removeMedia test1: "+ (theFirstBlockBuster.removeMedia(inventory4[0]) == inventory4[0]));
        System.out.println("removeMedia test2: " + (theFirstBlockBuster.removeMedia(wrongmedia) == null));
        System.out.println("removeMedia test3: " + (theFirstBlockBuster.removeMedia(wrongvideogame) == null));
        theFirstBlockBuster.sortMedia();
        /* 
        Intended Order:
         * Genre: ACTION, Name: RRR, Rating: 9, Rental Price: $5.00, Runtime: 111
         *  Genre: COMEDY, Name: Up, Rating: 9, Rental Price: $5.00, Runtime: 111
         *  Genre: FANTASY, Name: Harry Potter, Rating: 7, Rental Price: $5.00, Runtime: 111
         *  Genre: HORROR, Name: It, Rating: 8, Rental Price: $5.00, Runtime: 111
         *   Genre: MYSTERY, Name: Knives Out, Rating: 7, Rental Price: $5.00, Runtime: 111
         *  Genre: ROMANCE, Name: When Harry met Sally, Rating: 5, Rental Price: $5.00, Runtime: 111
         *  Genre: SCI_FI, Name: Independence Day, Rating: 8, Rental Price: $5.00, Runtime: 111
         */
        theLastBlockBuster.sortMedia();
        // theLastBlockBuster.printArray(); // if you implement print array you should delete it...
        Media search = theLastBlockBuster.findMedia(inventory4[5]);
        System.out.println("FindMedia test: "+ inventory4[5].toString().equals(search.toString()));
        // theLastBlockBuster.printAllMovie();
        Movie mostPopularMovie = theLastBlockBuster.getMostPopularMovie();
        // System.out.println(mostPopularMovie.toString());
        System.out.println("MostPopularMovie test: " + mostPopularMovie.toString().equals(inventory1[0].toString()));





        System.out.println("Inventory compareTo test1: " + (test1 > 0)); // should return positive value.
        System.out.println("Inventory compareTo test2: " + (test2 < 0)); // should return negative value.
        System.out.println("Inventory equals test1: " + (test3 == true)); // should return true
        System.out.println("Inventory equals test2: " + (test4 == false)); // should return false

        System.out.println("addToCart test0: " + (Olivia.addToCart(inventory4[5],theLastBlockBuster) == true));// should add the Movie Godzilla
        // System.out.println(Olivia.addToCart(inventory4[5], theLastBlockBuster));

        System.out.println("addToCart test1: " + (Olivia.addToCart(inventory3[1], theLastBlockBuster) == true)); // should add the Movie FNAF, return true
        System.out.println("addToCart test2: " + (Olivia.addToCart(inventory1[0], theLastBlockBuster)== true)); // should add the Movie Up and should, return true
        System.out.println("addToCart test3: " + (Olivia.addToCart(inventory2[5], theLastBlockBuster)== true)); // should add the game Monster Hunter Wilds, return true
        System.out.println("addToCart test4: " + (Olivia.addToCart(inventory1[2], theLastBlockBuster) == true)); // should add the Movie It, return true

        
        System.out.println("Invalid addToCart test: " + (Olivia.addToCart(new VideoGame(Genre.FANTASY, "Sonic Adventure 2", 10), theLastBlockBuster) == false));//should return false
        Olivia.printCart();
        Olivia.changeMind(inventory1[2], theLastBlockBuster); //Should remove the It movie
        Olivia.printCart();
        System.out.println("Second getMostPopularMovie test: " + the2000sBlockBuster.getMostPopularMovie().toString().equals(inventory4[0].toString()));
        
    }
}