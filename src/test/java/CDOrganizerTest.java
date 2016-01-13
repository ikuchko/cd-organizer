import org.junit.*;
import static org.junit.Assert.*;

public class CDOrganizerTest {

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

  @Test
  public void cdOrganizer_returnsCDsByTitle_object() {
    CDOrganizer firstCd = new CDOrganizer("First Artist", "First Title");
    assertEquals(firstCd.getTitle(), firstCd.find("First Title").getTitle());
  }


}
