/*
Name: Lynn Castro
Description: Demonstrating my understanding of queues and exception handling
Date: 11/19/2025

========================================================
TOTAL Self grade score: 0/100 (explanation below)

EXPLANATIONS...
Proper naming: (0/5)
Indendation: (0/5)
Comments: (0/25)
Program compiles: (0/30)
Program runs & the output is similar to provided output: (0/25)
Requirements: (/25)
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

    /*
    compares the two songs based on the singer, if same singer, then compares the
    two songs based on the name of the songs name
    */
    public int compareTo(Song other) {
        // singer equals singer, compare song names
        if(this.singer.compareTo(other.singer) == 0)
            return this.song.compareTo(other.song);

        // two different singers
        else
            return this.singer.compareTo(other.singer);
    }
    
    // Must add a new compareTo method that is based on the instance variables you added
    public int compareTo(String album, int songLength) {
        // same album, compare track lengths
        if(this.album.compareTo(album) == 0) {
            int lengthDiff = 0;

            // song length is longer than compared arg
            if(this.songLength > songLength) {
                lengthDiff = this.songLength - songLength;
            }

            // song length is shorter than compared arg
            else if(this.songLength < songLength) {
                lengthDiff = this.songLength - songLength;
            }

            // else, song length is equal, return 0
            return lengthDiff;
        }

        // two different albums
        else 
            return this.getAlbum().compareTo(album);
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

    /*
     * adding a song to the end of the queue. Adding an element at the end of the
     * queue. The variable count is the index of the first
     * available spot at the end of the array
     * make sure to increment the count after you place a song at the end of the
     * list
     */

    public void enqueue(Song s) {
        try {
            list[count] = s;
            count++;
        }

        catch(Exception e) {
            System.out.println("Did not add new song because list is full.");
        } 
    }

    /*
     * removing a song from the front of the queue. removing the element at the
     * index 0
     * Song s = list[0]
     * list[0] = null
     * 
     * after setting the list[0] to null, all the elemnets must be shifted to the
     * left. shift method must be called
     * after ethe shift method is called decrement the count by 1
     */

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

    /*
     * this method shifts the elements of the array to the left. This method is
     * called in the dequeue method.
     * a for loop is needed to shift the elements. We have to make sure that all the
     * null values are at the end of the queue
     * for example if the array is :
     * a b c d null null null
     * 
     * null b c d null null null//making the first element null
     * b c d null null null null //shifting all the elements to the left
     */
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
        String border = "-=".repeat(25);
        // declare a stack called s
        Stack<Song> s = new Stack<>();
        // declare a Scanner object
        Scanner scan = new Scanner(System.in);
        // declare a boolean variable called done and set it to false
        boolean done = false;
        // while done is false
        while(!done)
        {
            try {
                // dequeue a song , store it in a variable called front of type Song, dequeue
                // method must be called
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
        // call the restor method and pass the s to it
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
    public LinkedList<Song> getSingerSongs(String singer) {
        // declare an LinkList of Song with the name songs, to hold all the songs with the given siger
        LinkedList<Song> songs = new LinkedList<>();

        // declare a stack named s
        Stack<Song> s = new Stack<>();

        // declare a boolen variable called done and set it to false
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
                // set b to true
                done = true;
            }

        }
        // call the restore method and pass the stack s to it
        restore(s);

        return songs;// Change this to return the arraylist songs

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

    // Additional method
    public Queue favoriteSongs(Queue list, Scanner scan) {
        boolean quit = false;

        while(!quit) {
            System.out.println("Enter 'q' or 'Q' to quit.");
            System.out.print("Enter the song title you want to add to your favorites: ");
            String input = scan.nextLine();
            if( (input.equalsIgnoreCase("q")) ) quit = true;

            //....
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
    }  
}