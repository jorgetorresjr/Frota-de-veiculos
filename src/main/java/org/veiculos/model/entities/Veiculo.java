package org.veiculos.model.entities;

import org.veiculos.model.observer.Observer;
import org.veiculos.model.state.VeiculoState;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String placa;
    private VeiculoState state;
    private List<Observer> observers = new ArrayList<>();

    public Veiculo(String placa, VeiculoState state) {
        this.placa = placa;
        this.state = state;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public VeiculoState getState() {
        return state;
    }

    public void setState(VeiculoState state) {
        this.state = state;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String mensagem) {
        for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }
}
