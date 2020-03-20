import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    Random ran = new Random();
    long karthik_time = System.currentTimeMillis();
    long arvin_time = System.currentTimeMillis();


    public static void main(String[] args)
            throws LoginException
    {
        JDA jda = new JDABuilder(args[0]).build();
        System.out.println("Done setting up jda");
        jda.addEventListener(new Main());
        
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)

    {
        

        MessageChannel channel = event.getChannel();
        String Name = event.getChannel().getName();
        String msg = event.getMessage().getContentDisplay().toLowerCase();
        System.out.println(event.getMessage().getContentRaw());
        if(msg.contains("fuck") || (msg.contains("shit"))) {
            event.getMessage().delete().queue();
            return;
        }
        if (!Name.equals("games") && !Name.equals("fresh-and-spicy-memes") && !Name.equals("bots-and-stuff")) {
            return;
        }
        if (event.isFromType(ChannelType.TEXT) && !event.getAuthor().isBot() && !event.getMember().getId().equals("207686242874294272")) {
            if (event.getMessage().getContentDisplay().equals("!dia")) {
                channel.sendMessage("<@!" + event.getAuthor().getId() + ">: \"did I ask?\"").queue();
                event.getMessage().delete().queue();
            }
            else if (event.getMessage().getContentDisplay().equals("!DIA") && !event.getMember().getId().equals("207686242874294272")) {
                channel.sendMessage("<@!" + event.getAuthor().getId() + ">: \"DID I ASK!!?!!?!\"").queue();
                event.getMessage().delete().queue();
            }
            
             else if ((event.getMember().getId().equals("207686242874294272") && ran.nextInt(100) < 25) && (System.currentTimeMillis() - karthik_time) > 30000) {
                channel.sendMessage("did I ask?").queue();
                this.karthik_time = System.currentTimeMillis();
            }
            // else if ((event.getMember().getId().equals("243904796501868555") && ran.nextInt(100) < 150) && (System.currentTimeMillis() - arvin_time) > 30000) {
            //     channel.sendMessage("this person is banned from using powertools").queue();
            //     this.arvin_time = System.currentTimeMillis();
            // }
            else if (ran.nextInt(100) < 5) {
                channel.sendMessage("did I ask?").queue();
            }
            

        }
        // {
        //     System.out.printf("[%s][%s] %#s: %s%n", event.getGuild().getName(),
        //             event.getChannel().getName(), event.getAuthor(), event.getMessage().getContentDisplay());
        // }
        // else
        // {
        //     System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
        // }
    }


}
