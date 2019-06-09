package View;

import Event.*;
import java.util.List;
import java.util.Observer;

public interface IView {

    EventDetailsContainer getEventUpdateFromUser() ;
    EventDetailsContainer getEventDetailsFromUser(List<String> categories) ;
    JoinRequestContainer getUserJoinRequest();
    Event getEventToUpdateFromUser();
}
