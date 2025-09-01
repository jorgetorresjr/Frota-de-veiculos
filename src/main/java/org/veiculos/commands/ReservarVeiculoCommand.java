package org.veiculos.commands;

import org.veiculos.model.entities.Veiculo;
import org.veiculos.model.state.Reservado;

public class ReservarVeiculoCommand implements Command {
    private org.veiculos.model.entities.Veiculo veiculo;

    public ReservarVeiculoCommand(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void execute() {
        veiculo.setEstado(new Reservado());
    }
}
