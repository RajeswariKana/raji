package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;

public class Application1 extends Controller{
	public static Result sayHello(String name) {
        return ok(index.render("hello ." +name));
    }

	
	public static Result sayHelloPost() {
		  JsonNode json = request().body().asJson();
		  if(json == null) {
		    return badRequest("Expecting Json data");
		  } else {
		    String name = json.findPath("name").textValue();
		    if(name == null || name == "" || name.contains(" ")) {
		      return badRequest("Missing parameter [name]");
		    } else {
		      return ok("Hello " + name);
		    }
		  }
		}
}
