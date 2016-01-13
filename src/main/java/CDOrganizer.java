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

  public CDOrganizer find(String search) {
    CDOrganizer result = catalog.get(1);
    try {
      for (CDOrganizer cd: catalog){
        if (cd.getTitle().equals(search)){
          result = cd;
        } else {
          result = catalog.get(99999);
        }
      }
    } catch (IndexOutOfBoundsException ioobe) {
      return null;
    }
    return result;
  }

}
