package quotes;

import java.util.ArrayList;

public class Quote {
    ArrayList<String> tags;
    String author;
    String likes;
    String text;

    public Quote(ArrayList<String> tags, String auth, String likes, String body){
        this.tags = tags;
        this.author = auth;
        this.likes = likes;
        this.text = body;
    }

    public String toString(){
        return String.format("Author: %s\nQuote: %s", this.author, this.text);
    }



}
