package com.kinumz;

import java.util.Arrays;
import java.util.List;

public class ApplicationAuthState implements IApplicationAuthState{

    private List<String> allowedLocations = Arrays.asList("Location1", "Location2");


    @Override
    public List<IUser> getRegisteredUsers() {
        return null;
    }

    @Override
    public void setRegisteredUsers(List<IUser> registeredUsers) {

    }

    @Override
    public List<IUser> getUsersLoggedIn() {
        return null;
    }

    @Override
    public void setUsersLoggedIn(List<IUser> usersLoggedIn) {

    }

    @Override
    public List<String> getAllowedLocations() {
        return null;
    }

    @Override
    public void setAllowedLocations(List<String> allowedLocations) {

    }

    @Override
    public String Register(IUser user) {
        return null;
    }

    @Override
    public String Login(IUser user) {
        return null;
    }

    @Override
    public String Logout(IUser user) {
        return null;
    }
}
