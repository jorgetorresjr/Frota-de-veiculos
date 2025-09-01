package org.veiculos.model.state;

import org.veiculos.model.entities.Veiculo;

public interface EstadoVeiculo {
    void avancarEstado(Veiculo veiculo);
    String getNome();
    String getMensagem(Veiculo veiculo);

}
