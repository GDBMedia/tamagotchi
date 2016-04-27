import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
       // puts the currently non-existent jobs here, so we may grab it at line 24, after a "go back" in jobs.vtl
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tom", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String name = request.queryParams("name");
      Tom newTom = new Tom(name);

      request.session().attribute("newTom", newTom);

      model.put("newTom", request.session().attribute("newTom"));

      model.put("template", "templates/tom.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/tom-hunger", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Tom newTom = request.session().attribute("newTom");

      newTom.changeHunger();

      model.put("newTom", request.session().attribute("newTom"));
      model.put("template", "templates/tom.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tom-boredom", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Tom newTom = request.session().attribute("newTom");

      newTom.changeBoredom();

      model.put("newTom", request.session().attribute("newTom"));
      model.put("template", "templates/tom.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tom-tiredness", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Tom newTom = request.session().attribute("newTom");

      newTom.changeTiredness();

      model.put("newTom", request.session().attribute("newTom"));
      model.put("template", "templates/tom.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
