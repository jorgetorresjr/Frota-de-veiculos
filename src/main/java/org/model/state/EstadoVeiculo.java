package org.model.state;

import org.model.Veiculo;

public interface EstadoVeiculo {
    void avancarEstado(Veiculo veiculo);
    String getNome();
}
