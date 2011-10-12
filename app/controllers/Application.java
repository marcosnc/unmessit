package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

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

    public static void bookings() {
        render();
    }

    public static void contact() {
        render();
    }

    public static void about() {
        render();
    }

}