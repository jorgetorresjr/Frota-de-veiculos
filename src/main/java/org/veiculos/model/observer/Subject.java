package org.veiculos.model.observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String mensagem);
}
