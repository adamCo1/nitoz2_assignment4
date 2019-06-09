package Interfaces;

import java.util.Observer;

public interface ObserveableObject {

    void attachObserver(Observer o) ;
    void removeObserver(Observer o);
}
