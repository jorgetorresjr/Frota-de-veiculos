package org.model.state;

import org.model.Veiculo;

public class Alugado implements EstadoVeiculo{
    @Override
    public void avancarEstado(Veiculo veiculo) {
        veiculo.setEstado(new Manutencao());
    }

    @Override
    public String getNome() {
        return "Alugado";
    }
}
