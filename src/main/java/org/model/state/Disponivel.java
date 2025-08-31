package org.model.state;
import org.model.Veiculo;


public class Disponivel implements EstadoVeiculo{
    @Override
    public void avancarEstado(Veiculo veiculo) {
        veiculo.setEstado(new Reservado());
    }

    @Override
    public String getNome() {
        return "Disponível";
    }
}
