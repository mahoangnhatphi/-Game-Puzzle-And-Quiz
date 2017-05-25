/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import data.Question;
import data.UserRecord;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phi
 */
public class QuizAppConnection {
    
    protected static Connection connection;
    public static String username;
    
    
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databasename=QuizApp;user=sa;password=Phi";
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
        }
        
    }
    
    public static Map<Integer, Question> getQuestion() {
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                String sql = "SELECT * FROM Question";
                ResultSet rs = st.executeQuery(sql);
                Map<Integer, Question> result = new HashMap<>();
                int index = 0;
                while (rs.next()) {
                    List<String> answer = new ArrayList<>();
                    for (int i = 3; i < 8; i++) {
                        if (rs.getNString(i) != null) {
                            answer.add(rs.getNString(i));
                        }
                    }
                    int id = rs.getInt(1);
                    String questionContent = rs.getNString("QuestionContent");
                    String rightAnswer = rs.getNString("RightAnswer");
                    result.put(id, new Question(id, questionContent, answer, rightAnswer));
                }
                return result;
            }
//            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static boolean checkUser(String userName, char[] password) {
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                String sql = "SELECT * FROM Account WHERE username LIKE '" + userName + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next() == false) {
                    System.out.println("Run here");
                    return false;
                } else {
                    char checkPassword[] = rs.getString("password").trim().toCharArray();
//                    System.out.println(checkPassword + " " + checkPassword.length);
//                    System.out.println(password + " " + password.length);
                    if (Arrays.equals(checkPassword, password)) {
                        username = rs.getString("username");
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public static Vector<UserRecord> getRecord() {
        Vector<UserRecord> userRecords = new Vector<>();
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("EXEC getRecord");
                while (rs.next()) {
                    UserRecord record = new UserRecord(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                    userRecords.add(record);
                }
            }
        } catch (Exception e) {
        }        
        return userRecords;
    }
    
    
    public static void putRecord(int row, int col, int time) {
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                String sql = "EXEC insertRecord '" + username + "'," + row + ", " + col + ", " + time;
                System.out.println(sql);
                System.out.println(st.execute(sql));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean isExistUser(String userName) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Account WHERE username LIKE " + userName);
            return rs.next();
        } catch (Exception e) {
        }
        return false;
    }
    
    public static void insertNewAccount(String userName, String password, String fullName) {
        try {
            Statement st = connection.createStatement();
            String sql = "EXEC insertNewAccount '" + userName + "', '" + password + "', '" + fullName + "';";
            st.execute(sql);
        } catch (Exception e) {
        }
    }
}
