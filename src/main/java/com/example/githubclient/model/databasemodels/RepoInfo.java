package com.example.githubclient.model.databasemodels;

public class RepoInfo {
    private String login;
    private String name;
    private boolean isChecked;


    public RepoInfo(String login, String name, boolean isChecked) {
        this.login = login;
        this.name = name;
        this.isChecked = isChecked;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
