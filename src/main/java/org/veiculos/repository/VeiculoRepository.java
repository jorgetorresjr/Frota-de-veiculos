package org.veiculos.repository;

import org.springframework.stereotype.Repository;
import org.veiculos.model.entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VeiculoRepository {
    private List<Veiculo> veiculos = new ArrayList<>();

    public boolean criar(Veiculo veiculo) {
        if (buscar(veiculo.getPlaca()) != null) {
            return false;
        }
        veiculos.add(veiculo);
        return true;
    }


    public boolean remover(Veiculo veiculo) {
        return veiculos.remove(veiculo);
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
        return new ArrayList<>(veiculos);
    }
}
