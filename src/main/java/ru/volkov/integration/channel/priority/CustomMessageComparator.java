package ru.volkov.integration.channel.priority;

import org.springframework.messaging.Message;

import java.util.Comparator;

public class CustomMessageComparator implements Comparator<Message<String>> {

    @Override
    public int compare(Message<String> message1, Message<String> message2) {
        String payload1 = message1.getPayload();
        boolean isPayload1Even = Integer.valueOf(payload1.substring(payload1.length() - 1)) % 2 == 0;

        String payload2 = message2.getPayload();
        boolean isPayload2Even = Integer.valueOf(payload2.substring(payload2.length() - 1)) % 2 == 0;

        if ((isPayload1Even && isPayload2Even) || (!isPayload1Even && !isPayload2Even)) {
            return 0;
        } else if (isPayload1Even) {
            return -1;
        } else {
            return 1;
        }
    }
}
