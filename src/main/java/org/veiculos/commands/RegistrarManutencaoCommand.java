package org.veiculos.commands;

import org.veiculos.model.entities.Veiculo;
import org.veiculos.model.state.Manutencao;

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
