package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() throws Exception {
        throw new Exception("Test exception from Play 2 using Java");
    }

}
