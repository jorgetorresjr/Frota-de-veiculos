package org.model.state;

import org.model.Veiculo;

public class Manutencao implements EstadoVeiculo{
    @Override
    public void avancarEstado(Veiculo veiculo) {
        veiculo.setEstado(new Disponivel());
    }

    @Override
    public String getNome() {
        return "Em Manutenção";
    }
}
