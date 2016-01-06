package org.ifollowyou.hmk.beans;

import org.ifollowyou.hmk.event.LoginEvent;
import org.springframework.context.ApplicationListener;

public class LoginTracker implements ApplicationListener<LoginEvent> {

    @Override
    public void onApplicationEvent(LoginEvent event) {

        System.out.println("\n" + ((Login) event.getSource()).getUsername() + " logged-in @ " + event.getDate() + "\n");
    }
}
