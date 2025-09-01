package org.veiculos.model.state;

import org.veiculos.model.entities.Veiculo;

public class Alugado implements EstadoVeiculo{
    @Override
    public void avancarEstado(Veiculo veiculo) {
        veiculo.setEstado(new Manutencao());
    }

    @Override
    public String getNome() {
        return "Alugado";
    }

    @Override
    public String getMensagem(Veiculo veiculo) {
        return "Veículo " + veiculo.getModelo() + " - placa " + veiculo.getPlaca() + " está alugado.";
    }
}
