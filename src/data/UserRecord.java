/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Phi
 */
public class UserRecord {
    String userName;
    String fullname;
    int row;
    int col;
    int time;

    public UserRecord(String userName, String fullname, int row, int col, int time) {
        this.userName = userName;
        this.fullname = fullname;
        this.row = row;
        this.col = col;
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "userName=" + userName + ", fullname=" + fullname + ", row=" + row + ", col=" + col + ", time=" + time;
    }

    
}
