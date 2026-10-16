/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import dao.CelojumsDAO;
import dao.RezervacijaDAO;
import model.Celojums;
import model.Rezervacija;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 *
 * @author Danils.Silovs
 */
public class MainDashboard extends JFrame {
    private String lietotajvards;
    private JTable tableCelojumi;
    private DefaultTableModel tableModel;
    private CelojumsDAO celojumsDAO;
    private RezervacijaDAO rezervacijaDAO;

    public MainDashboard(String lietotajvards) {
        this.lietotajvards = lietotajvards;
        this.celojumsDAO = new CelojumsDAO();
        this.rezervacijaDAO = new RezervacijaDAO();

        setTitle("Ceļojumu Aģentūra - Pārvaldības Panelis (Lietotājs: " + lietotajvards + ")");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
        ieladetCelojumus();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JLabel lblSveiciens = new JLabel("Laipni lūdzam, " + lietotajvards + "! Izvēlieties ceļojumu rezervācijai:", JLabel.CENTER);
        lblSveiciens.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblSveiciens.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblSveiciens, BorderLayout.NORTH);

        String[] kolonnas = {"ID", "Nosaukums", "Apraksts", "Cena (EUR)"};
        tableModel = new DefaultTableModel(kolonnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableCelojumi = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableCelojumi);
        add(scrollPane, BorderLayout.CENTER);

        JPanel apaksejaisPanelis = new JPanel();
        JButton btnRezervet = new JButton("Rezervēt izvēlēto ceļojumu");
        JButton btnAtsvaidzinat = new JButton("Atsvaidzināt sarakstu");
        JButton btnIziet = new JButton("Izrakstīties");

        btnRezervet.addActionListener(e -> rezervetIzveletoCelojumu());
        btnAtsvaidzinat.addActionListener(e -> ieladetCelojumus());
        btnIziet.addActionListener(e -> {
            dispose();
            new Celojumu_Agenturas_Sistema().setVisible(true);
        });

        apaksejaisPanelis.add(btnRezervet);
        apaksejaisPanelis.add(btnAtsvaidzinat);
        apaksejaisPanelis.add(btnIziet);
        add(apaksejaisPanelis, BorderLayout.SOUTH);
    }

    private void ieladetCelojumus() {
        tableModel.setRowCount(0);
        List<Celojums> saraksts = celojumsDAO.getAllCelojumi();

        for (Celojums c : saraksts) {
            Object[] rinda = {
                c.getId(),
                c.getNosaukums(),
                c.getApraksts(),
                c.getCena()
            };
            tableModel.addRow(rinda);
        }
    }

    private void rezervetIzveletoCelojumu() {
        int selectedRow = tableCelojumi.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Lūdzu, izvēlieties ceļojumu no tabulas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int celojumaId = (int) tableModel.getValueAt(selectedRow, 0);
        String celojumaNosaukums = (String) tableModel.getValueAt(selectedRow, 1);

        int apstiprinajums = JOptionPane.showConfirmDialog(
                this,
                "Vai tiešām vēlaties rezervēt ceļojumu: \"" + celojumaNosaukums + "\"?",
                "Apstiprinājums",
                JOptionPane.YES_NO_OPTION
        );

        if (apstiprinajums == JOptionPane.YES_OPTION) {
            boolean veiksme = rezervacijaDAO.pievienotRezervaciju(new Rezervacija(0, celojumaId, lietotajvards));

            if (veiksme) {
                JOptionPane.showMessageDialog(this, "Ceļojums veiksmīgi rezervēts!", "Informācija", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Neizdevās veikt rezervāciju.", "Kļūda", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
