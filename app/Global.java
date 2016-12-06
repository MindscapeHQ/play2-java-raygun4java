import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;

import com.mindscapehq.raygun4java.play2.RaygunPlayClient;

import static play.mvc.Results.*;

public class Global extends GlobalSettings {

    private String apiKey = "paste_your_api_key_here";

    public Promise<Result> onError(RequestHeader request, Throwable t) {
        RaygunPlayClient rg = new RaygunPlayClient(apiKey, request);
        rg.SendAsync(t);

        return Promise.<Result>pure(internalServerError(
            views.html.myErrorPage.render(t)
        ));
    }

    public Promise<Result> onHandlerNotFound(RequestHeader request) {
        Exception exception = new Exception("Not found");

        RaygunPlayClient rg = new RaygunPlayClient(apiKey, request);
        rg.SendAsync(exception);

        return Promise.<Result>pure(internalServerError(
            views.html.myErrorPage.render(exception)
        ));
    }

}