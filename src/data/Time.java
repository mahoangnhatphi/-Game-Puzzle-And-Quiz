/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import javax.swing.JLabel;

/**
 *
 * @author Phi
 */
public class Time implements Runnable{

    private int time;
    private boolean isRun;
    private JLabel jLabel;
    
    public Time() {
        time = 0;
        isRun = true;
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }
    
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isIsRun() {
        return isRun;
    }

    public void setIsRun(boolean isRun) {
        this.isRun = isRun;
    }
    
    @Override
    public void run() {
        while(isRun) {
            try {
                time++;
                jLabel.setText(String.format("%02d:%02d", time / 60, time % 60));
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
    
}
