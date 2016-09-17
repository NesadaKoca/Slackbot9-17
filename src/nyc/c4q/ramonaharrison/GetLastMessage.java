package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;

import java.util.List;

/**
 * Created by Nesada on 9/17/2016.
 */
public class GetLastMeassage {


    public void listMessages(String channelId) throws  Exception{
        Bot obj = new Bot();
        Names name = new Names();

        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();
            String lastMessage = "";

            for(int i = 0; i < messages.size(); i++) {
                if (i==0) {
                    lastMessage = messages.get(i).getText();
                }
            }

            if (lastMessage.equalsIgnoreCase("f")) {
                obj.sendMessageToBotsChannel("You asked me for 3 random female names! Here there are: \n"+name.randomName("f"));
            }else if(lastMessage.equalsIgnoreCase("m")){
                obj.sendMessageToBotsChannel("You asked me for 3 random male names! Here there are: \n"+name.randomName("m"));
            }

        }
    }
}


