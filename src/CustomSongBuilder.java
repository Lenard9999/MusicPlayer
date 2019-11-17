public class CustomSongBuilder extends SongBuilder 
{
    @Override
    public void buildAlbum(String album)
    {
        song.setAlbum(album);
    }
    
    @Override
    public void buildGenre(Genre genre)
    {
        song.setGenre(genre);
    }
    
    @Override
    public void buildYear(int year)
    {
        song.setYear(year);
    }
}
