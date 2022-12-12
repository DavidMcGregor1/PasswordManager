package com.passwordmanager.frontend;

public class EntriesVm {

    public EntriesVm(String theTitle, String theUsername, String thePassword, String theNotes ) {
        title = theTitle;
        username = theUsername;
        password = thePassword;
        notes = theNotes;

    }
    public int id;
    public String title;
    public String username;
    public String password;
    public String notes;

}
