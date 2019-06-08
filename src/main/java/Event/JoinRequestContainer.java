package Event;

import Users.User;

public class JoinRequestContainer {

    private Event event ;
    private User userToBeJoined ;

    public JoinRequestContainer(Event event , User userToBeJoined){
        this.event = event ;
        this.userToBeJoined = userToBeJoined ;
    }


    public User getUserToBeJoined(){
        return this.userToBeJoined ;
    }

    public Event getEvent() {
        return this.event;
    }
}
