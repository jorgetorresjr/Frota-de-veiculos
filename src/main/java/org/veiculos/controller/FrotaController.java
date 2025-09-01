package org.veiculos.controller;

import org.springframework.web.bind.annotation.*;
import org.veiculos.commands.Command;
import org.veiculos.model.entities.Veiculo;
import org.veiculos.model.observer.NotificationObserver;
import org.veiculos.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class FrotaController {

    private final VeiculoRepository veiculoRepository = new VeiculoRepository();

    @PostMapping
    public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
        veiculo.addObserver(new NotificationObserver("Gerente"));
        veiculo.addObserver(new NotificationObserver("Equipe de vendas"));
        veiculo.addObserver(new NotificationObserver("Equipe de manutenção"));


        veiculoRepository.criar(veiculo);
        return veiculo;
    }

    public void executarAcao(Command command) {
        command.execute();
    }

}
