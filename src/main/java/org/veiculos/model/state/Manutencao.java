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

    @Override
    public String getMensagem(Veiculo veiculo) {
        return "Veiculo " + veiculo.getModelo() + " - placa " + veiculo.getPlaca() + " entrou em manutenção";
    }
}
