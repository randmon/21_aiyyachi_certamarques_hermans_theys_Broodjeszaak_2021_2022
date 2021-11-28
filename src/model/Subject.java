package model;

import controller.Observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer> observers = new ArrayList<Observer>();
    int state = 0;

    int getState();

    void setState(int state);

    void attach(Observer observer);

    void notifyAllObservers();
}
