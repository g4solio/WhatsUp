/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author mralsi
 */
public class AddPanel extends JPanel {
    public AddPanel(){
        super();
        //Parte di login
        
        JPanel login = new JPanel(new GridLayout(7,2,5,5));
        login.add(new JLabel("Nickname: "));
        JTextField nick = new JTextField(15);
        login.add(nick);
        login.add(new JLabel("Colore preferito"));
        /* Prova finche non prendo il codice del colore*/
        login.add(new JLabel("**Scelta colore**"));
        login.add(new JLabel("IP:"));
        JTextField ip = new JTextField(15);
        login.add(ip);
        ip.setSize(200, 40);
        login.add(new JLabel("Host: "));
        JTextField host = new JTextField(15);
        login.add(host);
        add(login);
        
        JButton go = new JButton("Continua");
        add(go);
        JCheckBox checkBox = new JCheckBox("Dichiaro di aver letto e accettato le condizioni di servizio");
        add(checkBox);
        JLabel condizioni = new JLabel("Leggi qui");
        add(condizioni);
        
        
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog/*C'è troppa luce dentro la*/ stanza = new JDialog();
                JPanel p2 = new JPanel();
                p2.add(new JLabel("Stanze"));
                JTextArea textArea = new JTextArea(20,35);
                
                p2.add(textArea);
                textArea.getLocation();
                textArea.setEditable(false);
                
                
                JButton nuova = new JButton("Crea stanza");
                p2.add(nuova);
                nuova.setLocation(420, 420);
                JButton aggiorna = new JButton("Aggiorna");
                p2.add(aggiorna);
                JButton esci = new JButton("Esci");
                p2.add(esci);
                JButton partecipa = new JButton("Partecipa");
                p2.add(partecipa);
                
                //75%
                nuova.addActionListener(new ActionListener (){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog nuova = new JDialog();
                        JPanel p3 = new JPanel();
                        p3.add(new JLabel("Nome Stanza"));
                        JTextField nome = new JTextField(15);
                        p3.add(nome);
                        p3.add(new JLabel("Password"));
                        JTextField pass = new JTextField(15);
                        p3.add(pass);
                        p3.add(new JLabel("IMPOSTAZIONI"));
                        p3.add(new JLabel("Numero persone massimo: "));
                        JSpinner max = new JSpinner(new SpinnerNumberModel(10,0,254,1));
                        p3.add(max);
                        JButton esci = new JButton("Esci");
                        p3.add(esci);
                        JButton continua = new JButton("Continua");
                        p3.add(continua);
                        
                        esci.addActionListener(new ActionListener (){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                stanza.dispose();
                                }
                            });
                        
                        continua.addActionListener(new ActionListener () {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JDialog chat = new JDialog();
                                JPanel p5 = new JPanel();
                                JLabel stanza = new JLabel("Nome stanza");
                                p5.add(stanza);
                                JLabel nPartecipanti = new JLabel("Numero partecipanti");
                                p5.add(nPartecipanti);
                                JTextArea conversazione = new JTextArea(18,32);
                                p5.add(conversazione);
                                JTextArea utenti = new JTextArea(18,13);
                                p5.add(utenti);
                                JButton esci = new JButton("EXIT");
                                p5.add(esci);
                                esci.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        chat.dispose();
                                        JDialog prova = new JDialog();
                                        prova.add(p2);
                                        prova.setSize(600,500);
                                        prova.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        prova.setVisible(true);
                                    }
                                    
                                });
                                    
                                JTextArea barra = new JTextArea(2,50);
                                p5.add(barra);
                                JButton invio = new JButton("INVIO");
                                p5.add(invio);
                                
                                invio.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                       conversazione.setText(conversazione.getText()+"\n IO: "+barra.getText());
                                       barra.setText("");
                                    }
                                    
                                });
                                
                                
                                
                            nuova.dispose();
                            chat.add(p5);
                            //ricordati di aggiustare
                            chat.setSize(1000,1000);
                            chat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            chat.setVisible(true);
                            }
                            
                        });
                        
                        stanza.dispose();
                        nuova.add(p3);
                        nuova.setSize(600,500);
                        nuova.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        nuova.setVisible(true);
                                            }
                    
                });
                
                aggiorna.addActionListener(new ActionListener (){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                    
                });
                //fine
                esci.addActionListener(new ActionListener (){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        stanza.dispose();
                        
                    }
                    
                });
                //
                partecipa.addActionListener(new ActionListener (){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog entra = new JDialog();
                        JPanel p4 = new JPanel(new GridLayout());
                        
                        p4.add(new JLabel("Welcome!"));
                        p4.add(new JLabel("Password"));
                        JTextField pass = new JTextField(15);
                        p4.add(pass);
                        JButton esci = new JButton("Esci");
                        p4.add(esci);
                        JButton continua = new JButton("Continua");
                        p4.add(continua);
                        
                        
                        
                        esci.addActionListener(new ActionListener (){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            entra.dispose();
                            
                            }
                        });
                        
                        
                        continua.addActionListener(new ActionListener () {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JDialog chat = new JDialog();
                                /*ho copiato ed incollato il codice di quando 
                                crei una stanza, non ho sbatti di oensare come 
                                fare che i due bottoni puntino allo stesso panel*/
                                
                                JPanel p5 = new JPanel();
                                JLabel stanza = new JLabel("Nome stanza");
                                p5.add(stanza);
                                JLabel nPartecipanti = new JLabel("Numero partecipanti");
                                p5.add(nPartecipanti);
                                JTextArea conversazione = new JTextArea(18,32);
                                p5.add(conversazione);
                                JTextArea utenti = new JTextArea(18,13);
                                p5.add(utenti);
                                JButton esci = new JButton("EXIT");
                                p5.add(esci);
                                esci.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        chat.dispose();
                                        JDialog prova = new JDialog();
                                        prova.add(p2);
                                        prova.setSize(600,500);
                                        prova.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        prova.setVisible(true);
                                    }
                                    
                                });
                                    
                                JTextArea barra = new JTextArea(2,50);
                                p5.add(barra);
                                JButton invio = new JButton("INVIO");
                                p5.add(invio);
                                
                                invio.addActionListener(new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                       conversazione.setText(conversazione.getText()+"\n IO: "+barra.getText());
                                       barra.setText("");
                                    }
                                    
                                });
                                
                                
                                
                            entra.dispose();
                            chat.add(p5);
                            //ricordati di aggiustare
                            chat.setSize(1000,1000);
                            chat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            chat.setVisible(true);
                            }
                            
                        
                            
                        });
                        
                        stanza.dispose();
                        entra.add(p4);
                        entra.setSize(600,500);
                        entra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        entra.setVisible(true);
                        
                        
                        
                    }
                    
                });
                
                stanza.add(p2);
                stanza.setSize(600,500);
                stanza.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                stanza.setVisible(true);
                
            }
        });
    }
    
    public void setNomeStanza(String nome){
        
    }
    
    public String getNomeStanza(){
        return null;
    }
}
