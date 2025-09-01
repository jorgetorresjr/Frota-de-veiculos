package org.veiculos.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.veiculos.model.observer.Observer;
import org.veiculos.model.state.Disponivel;
import org.veiculos.model.state.EstadoVeiculo;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String placa;
    private EstadoVeiculo estado;
    private String modelo;

    @JsonIgnore
    private List<Observer> observers = new ArrayList<>();

    public Veiculo() {}

    public Veiculo(String modelo, String placa) {
        this.placa = placa;
        this.modelo = modelo;
        this.estado = new Disponivel();
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
        notifyObservers("O veículo " + modelo + " - placa: " + placa + " mudou para o estado: " + estado.getNome());
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Observer> getObservers() {
        return new ArrayList<>(observers);
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void avancarEstado() { estado.avancarEstado(this); }

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String mensagem) {
        for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }

}
