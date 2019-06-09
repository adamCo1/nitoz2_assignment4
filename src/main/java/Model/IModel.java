package Model;

import Event.*;

import java.util.List;

public interface IModel {

    String[] getAllPossibleCategories();
    void addEventToSystem(Event event) ;
    void pushJoinRequestToEvent(JoinRequestToEvent joinRequest);

}
