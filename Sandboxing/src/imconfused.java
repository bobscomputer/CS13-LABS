public class imconfused {
    public static void main(String[] args) {
        String currAlbum = "beatopia #1(FAVORITE)";
        System.out.println(currAlbum.contains("(FAVORITE)"));  
        System.out.println(currAlbum);
        // check if input matches album name
            for(int k=0; k<currAlbum.length(); k++) {
                if(currAlbum.charAt(k) == '(') {
                    currAlbum = currAlbum.substring(0, k);
                }
            }
        System.out.println(currAlbum);
        System.out.println(currAlbum.equals("beatopia #1"));
    }
}
