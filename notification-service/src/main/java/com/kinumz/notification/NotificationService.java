package com.kinumz.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationCustomerConsumer customerConsumer;

    public void send() {


    }

}
