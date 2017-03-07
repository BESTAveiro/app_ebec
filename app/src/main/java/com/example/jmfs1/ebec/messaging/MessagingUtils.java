package com.example.jmfs1.ebec.messaging;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by root on 3/5/17.
 */

public class MessagingUtils {

    public static void subscribeTopic(String team) {

        switch (team) {
            case "mo":
            case "board":
            case "mgmt":
                FirebaseMessaging.getInstance().subscribeToTopic("core_team");
                FirebaseMessaging.getInstance().subscribeToTopic("topic_group");
                break;
            default:
                FirebaseMessaging.getInstance().subscribeToTopic(team);
        }

    }

    public static void sendMessageToTopic(String topic, String title, String message) {

        /*FirebaseMessaging fm = FirebaseMessaging.getInstance();
        fm.send(new RemoteMessage.Builder("10995908196" + "@gcm.googleapis.com")
                .setMessageId(Integer.toString(msgId.incrementAndGet()))
                .addData("my_message", "Hello World")
                .addData("my_action","SAY_HELLO")
                .build());*/

    }

}
