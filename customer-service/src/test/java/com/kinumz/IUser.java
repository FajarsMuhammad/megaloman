package com.kinumz;

interface IUser {
    public int getId();
    public void setId(int id);
    public String getEmail();
    public void setEmail(String email);
    public String getPassword();
    public void setPassword(String password);
    public int getIncorrectAttempt();
    public void setIncorrectAttempt(int incorrectAttempt);
    public String getLocation();
    public void setLocation(String location);

}