public class Builder 
{
    private final SongBuilder songbuilder = new CustomSongBuilder();
    
    public Song getSong()
    {
        return songbuilder.getSong();
    }
    
    public void constructSong(int songid, String album, Genre genre, int year)
    {
        songbuilder.createNewSong(songid);
        songbuilder.buildAlbum(album);
        songbuilder.buildGenre(genre);
        songbuilder.buildYear(year);
    }
}
