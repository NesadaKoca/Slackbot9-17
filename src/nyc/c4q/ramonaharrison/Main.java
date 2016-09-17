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

        GetLastMeassage obj = new GetLastMeassage();
        myBot.sendMessageToBotsChannel("m");
        obj.listMessages(Slack.BOTS_CHANNEL_ID);


    }

}