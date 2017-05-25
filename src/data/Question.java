/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.List;

/**
 *
 * @author Phi
 */
public class Question {
    int id;
    String questionContent;
    List<String> answer;
    String rightAnswer;

    public Question(int id, String questionContent, List<String> answer, String rightAnswer) {
        this.id = id;
        this.questionContent = questionContent;
        this.answer = answer;
        this.rightAnswer = rightAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "id=" + id + ", questionContent=" + questionContent + ", answer=" + answer + ", rightAnswer=" + rightAnswer;
    }

    
    
}
