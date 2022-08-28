package base;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;

public class BeBra44_bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Bebra4_bot";
    }
    @Override
    public String getBotToken() {
        return "5472971106:AAEQid78UH5Z_x2jbF3g6wzfqy_ibC98xHc";
    }


    @Override
    public void onUpdateReceived (Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();

            String command = update.getMessage().getText().toString();

            String ID = update.getMessage().getChatId().toString();
            String Username = update.getMessage().getFrom().getFirstName().toString();

            switch (command) {
                case "/start":
                    message.setChatId(ID);
                    message.setText("Добрый день " + Username + " !\n");
                    try {
                        execute(message);
                    } catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                    message.setText("Это BeBra4_bot. Создан по приколу... Однако с помощью бота можно быстро узнавать информацию по курсу валют и ее конвертации.\n\n Если желаешь узнать список команд пропиши /help");
                    try {
                        execute(message);
                    } catch (TelegramApiException e){
                        e.printStackTrace();
                    }
            }
        }
    }
}