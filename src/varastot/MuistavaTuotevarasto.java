/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

import java.util.*;

/**
 *
 * @author Teemu
 */
public class MuistavaTuotevarasto extends Tuotevarasto {

    private Muutoshistoria historia = new Muutoshistoria();

    public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkuSaldo) {

        super(tuotenimi, tilavuus);
        super.lisaaVarastoon(alkuSaldo);
        historia.lisaa(alkuSaldo);
    }

    public String historia() {
        return historia.toString();
    }

    public void lisaaVarastoon(double maara) {
        super.lisaaVarastoon(maara);
        historia.lisaa(super.getSaldo());
    }

    public double otaVarastosta(double maara) {
        double otetaan = super.otaVarastosta(maara);
        historia.lisaa(super.getSaldo());
        return otetaan;
    }

    public void tulostaAnalyysi() {
        
        System.out.printf("Tuote: %s\n"
                + "Historia: %s\n"
                + "Suurin tuotemäärä: %.1f\n"
                + "Pienin tuotemäärä: %.1f\n"
                + "Keskiarvo: %.1f\n"
                + "Suurin muutos: %.1f\n"
                + "Varianssi: %.1f", 
                this.getNimi(), historia, historia.maxArvo(),
                historia.minArvo(), historia.keskiarvo(),
                historia.suurinMuutos(), historia.varianssi());
    }
}
