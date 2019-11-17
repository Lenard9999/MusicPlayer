import java.util.ArrayList;

public class Album 
{
    private ArrayList<Song> album;
    private int albumid;
    private String name;
    private String date;
    
    public Album(int albumid ,String name, String date){
        album = new ArrayList();
        this.album = album;
        this.name = name;
        this.date = date;
    }
    
    public void cleararray()
    {
        album = new ArrayList();
    }
    
    public int getid()
    {
        return this.albumid;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void changeName(String name){
        this.name = name;
    }
    
    public String getdate()
    {
        return this.date;
    }
    
    public void addSong(Song song){
        this.album.add(song);
    }
    
    public ArrayList<Song> getSongs(){
        return this.album;
    }
}
