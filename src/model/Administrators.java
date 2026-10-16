/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Danils.Silovs
 */
public class Administrators {
    private int id;
    private String lietotajvards, parole, loma;

    public Administrators(int id, String lietotajvards, String parole, String loma) {
        this.id = id;
        this.lietotajvards = lietotajvards;
        this.parole = parole;
        this.loma = loma;
    }

    public int getId() { return id; }
    public String getLietotajvards() { return lietotajvards; }
    public String getParole() { return parole; }
    public String getLoma() { return loma; }
}
