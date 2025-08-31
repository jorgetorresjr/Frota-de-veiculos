package org.model.state;

import org.model.Veiculo;

public class Reservado implements EstadoVeiculo{
    @Override
    public void avancarEstado(Veiculo veiculo) {
        veiculo.setEstado(new Alugado());
    }

    @Override
    public String getNome() {
        return "Reservado";
    }
}
