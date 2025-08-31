package org.veiculos.model.observer;

import java.util.ArrayList;
import java.util.List;

public class VeiculoSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String mensagem) {
        for (Observer o : observers) {
            o.update(mensagem);
        }
    }
}
