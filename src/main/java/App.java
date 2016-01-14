import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/catalog", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/catalog.vtl");

      ArrayList<String> artistList = new ArrayList<String>();
      artistList = CDOrganizer.artistsList();

      model.put("artistList", artistList);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/catalog/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/new-CD-form.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/catalog", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();



      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
