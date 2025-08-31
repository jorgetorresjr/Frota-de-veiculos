package org.veiculos.model.observer;

public class ClienteObserver implements Observer {
    private final String clienteId;

    public ClienteObserver(String clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public void update(String evento, Object data) {
        System.out.println("Notificando cliente " + clienteId + ": evento=" + evento + " dados=" + data);
    }
}
