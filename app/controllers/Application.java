package controllers;

import play.*;
import play.data.validation.Error;
import play.data.validation.Valid;
import play.exceptions.UnexpectedException;
import play.mvc.*;
import static utils.RenderJsonExcludable.renderJsonExcludable;

import java.util.*;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.*;

public class Application extends Controller {

    public static void home() {
        render();
    }

    public static void occupancy() {
        render();
    }

    public static void clients() {
    	List<Client> clients = Client.find("order by surname, name").fetch();
        render(clients);
    }
    public static void clientById(Long clientId) {
    	Client client = Client.findById(clientId);
    	renderJsonExcludable(client);
    }
    public static void saveClient(@Valid Client client){
    	if (validation.hasErrors()) {
    		StringBuffer errors = new StringBuffer();
    		for (Error error : validation.errors()) {
				errors.append(error.message()).append("<br />");
			}
    		renderText("There ware errors: %s", errors.toString());
    	}
    	client.save();
    	renderText("OK");
    }

    public static void bookings() {
        render();
    }

    public static void contact() {
        render();
    }

    public static void about() {
        render();
    }
    
    public static void test() {
    	render();
    }

}