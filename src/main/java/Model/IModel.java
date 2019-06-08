package Model;

import Event.*;

import java.util.List;

public interface IModel {

    List<String> getAllPossibleCategories();
    void addEventToSystem(Event event) ;
    void pushJoinRequestToEvent(JoinRequestContainer joinRequest);
}
