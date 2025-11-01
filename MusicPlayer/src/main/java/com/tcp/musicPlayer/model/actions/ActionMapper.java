package com.tcp.musicPlayer.model.actions;

import java.util.HashMap;
import java.util.Map;

public class ActionMapper {

    private Map<String, Action> actionKeys = new HashMap<>();

    public void assignActionToAKey(String key, Action action) {
        if (!actionKeys.containsKey(key)) {
            actionKeys.put(key, action);
        } else {
            System.out.println("This key has already been mapped!");
        }
    }

    public void updateActionKey(String key, Action action) {
        if (actionKeys.containsKey(key)) {
            actionKeys.put(key, action);
        } else {
            System.out.println("Key not found!");
        }
    }

    public void deleteActionKey(String key) {
        if (actionKeys.containsKey(key)) {
            actionKeys.remove(key);
        } else {
            System.out.println("Key not found!");
        }
    }

    public Action getAction(String key) {

        Action action;

        if (actionKeys.containsKey(key)) {
            action = actionKeys.get(key);
        } else {
            action = new NoOperationAction();
        }

        return action;
    }



}
