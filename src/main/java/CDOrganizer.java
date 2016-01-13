import java.util.ArrayList;

public class CDOrganizer {

  // declare member variables here
  private String mArtist;
  private String mTitle;
  private static ArrayList<CDOrganizer> catalog = new ArrayList<CDOrganizer>();

  public CDOrganizer(String artist, String title) {

    mTitle = title;
    mArtist = artist;
    catalog.add(this);

  }

  public String getTitle() {
    return mTitle;
  }

  public String getArtist() {
    return mArtist;
  }

  public static ArrayList<CDOrganizer> catalog() {
    return catalog;
  }

  public static ArrayList<String> artistsList() {
    ArrayList<String> list = new ArrayList<String>();
    for (CDOrganizer mArtist : catalog) {
      if ( !list.contains(mArtist.getArtist()) ) {
        list.add(mArtist.getArtist());
      }
    }
    return list;
  }

  public static ArrayList<CDOrganizer> find(String search) {
    ArrayList<CDOrganizer> result = new ArrayList<CDOrganizer>();
    for (CDOrganizer cd: catalog){
      if (cd.getTitle().equals(search) || cd.getArtist().equals(search)){
        result.add(cd);
      }
    }
    return result;
  }

}
