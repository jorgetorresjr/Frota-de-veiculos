package org.veiculos.repository;

import org.veiculos.model.entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void criar(Veiculo veiculo) {
        veiculos.add(veiculo);
    }


    public void remover(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public Veiculo buscar(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public List<Veiculo> listar() {
        return veiculos;
    }
}
