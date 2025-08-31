package org.model.command;

import org.model.Veiculo;
import org.model.state.Disponivel;

public class DevolverVeiculoCommand implements Command {
    private Veiculo veiculo;

    public DevolverVeiculoCommand(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void execute() {
        veiculo.setEstado(new Disponivel());
    }
}
