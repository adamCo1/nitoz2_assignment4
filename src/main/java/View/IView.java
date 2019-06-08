package View;

import Event.*;
import java.util.List;

public interface IView {

    EventDetailsContainer getEventUpdateFromUser() ;
    EventDetailsContainer getEventDetailsFromUser(List<String> categories) ;
    JoinRequestContainer getUserJoinRequest();
    Event getEventToUpdateFromUser();
}
