package org.veiculos.model.state;


import org.veiculos.model.entities.Veiculo;

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
