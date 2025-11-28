/*
Name: Lynn Castro
Description: Demonstrating my understanding of queues and exception handling
Date: 11/19/2025

========================================================
TOTAL Self grade score: 95/100 (explanation below)

EXPLANATIONS...
Proper naming: All of my variables and methods have short and descriptive names (5/5)
Indendation: All code is organized and neatly tabbed by at least 4 spaces (5/5)
Comments: All data and logic is preceded with a comment, however I did not remove some of the given comments(20/25)
Program compiles: Yes, program compiles with both drivers. (30/30)
Program runs & the output is similar to provided output: My driver output is similar to the given output. (25/25)
Requirements: I added two instance variables to the song class, 
              a compareTo method called albumCompareTo & songLengthCompareTo, based on the instance variables,
              and a new method in the queue class that uses try-catch and the new compareTo method I added. (25/25)
Self grade: I have provided a self grade. (5/5)
========================================================
I have written all the code by myself and did not copy code from other resources. Name: Lynn Castro

You must make sure to follow the given instructions for all the methods. If the method is asking to use a LinkedList or ArrayList 
or Array you are not allowed to change it. 

Required Extra features( 40 points)
1. Add two extra instance variables to the song class.
2. The added instance varibales must be included in the methods such as the constructor, tostring, equals method.
3. The given driver must be modified so that it will run with your code.
4. A compareTo method must be added based on the new instance variables that you added. 
5. Must add an extra method in the Queue class that uses try-catch and the compareTo method you added. The method must add functionality
   to the class. This method cannot be similar to any of the given methods. For example you can create a method called is sorted. 
*/

import java.util.*;

public class QueueCastro {
    // no code here
}

class Song {
    // instance variables
    private String song;
    private String singer;
    // added variables by student
    private int songLength;
    private String album;

    // Constructor
    public Song(String song, String singer, int songLength, String album) {
        this.song = song;
        this.singer = singer;
        this.songLength = songLength;
        this.album = album;
    }

    // Accessor methods
    public String getSong() {
        return song;
    }

    public String getSinger() {
        return singer;
    }

    // mutator method for album, for my additional method
    public void setAlbum(String album) {
        this.album = album;
    }

    // Accessor methods for the 2 additional instance variables
    public int getSongLength() {
        return songLength;
    }

    public String getAlbum() {
        return album;
    }

    // toString method
    public String toString() {
        String border = "-".repeat(35);

        return String.format("%n%s" + 
                             "%nSinger name: %s" + 
                             "%nSong title: %s" + 
                             "%nTrack length: %d (seconds)" +
                             "%nAlbum name: %s %n%s", 
                             border, getSinger(), getSong(), 
                             getSongLength(), getAlbum(), border);
    }

    // Equals method
    public boolean equals(Song other) 
    {
        return this.song.equalsIgnoreCase(other.song) && 
               this.singer.equalsIgnoreCase(other.singer) &&
               (this.songLength == other.songLength) &&
               this.album.equalsIgnoreCase(other.album);

    }

    // compares 2 songs based on the singer, if same singer, compares their songs
    public int compareTo(Song other) {
        // singer equals singer, compare song names
        if(this.singer.compareTo(other.singer) == 0)
            return this.song.compareTo(other.song);

        // two different singers
        else
            return this.singer.compareTo(other.singer);
    }
    
    // additional compareTo, compares 2 albums
    public int albumCompareTo(Song o) {
        // same album
        if(this.album.equalsIgnoreCase(o.getAlbum())) {
            return 0;
        }

        // different album
        else {
            return this.album.compareTo(o.getAlbum());
        }
    }

    // additional compareTo, compares 2 songLengths
    public int songLengthCompareTo(Song o) {
        // same songLength
        if(this.songLength == o.getSongLength()) {
            return 0;
        }

        // diff songLength
        else {
            return this.songLength - o.getSongLength();
        }
    }
}

/*
 * Queue class using an Array. this class will create a queue of songs
 * Using ArrayList or LinkList will get zero points
 */
class Queue {
    // instance variables
    private Song[] list;
    private int count = 0;

    // constructor
    public Queue() {
        list = new Song[20];

    }

    // adds the given song to the end of list
    public void enqueue(Song s) {
        try {
            list[count] = s;
            count++;
        }

        catch(Exception e) {
            System.out.println("Did not add new song because list is full.");
        } 
    }

    // removes the song at the top of the queue, then uses shift()
    public Song dequeue() {
        Song s = null;

        try{
            s = list[0];
            list[0] = null;
            shift();
            count--;
        }

        // Dequeued a null song
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // check if dequeued an empty list
        if(count < 0) {
            count = 0;
        }
        return s;
    }

    // shifts entire list to the left after removing the first song
    public void shift() {

        // make the first element null
        this.list[0] = null;

        // shift all remaining elements to the left
        try{
            for(int i=1; i<this.list.length; i++) {
                list[i-1] = list[i];
            }
        }

        // reached a null element
        catch(Exception e) {
            return;
        }
    }

    /*
     * This method plays the song in the queue. playing the song in the front of the
     * queue, removing the song at index 0
     * then moving to the next song util no more songs left in the queue. No for
     * loop or a counter for the index can be used
     */
    public void play() {
        // Declarations
        String border = "-=".repeat(25);
        Stack<Song> s = new Stack<>();
        Scanner scan = new Scanner(System.in);
        boolean done = false;

        // while done is false
        while(!done)
        {
            try {
                // dequeue a song , store it in a variable called front of type Song, dequeue method must be called
                Song front = dequeue();

                // if dequeued song is null throw an exception
                if(front == null) {
                    throw new Exception("Dequeued song is null/does not exist, can't play.");
                }

                // push the variable front to the stack that you declared above
                s.push(front);

                // display the content of the front
                System.out.printf("%n%s%nPlaying: %s %n%s%n", border, front.getSong(), border);
                System.out.print("Press any key to continue > ");
                // flush the buffer
                scan.nextLine();

            } catch (Exception e) {
                // set done to true
                done = true;
            }

        }
        // call the restore method and pass the s to it
        restore(s);
    }

    /*
     * this method gets the name of a singer and finds all the song with the given
     * singer. return the list of the songs
     * Since the list is a queue, you can only see the song at the index 0. This
     * method must be implemented using the queue concept
     * and not looping through the list.
     * This method gets the song at the index 0, then pushes it to an extra storage
     * of stack so that we can restore the queue using the stack
     * Must use LinkList for the method below otherwise zero points will be given
     * for the whole code
     */

    // gets all of the songs under the given singer's name
    public LinkedList<Song> getSingerSongs(String singer) {
        // Declarations
        LinkedList<Song> songs = new LinkedList<>();
        Stack<Song> s = new Stack<>();
        boolean done = false;

        // while done is false
        while(!done)
        {
            try {
                // dequeue a song and store it in a variable of type Song called front(method dequeue must be called
                Song front = dequeue();

                // if the song is null throw an exception
                if(front == null) {
                    throw new Exception("Dequeued a null song. Can't call getSingerSongs.");
                }

                // push the front variable to the stack
                s.push(front);

                // if the singer's name in the variable front is the same as the singer paramter
                // add front to the LinkedList of songs that you declared
                if(front.getSinger().equalsIgnoreCase(singer)) {
                    songs.add(front);
                }
                
            } catch (Exception e) {
                done = true;
            }

        }
        // call the restore method and pass the stack s to it
        restore(s);

        return songs;
    }

    /*
     * this method goes through the queue, removing the element at index 0, push it
     * to the stack, and also concatinate it
     * to the String s that will hold the list of all the songs.
     * Must use try/catch. the code is similar to the method above.
     * also don't forget to call the restore method at the very end, before the
     * return statement.
     * Make sure to use try/catch
     * Keep dequeuing from the array until a null is dequeued at that point an
     * Exception must be thrown
     */

    // displays all the songs and their details in the list
    public String toString() {
        String songsDisplay = "";
        Stack<Song> s = new Stack<>();
        boolean done = false;

        while(!done) {
            try {
                Song front = dequeue();

                if(front == null) {
                    throw new Exception("Dequeued song is null. Can't continue with toString()");
                }

                s.push(front);
                songsDisplay += front.toString();
            }

            catch (Exception e) {
                done = true;
            }
        }
        restore(s);
        return songsDisplay;
    }

    /*
     * This method gets a stack of songs and restores the original queue in the
     * original order.
     */
    public void restore(Stack s) {
        count = 0;
        boolean b = false;
        while (!b) {
            try {
                if (s.isEmpty())
                    throw new Exception();
                Song ss = (Song) s.pop();
                list[count] = ss;
                count++;
            } catch (Exception c) {
                b = true;
            }
        }
    }

    /*
     * this method reverses the order of the songs in the queue. if the songs are a
     * b c d then method reverse will change the queue to
     * d c b a
     */

    // reverses the order of songs in the list
    public void reverseOrder() {
        // declare a boolean called done = false
        boolean done = false;

        // decalre a stack called s
        Stack<Song> s = new Stack<>();

        // while done is false
        while(!done)
        {
            try {
                // dequeue the song and store it in a variable of type song called e
                Song e = dequeue();

                // if song is null throw an exception
                if(e == null) {
                    throw new Exception("Dequeued a null song. Can't continue with reverseOrder()");
                }

                // push e to the stack s
                s.push(e);

            } catch (Exception e) {
                // set b to true
                done = true;
            }
        }

        // set be to false
        Boolean b = false;

        // while b is false(this loop is building the queue in the reverse order using the stack s
        while(!b)
        {
            try {
                // pop an element from the stack s , store it in a variable of type Object
                // called o
                Object o = s.pop();

                // if o is null
                if(o == null) {
                    // throw an exception
                    throw new Exception("Null song is stack. Can't continue with reverseOrder()");
                }

                // enqueue the object o by calling the enqueue method
                enqueue((Song) o);

            } catch (Exception e) {
                // set b to true
                b = true;
            }
        }
    }

    /*
     * This method gets the name of a singer and returns the percentage of the songs
     * in the queue from the given singer
     */
    public String getPercentage(String singer) {
        // declare a variable of type int to hold the number of the songs by the given singer
        int numSongs = 0;
        double sum = 0;
        int count = 0; // holds the number of the songs in the list
        // declare a boolean called done set it to false
        boolean done = false;

        // declare a stack called s
        Stack<Song> s = new Stack<>();

        // while b is false
        while(!done)
        {
            try {
                // dequeue a song by calling the dequeue method and store it in a variable of
                // type song called song
                Song song = dequeue();

                // if song is null
                if(song == null)
                {
                    throw new Exception("Dequeued song is null. Can't continue with getPercentage()");
                }

                // incremnet count
                count++;

                // push song to the stack
                s.push(song);

                // if song.getSinger is the same as singer
                // incremnet sum
                if(song.getSinger().equalsIgnoreCase(singer)) {
                    sum++;
                }

            } catch (Exception e) // goes here when there is no song left in the queueue
            {
                // set b to true
                done = true;

            }
        }
        // call the restore method and pass s to it
        restore(s);
        return sum + " out of " + count + " is by the singer " + singer;
    }

    /*
     * rebuild the queueue from the given stack which contains all the songs
     */
    public void preserve(Queue q) {
        boolean b = false;
        while (!b) {
            try {
                this.enqueue(q.dequeue());
            } catch (Exception e) {
                b = true;
            }
        }
    }

    // Additional method, marks a song as a 'favorite'
    public void favoriteAlbum() {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean favorited = false;

        while(!quit) {
            try{
                System.out.println("Enter 'q' or 'Q' to quit.");
                System.out.println("Displaying playlist: \n" + toString());
                System.out.print("Enter the album title you want to add to your favorites, " + 
                                 "if the given album is already favorited, it will unfavorite, or quit program > ");
                String input = scan.nextLine();

                // user quit
                if(input.equalsIgnoreCase("q")) {
                    scan.close();
                    quit = true;
                }

                else {
                    for(int i=0; i<this.count; i++) {
                        // upper case first letter
                        input = input.substring(0, 1).toUpperCase() + input.substring(1, input.length());

                        // create new Song object with input as the album name
                        Song o = new Song(null, null, 0, input);

                        // search for the song and add a favorite tag to the song name

                        // not already favorited
                        if(list[i].albumCompareTo(o) == 0) {
                            System.out.println("Favoriting album...");
                            input = list[i].getAlbum();
                            list[i].setAlbum(input += "(FAVORITE)");    // I added a setAlbum(String album) method in the Song class
                            favorited = true;
                        }

                        // check if trying to unfavorite
                        else if((list[i].getAlbum().contains("(FAVORITE)")) && (!favorited)) {
                            // check if input matches album name
                            String currAlbum = list[i].getAlbum();

                            for(int k=0; k<currAlbum.length(); k++) {
                                if(currAlbum.charAt(k) == '(') {
                                    currAlbum = currAlbum.substring(0, k);
                                }
                            }

                            // substring without (FAVORITE) equals the given input
                            if(currAlbum.equalsIgnoreCase(input)) {
                                System.out.printf("Unfavoriting...");
                                String album = list[i].getAlbum();

                                for(int j=0; j<album.length(); j++) {
                                    if(album.charAt(j) == '(') {
                                        album = album.substring(0, j);
                                        list[i].setAlbum(album);
                                    }
                                }
                                favorited = true; // removed the favorite tag, so we did find a match
                            }
                        }
                    }

                    // given album is not in the list
                    if(!favorited) {
                        System.out.printf("Did not find '%s' in the list. Did not add anything to favorites.%n", input);
                    }
                    favorited = false;
                }
            }

            // In case there is a mismatch input, but there shouldn't be because nextLine() turns any input into a String
            catch(Exception e) {
                System.out.println("Invalid input. Exiting method...");
                scan.close();
                quit = true;
            }
        }
    }
}

/*
 * Do not remove this driver
 * You must run your code with the given Driver.This is how I test your code.
 */

/*
class Driver {
    public static void main(String[] args) {
        Queue m = new Queue();
        m.enqueue(new Song("Riders in the Sky", "Monroe", 1, "album1"));
        m.enqueue(new Song("Catch My Breath", "Clarkson", 2, "album2"));
        m.enqueue(new Song("All American Girl", "Underwood", 3, "album3"));
        m.enqueue(new Song("Anyway", "McBride", 4, "album4"));
        m.enqueue(new Song("Before He Cheats", "Underwood", 5, "album5"));
        m.enqueue(new Song("Born Free", "Monroe", 6, "album6"));
        m.enqueue(new Song("people Like Us", "Clarkson", 7, "album7"));
        m.enqueue(new Song("Give Her That", "Underwood", 8, "album8"));
        m.enqueue(new Song("So Small", "Underwood", 9, "album9"));
        m.enqueue(new Song("Stronger", "Clarkson", 10, "album10"));
        m.enqueue(new Song("Walk Away", "Monroe", 11, "album11"));
        m.enqueue(new Song("Independence Day", "McBride", 12, "album12"));
        System.out.println("here is the list of your songs\n__________________________");
        System.out.println(m);
        System.out.println("The queue is : " + m);
        m.reverseOrder();
        System.out.println("The queue in the reverse order is: \n" + m);
        m.reverseOrder();

        System.out.println("\n\nSongs by Underwood: \n");
        System.out.println("\n\n" + m.getPercentage("Underwood"));
        System.out.println("\n\n" + m.getPercentage("Clarkson") + "\n\n");
        System.out.println("Now playing your songs\n");
        m.play();
    }
}
*/


/*
 * 20 points
 * create at least 5 objects and create the driver similar to the given one
 * Must call all the methods. You must have suffient lines of code. Cannot copy
 * the given driver
 * Must create your own list of songs
 */
 

class YourDriver {
    public static void main(String[] args) {
        String border = "=".repeat(55);
        Queue playlist1 = new Queue();
        playlist1.enqueue(new Song("Ripples", "Beabadoobee", 180, "Beatopia #1"));
        playlist1.enqueue(new Song("Best Time", "Brent Faiyaz", 120, "Larger Than Life #2"));
        playlist1.enqueue(new Song("Dance", "Shihoko Hirata", 200, "Persona 4 Dancing All Night #3"));
        playlist1.enqueue(new Song("Heaven", "Shihoko Hirata", 175, "Persona 4 Soundtrack #4"));
        playlist1.enqueue(new Song("Pass The Nirvana", "Pierce The Veil", 195, "The Jaws Of Life #5"));

        // play songs, play()
        System.out.printf("%s%nTesting Play(). Playing all songs from playlist1... %n", border);
        playlist1.play();

        // display the playlist before reversing
        System.out.printf("%s%nDisplaying the full playlist... %n", border);
        System.out.println(playlist1);

        // reverse the songs, reverseOrder(), then display reverOrder, toString()
        System.out.printf("%s%nTesting reverseOrder(). Reversing the songs in the playlist... %n", border);
        playlist1.reverseOrder();
        System.out.println(playlist1);

        // testing getSingerSongs()
        System.out.printf("%s%nTesting getSingerSongs() (1/2). Listing all songs by 'Shihoko Hirata'... %n", border);
        System.out.println(playlist1.getSingerSongs("Shihoko Hirata"));
        // getSingerSongs(), with an artist NOT in the list
        System.out.printf("%s%nTesting getSingerSongs() with an artist NOT in the list (2/2). Listing all songs by 'John'... %n", border);
        System.out.println(playlist1.getSingerSongs("John"));

        // display all songs, toString()
        System.out.printf("%s%nTesting toString(). Listing all songs in the list... %n", border);
        System.out.println(playlist1);

        // dequeue a song, then display again
        System.out.printf("%s%nTesting dequeue(). Removing the first song... %n", border);
        playlist1.dequeue();
        System.out.println(playlist1);

        // testing getPercentage()
        System.out.printf("%s%nTesting getPercentage(). Getting percentage of songs in the playlist by 'Shihoko Hirata'... %n", border);
        System.out.println(playlist1.getPercentage("Shihoko Hirata"));

        // testing ADDITIONAL method, favoriteSong()
        System.out.printf("%s%nTesting ADDITIONAL METHOD favortiteAlbum() %n%n", border);      
        playlist1.favoriteAlbum();
    }  
}
