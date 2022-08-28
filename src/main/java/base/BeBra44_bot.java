package base;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BeBra44_bot extends DefaultAbsSender {

    public BeBra44_bot(DefaultBotOptions options){
        super(options);
    }
    @Override
    public String getBotToken(){
        return "5472971106:AAEQid78UH5Z_x2jbF3g6wzfqy_ibC98xHc";
    }
    public String getBotURL(){
        return "t.me/BeBra4_bot";
    }

    public static void main(String[] args){
        BeBra44_bot bot = new BeBra44_bot(new DefaultBotOptions());
        bot.execute(SendMessage.builder().chatId("5144539738").text("Ku").build());
    }
}
//"5144539738 ku"