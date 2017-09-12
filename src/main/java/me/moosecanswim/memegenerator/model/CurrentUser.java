package me.moosecanswim.memegenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS,value="session")
public class CurrentUser {
    private Uzer user;
    public CurrentUser(){
        setUser(new Uzer());
    }


    //**************************getter and setters***********************
    public Uzer getUser() {
        return user;
    }

    public void setUser(Uzer user) {
        this.user = user;
    }
    //**************************overriedes********************************
    @Override
    public String toString(){
        return this.user.getUsername();
    }
}
