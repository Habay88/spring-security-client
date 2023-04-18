package com.ms4.client.event.listener;

import com.ms4.client.entity.User;
import com.ms4.client.event.RegistrationCompleteEvent;
import com.ms4.client.service.EmailService;
import com.ms4.client.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

import javax.mail.MessagingException;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements
        ApplicationListener<RegistrationCompleteEvent> {
//	private static final String CONFIRMATION_URL = "http://localhost:8085/url";
	@Autowired
	private  EmailService emailService;
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the Verification Token for the User with Link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);
        //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "api/vl/verifyRegistration?token="
                        + token;

        //sendVerificationEmail()
        try {
			emailService.send(user.getEmail(),
					user.getFirstName().concat(user.getLastName()),null,
					String.format(url, user));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        log.info("Click the link to verify your account: {}",
                url);
    }
}
