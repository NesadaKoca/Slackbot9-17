package nyc.c4q.ramonaharrison;

import com.sun.xml.internal.ws.api.policy.SourceModel;
import nyc.c4q.ramonaharrison.network.Slack;

import static nyc.c4q.ramonaharrison.Names.stringToURL;

public class Main {

    public static void main(String[] args) throws Exception {

        Bot myBot = new Bot();

        // myBot.testApi();

        // myBot.listChannels();

        // myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel
        // myBot.sendMessageToBotsChannel("Hello, world!");

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

        GetLastMessage getLastMessage = new GetLastMessage(); //we create getLastMessage like a reference for the class GetLastMessage
        // myBot.sendMessageToBotsChannel("m");       // we printed out the text "m" to the Bot's channel
        getLastMessage.listMessages(Slack.BOTS_CHANNEL_ID, 10);   // we call the method listMessages and we gave the parameter Slack.BOTS_CHANNEL_ID  that is our Bot's channel location


    }

}