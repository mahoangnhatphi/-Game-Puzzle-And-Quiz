/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import app.Puzzle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Phi
 */
public class ButtonListener implements ActionListener {

    private int i;
    private int j;
    private JButton a[][];
    private Puzzle frame;

    public ButtonListener(int i, int j, JButton[][] a, Puzzle frame) {
        this.i = i;
        this.j = j;
        this.a = a;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.getTurn() == 0) {
            JOptionPane.showMessageDialog(null, "You have not turn to move puzzle. Please answer the questions to get score!!!");
            return;
        }
        JButton pre = frame.getPreButton();
        if (pre == null) {
            frame.setPreButton(a[i][j]);
            frame.getPreButton().setBackground(Color.BLUE);
        } else {
            if (a[i][j] != null && isValidMove(i, j) && (pre.getText().equalsIgnoreCase("") == true || a[i][j].getText().equalsIgnoreCase("") == true)) {
                String temp = pre.getText();
                pre.setText(a[i][j].getText());
                a[i][j].setText(temp);
                frame.setTurn(frame.getTurn() - 1);
                frame.setTxtTurn();
            }
            frame.resetPreButton();
        }
        if (frame.isWinner()) frame.congrugationWinner();
    }
    
    private boolean isValidMove(int x, int y) {
        int preX = -1, preY = -1;
        for (int k = 0; k < a.length; k++) {
            for (int l = 0; l < a[0].length; l++) {
                if (a[k][l] == frame.getPreButton()) {
                    preX = k;
                    preY = l;
                    break;
                }
            }
            if (preX != -1 && preY != -1) break;
        }
        return Math.abs(preX - x) + Math.abs(preY - y) == 1;
    }

}
