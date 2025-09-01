package org.veiculos.model.state;

import org.veiculos.model.entities.Veiculo;

public class Reservado implements EstadoVeiculo{
    @Override
    public void avancarEstado(Veiculo veiculo) {
        veiculo.setEstado(new Alugado());
    }

    @Override
    public String getNome() {
        return "Reservado";
    }

    @Override
    public String getMensagem(Veiculo veiculo) {
        return "Veiculo " + veiculo.getModelo() + " - placa " + veiculo.getPlaca() + " foi reservado";
    }
}
