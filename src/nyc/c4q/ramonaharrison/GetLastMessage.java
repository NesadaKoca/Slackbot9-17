package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;

import java.util.List;

/**
 * Created by Nesada on 9/17/2016.
 */
public class GetLastMessage {


    public void listMessages(String channelId, int sizeNames) throws  Exception{
        Bot bot = new Bot(); //object bot like a reference for the class Bot
        Names name = new Names(); // names is reference for the class Name
        name.numNames = sizeNames;

        //========= take the first 100 messages in the bot channel ==========
        ListMessagesResponse listMessagesResponse1 = Slack.listMessages(channelId);

        while (listMessagesResponse1.isOk()) {

            ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

            List<Message> messages = listMessagesResponse.getMessages();
            String lastMessage = "";
            // ========= take the last message in the bot channel =========
            for(int i = 0; i < messages.size(); i++) {
                if (i==0) {
                    lastMessage = messages.get(i).getText();
                }
            }
            //===============================================================
            if (lastMessage.equalsIgnoreCase("f")) { // check if the last message is "f"
                //we call this method form the class Names: name.randomName("f") and we get in return a String with 3 random female names
                bot.sendMessageToBotsChannel("You asked me for " + name.numNames +" random female names! Here there are: \n"+name.randomName("f"));
            }else if(lastMessage.equalsIgnoreCase("m")){
                //we call this method form the class Names: name.randomName("f") and we get in return a String with 3 random male names
                bot.sendMessageToBotsChannel("You asked me for " + name.numNames + " random male names! Here there are: \n"+name.randomName("m"));
            }

        }
    }
}


