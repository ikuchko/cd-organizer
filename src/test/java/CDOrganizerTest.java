import org.junit.*;
import static org.junit.Assert.*;

public class CDOrganizerTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void cdOrganizer_instantiatesCorrectly_true(){
    CDOrganizer cdOrganizer = new CDOrganizer("Some Artist", "Some title");
    assertEquals(true, cdOrganizer instanceof CDOrganizer);
  }

  @Test
  public void cdOrganizer_ReturnTitle_Title() {
    CDOrganizer cdOrganizer = new CDOrganizer("Artist", "Title");
    assertEquals("Title", cdOrganizer.getTitle());
  }

  @Test
  public void cdOrganizer_returnArtist_someArtist() {
    CDOrganizer cdOrganizer = new CDOrganizer("Some Artist", "Some Title");
    assertEquals("Some Artist", cdOrganizer.getArtist());
  }

  @Test
  public void cdOrganizer_returnAllInstancesOfCds_true() {
    CDOrganizer firstCd = new CDOrganizer("First Artist", "First Title");
    CDOrganizer secondCd = new CDOrganizer("Second Artist", "Second Title");
    assertTrue(CDOrganizer.catalog().contains(firstCd));
    assertTrue(CDOrganizer.catalog().contains(secondCd));
  }

  // @Test
  // public void cdOrganizer_returnsCDsByTitle_object() {
  //   CDOrganizer firstCd = new CDOrganizer("First Artist", "First Title");
  //   assertEquals(firstCd.getTitle(), firstCd.find("First Title").getTitle());
  // }
  //
  // @Test
  // public void cdOrganizer_returnsCDsByArtist_object() {
  //   CDOrganizer firstCd = new CDOrganizer("First Artist", "First Title");
  //   assertEquals(firstCd.getArtist(), firstCd.find("First Artist").getArtist());
  // }

  @Test
  public void cdOrganizer_returnsListOfArtists_ArrayList(){
    CDOrganizer firstCd = new CDOrganizer("First Artist", "White album");
    CDOrganizer secondCD = new CDOrganizer("Second Artist", "Black album");
    CDOrganizer thirdCd = new CDOrganizer("First Artist", "Blue album");
    assertEquals(2, CDOrganizer.artistsList().size());

  }

  @Test
  public void cdOrganizer_returnsMultipleObjectsForSearch_ArrayList() {
    CDOrganizer firstCd = new CDOrganizer("First Artist", "First Title");
    CDOrganizer secondCd = new CDOrganizer("First Artist", "Second Title");
    assertEquals(firstCd.getArtist(), CDOrganizer.find("First Artist").get(0).getArtist());
    assertEquals(secondCd.getArtist(), CDOrganizer.find("First Artist").get(1).getArtist());
  }

  @Test
  public void cdOrganizer_emptiesAllObjectsFromArrayList() {
    CDOrganizer cdOrganizer = new CDOrganizer("First Artist", "First Title");
    CDOrganizer.clear();
    assertEquals(CDOrganizer.find("First Artist").size(), 0);
  }




}
