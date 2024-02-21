package dk.easv.logic;

import dk.easv.dataaccess.DataAccessManager;
import dk.easv.entities.*;
import java.util.*;

public class LogicManager {

    DataAccessManager dataMgr = new DataAccessManager();

    public void reloadAllDataFromStorage(){

        dataMgr.updateCacheFromDisk();
    }

    public Collection<User> getAllUsers() {
        return dataMgr.getAllUsers().values();
    }


    public User getUser(String userName) {
        try {
            return dataMgr.getAllUsers().values().stream().filter(u -> u.getName().equals(userName)).findFirst().get();
        }
        catch (NoSuchElementException e){
            return null;
        }
    }
}
