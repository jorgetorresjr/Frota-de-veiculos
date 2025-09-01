package org.veiculos.commands;

import org.veiculos.model.entities.Veiculo;
import org.veiculos.model.state.Alugado;
import org.veiculos.commands.Command;

public class AlugarVeiculoCommand implements Command {
    private Veiculo veiculo;

    public AlugarVeiculoCommand(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void execute() {
        veiculo.setEstado(new Alugado());
    }
}
