package org.model.command;

import org.model.Veiculo;
import org.model.state.Reservado;

public class ReservarVeiculoCommand implements Command {
    private Veiculo veiculo;

    public ReservarVeiculoCommand(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void execute() {
        veiculo.setEstado(new Reservado());
    }
}
