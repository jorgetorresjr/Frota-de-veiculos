package org.veiculos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.veiculos.commands.*;
import org.veiculos.model.entities.Veiculo;
import org.veiculos.model.observer.NotificationObserver;
import org.veiculos.repository.VeiculoRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/veiculos")
public class FrotaController {

    private final VeiculoRepository veiculoRepository;

    public FrotaController(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @PostMapping
    public ResponseEntity<Veiculo> adicionarVeiculo(@RequestBody Veiculo veiculo) {
        veiculo.addObserver(new NotificationObserver("Gerente"));
        veiculo.addObserver(new NotificationObserver("Equipe de vendas"));
        veiculo.addObserver(new NotificationObserver("Equipe de manutenção"));

        veiculoRepository.criar(veiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        return ResponseEntity.ok(veiculoRepository.listar());
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.buscar(placa);
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping("/{placa}/reservar")
    public ResponseEntity<Veiculo> reservarVeiculo(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.buscar(placa);
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Command reservar = new ReservarVeiculoCommand(veiculo);
        reservar.execute();

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping("/{placa}/manutencao")
    public ResponseEntity<Veiculo> manutencaoVeiculo(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.buscar(placa);
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Command manutencao = new RegistrarManutencaoCommand(veiculo);
        manutencao.execute();

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping("/{placa}/avancar")
    public ResponseEntity<Veiculo> avancar(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.buscar(placa);
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        veiculo.avancarEstado();
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping("/{placa}/devolver")
    public ResponseEntity<Veiculo> devolverVeiculo(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.buscar(placa);
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Command devolver = new DevolverVeiculoCommand(veiculo);
        devolver.execute();

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping("/{placa}/alugar")
    public ResponseEntity<Veiculo> alugarVeiculo(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.buscar(placa);
        if (veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Command alugar = new AlugarVeiculoCommand(veiculo);
        alugar.execute();

        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<String> remover(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.buscar(placa);
        if (veiculo == null || !veiculoRepository.remover(veiculo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado!");
        }

        return ResponseEntity.ok("Veículo com placa " + placa + " removido com sucesso.");
    }

}
