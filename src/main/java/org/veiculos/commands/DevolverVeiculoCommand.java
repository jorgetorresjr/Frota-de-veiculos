package org.veiculos.commands;

import org.veiculos.model.entities.Veiculo;
import org.veiculos.model.state.Disponivel;

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
