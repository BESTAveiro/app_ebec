package com.example.jmfs1.ebec.messaging;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;
import com.pushraven.Notification;
import com.pushraven.Pushraven;

import java.util.HashMap;

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

    public static void sendMessage(final String sender, final String message, final String topic) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Pushraven.setKey("AAAAAo9oPmQ:APA91bHlUO_JuMwr5uKNQQdx636QGUImEzGbYq6czpYMCCNTpNCUfDHixRXl-vDQdDs_KYtk39TGI8xVGVzHYMa2hTykqmg0SjBvDoGk37wpIQMXBQA464r9yiEHVsI_pt-IOtxlnTUJ");

                HashMap<String, Object> data = new HashMap<String, Object>();
                data.put("From", sender);

                Notification raven = new Notification();
                raven.title(sender)
                        .text(message)
                        .color("#ff0000")
                        .data(data)
                        .to("/topics/"+topic);

                Log.d("Topic", topic);

                Log.d("PushRaven response", Pushraven.push(raven).toString());
            }
        }).start();
    }

}
