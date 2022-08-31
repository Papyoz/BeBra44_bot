package base;

import lombok.SneakyThrows;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

public class BeBra44_bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "BeBra4_bot";
    }

    @Override
    public String getBotToken() {
        return "5472971106:AAEQid78UH5Z_x2jbF3g6wzfqy_ibC98xHc";
    }


    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            handleMessage(update.getMessage());
        }
    }

    @SneakyThrows
    public void handleMessage(Message message) throws Exception{
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity = message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (commandEntity.isPresent()) {
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                String[] value = message.getText().split(" ");

                String ID = message.getChatId().toString();
                String Username = message.getFrom().getFirstName().toString();
                SendMessage sendMsg = new SendMessage();
                sendMsg.setChatId(ID);


                switch (command) {
                    case "/start":
                        sendMsg.setText("Добрый день " + Username + " !\n");
                        execute(sendMsg);
                        sendMsg.setText("Это BeBra4_bot. Создан по приколу... Однако с помощью бота можно быстро узнавать информацию по курсу валют и ее конвертации.\n\n Если желаешь узнать список команд пропиши /help");
                        execute(sendMsg);
                        break;

                    case "/help":
                        sendMsg.setText("Список доступных команд:\n\n  /currency <1 вал> <2 вал>    - Курс валюты 1 относительно валюты 2\n  /convert <1 вал> <2 вал> <Сумма в 1 валюте>    - Сумма 1 валюты по курсу 2й\n");
                        execute(sendMsg);
                        break;

                    case "/currency":
                        String report = new Currencies().get_currency(value[1]);

                        System.out.println(report);
                        sendMsg.setText(report);
                        execute(sendMsg);
                        break;

                    case "/convert":

                        break;
                    case "/guide":
                        sendMsg.setText();
                        execute(sendMsg);
                        break;
                }
            }
        }
    }
}