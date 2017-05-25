/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import app.MainApp;
import data.Question;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Phi
 */
public class RadioListener implements ActionListener {

    Question question;
    JLabel status;
    static Integer score;
    MainApp mainApp;
    public static boolean isAddScore = true;

    public RadioListener(Question question, JLabel status, int score, MainApp app) {
        this.question = question;
        this.status = status;
        this.score = score;
        this.mainApp = app;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().trim().equalsIgnoreCase(question.getRightAnswer().trim())) {
            status.setText("Right!!!");
            if (isAddScore) {
                mainApp.lock();
                int mainAppScore = mainApp.getScore();
                mainApp.setScore(mainAppScore + score);
                mainApp.setGetScore();
                isAddScore = false;
            }
        } else {
            status.setText("Not Right!!!");
            if (score > 0) {
                score--;
            }
        }
    }

}
