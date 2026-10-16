/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Danils.Silovs
 */
public class Maksajums {
    private int id, rezervacijaId;
    private double summa;
    private String statuss;

    public Maksajums(int id, int rezervacijaId, double summa, String statuss) {
        this.id = id;
        this.rezervacijaId = rezervacijaId;
        this.summa = summa;
        this.statuss = statuss;
    }

    public int getId() { return id; }
    public int getRezervacijaId() { return rezervacijaId; }
    public double getSumma() { return summa; }
    public String getStatuss() { return statuss; }
}
