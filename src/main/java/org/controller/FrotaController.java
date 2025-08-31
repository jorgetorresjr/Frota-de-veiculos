package org.controller;

import org.model.command.Command;

public class FrotaController {
    public void executarAcao(Command command) {
        command.execute();
    }
}
