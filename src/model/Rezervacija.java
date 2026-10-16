/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Danils.Silovs
 */
public class Rezervacija {
    private int id, celojumsId;
    private String lietotajvards;

    public Rezervacija(int id, int celojumsId, String lietotajvards) {
        this.id = id;
        this.celojumsId = celojumsId;
        this.lietotajvards = lietotajvards;
    }

    public int getId() { return id; }
    public int getCelojumsId() { return celojumsId; }
    public String getLietotajvards() { return lietotajvards; }
}
