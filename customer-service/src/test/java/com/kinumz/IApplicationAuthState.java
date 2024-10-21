package com.kinumz;

import java.util.List;

interface IApplicationAuthState {
    public List<IUser> getRegisteredUsers();
    public void setRegisteredUsers(List<IUser> registeredUsers);
    public List<IUser> getUsersLoggedIn();
    public void setUsersLoggedIn(List<IUser> usersLoggedIn);
    public List<String> getAllowedLocations();
    public void setAllowedLocations(List<String> allowedLocations);
    public String Register(IUser user);
    public String Login(IUser user);
    public String Logout(IUser user);
}