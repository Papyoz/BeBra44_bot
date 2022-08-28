package base;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.bots.DefaultAbsSender;

import java.util.logging.Level;

public class BeBra44_bot extends TelegramLongPollingBot {
    public BeBra44_bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public void onUpdateReceived (Update update) {
    }
    @Override
    public String getBotUsername() {
        return "Bebra4_bot";
    }

    @Override
    public String getBotToken() {
        return "5472971106:AAEQid78UH5Z_x2jbF3g6wzfqy_ibC98xHc";
    }


    public void BOT (Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}