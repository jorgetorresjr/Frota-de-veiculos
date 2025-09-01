package org.veiculos.model.observer;

public class NotificationObserver implements Observer {
    private final String grupo;

    public NotificationObserver(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public void update(String mensagem) {
        System.out.println("Notificando grupoo " + grupo + " " + mensagem);
    }
}
