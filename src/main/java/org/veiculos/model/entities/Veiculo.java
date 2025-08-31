package org.veiculos.model.entities;

<<<<<<< HEAD:src/main/java/org/veiculos/model/entities/Veiculo.java
import org.veiculos.model.observer.Observer;
import org.veiculos.model.state.VeiculoState;
=======
import org.model.observer.Observer;
import org.model.state.EstadoVeiculo;
>>>>>>> 8cbdb1f9e78872083253a635486fd12362eecf3f:src/main/java/org/model/Veiculo.java

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String placa;
    private EstadoVeiculo estado;
    private List<Observer> observers = new ArrayList<>();

    public Veiculo(String placa, EstadoVeiculo estado) {
        this.placa = placa;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public EstadoVeiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVeiculo estado) {
        this.estado = estado;
        notifyObservers("O veículo " + placa + " mudou para o estado: " + estado.getNome());
    }

    public void avancarEstado() { estado.avancarEstado(this); }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String mensagem) {
        for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }
}
