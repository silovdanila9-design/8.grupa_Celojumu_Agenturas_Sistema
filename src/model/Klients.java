/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Danils.Silovs
 */
public class Klients {
    private int id;
    private String vards, uzvards, epasts, lietotajvards, parolesJaucenkods;

    public Klients(int id, String vards, String uzvards, String epasts, String lietotajvards, String parolesJaucenkods) {
        this.id = id;
        this.vards = vards;
        this.uzvards = uzvards;
        this.epasts = epasts;
        this.lietotajvards = lietotajvards;
        this.parolesJaucenkods = parolesJaucenkods;
    }

    public int getId() { return id; }
    public String getVards() { return vards; }
    public String getUzvards() { return uzvards; }
    public String getEpasts() { return epasts; }
    public String getLietotajvards() { return lietotajvards; }
    public String getParolesJaucenkods() { return parolesJaucenkods; }
}
