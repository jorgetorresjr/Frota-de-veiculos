package org.model.command;

import org.model.Veiculo;
import org.model.state.Manutencao;

public class RegistrarManutencaoCommand implements Command {
    private Veiculo veiculo;

    public RegistrarManutencaoCommand(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void execute() {
        veiculo.setEstado(new Manutencao());
    }
}
