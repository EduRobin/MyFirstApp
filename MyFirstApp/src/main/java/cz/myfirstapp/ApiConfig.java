package cz.myfirstapp;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api") //localhost:8080/MyFirstApp/api/...
public class ApiConfig extends Application {
}
