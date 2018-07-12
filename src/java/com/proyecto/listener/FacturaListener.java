/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author DUALPC
 */
public class FacturaListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        System.out.println("Inicio Fin: " + pe.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        System.out.println("Fase Inicio: " + pe.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
