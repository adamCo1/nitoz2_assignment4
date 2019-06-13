package Model;

import Event.Event;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void createEvent() {

    }


    @Test
    void addUpdate() {
    }

    @Test
    void sendJoinRequest() {

    }

    @Test
    void createCatagory(){

    }

    @Test
    void getCatagories() {

    }

    @Test
    void getUser() {
    }

    @Test
    void getContactSecurityUser() {
    }

    @Test
    void setController() {
    }

    @Test
    void getEvent() {
        IModel model = new Model();

        List<Event> e =  model.getEvent("title","Event1");

        return;
    }

    @Test
    void getEventsByCatagory() {
    }

    @Test
    void getEventByTitle() {
    }

    @Test
    void getEventsByForce() {
    }

    @Test
    void acceptJoinRequest() {
    }

    @Test
    void login() {
    }
}