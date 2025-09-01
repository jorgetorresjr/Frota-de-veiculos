package org.veiculos.model.state;


import org.veiculos.model.entities.Veiculo;

public class Disponivel implements EstadoVeiculo{
    @Override
    public void avancarEstado(Veiculo veiculo) {
        veiculo.setEstado(new Reservado());
    }

    @Override
    public String getNome() {
        return "Disponível";
    }

    @Override
    public String getMensagem(Veiculo veiculo) {
        return "Veiculo " + veiculo.getModelo() + " - placa " + veiculo.getPlaca() + " está disponível";
    }
}
