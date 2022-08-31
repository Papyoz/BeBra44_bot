package base;

import lombok.SneakyThrows;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;

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
                System.out.println(message.getText().length());

                switch (command) {
                    case "/start":
                        sendMsg.setText("Добрый день " + Username + " !\n");
                        execute(sendMsg);
                        sendMsg.setText("Это BeBra4_bot. Создан по приколу... Однако с помощью бота можно быстро узнавать информацию по курсу валют и ее конвертации.\n\n Если желаешь узнать список команд пропиши /help");
                        execute(sendMsg);
                        break;

                    case "/help":
                        sendMsg.setText("Список доступных команд:\n\n  /currency <Tag>  - Курс валюты 1 относительно валюты 2\n  /guide  - Подсказка к тэгам\n");
                        execute(sendMsg);
                        break;

                    case "/currency":
                        if (message.getText().length()==9){
                            sendMsg.setText("Введите параметр условной единицы(/guide)");
                            execute(sendMsg);
                            break;
                        }
                        String report = new Currencies().get_currency(value[1]);

                        System.out.println(report);
                        sendMsg.setText(report);
                        execute(sendMsg);
                        break;
                    case "/guide":
                        sendMsg.setText(
                                " USD Доллар США\n" +
                                " EUR Евро\n" +
                                " AUD Австралийский доллар\n" +
                                " AZN Азербайджанский манат\n" +
                                " AMD Армянский драм\n" +
                                " BYN Белорусский рубль\n" +
                                " BGN Болгарский лев5\n" +
                                " BRL Бразильский реал\n" +
                                " HUF Венгерский форинт\n" +
                                " KRW Вона Республики Корея\n" +
                                " HKD Гонконгский доллар\n" +
                                " DKK Датская крона\n" +
                                " INR Индийская рупия\n" +
                                " KZT Казахстанский тенге\n" +
                                " CAD Канадский доллар\n" +
                                " KGS Киргизский сом\n" +
                                " CNY Китайский юань\n" +
                                " MDL Молдавский лей\n" +
                                " RON Новый румынский лей\n" +
                                " TMT Новый туркменский манат\n" +
                                " NOK Норвежская крона\n" +
                                " PLN Польский злотый\n" +
                                " XDR СДР (специальные права заимствования)\n" +
                                " SGD Сингапурский доллар\n" +
                                " TJS Таджикский сомони\n" +
                                " TRY Турецкая лира\n" +
                                " UZS Узбекский сум\n" +
                                " UAH Украинская гривна\n" +
                                " GBP Фунт стерлингов Соединенного королевства\n" +
                                " CZK Чешская крона\n" +
                                " SEK Шведская крона\n" +
                                " CHF Швейцарский франк\n" +
                                " ZAR Южноафриканский рэнд\n" +
                                " JPY Японская иена");
                        execute(sendMsg);
                        break;
                }
            }
        }
    }
}
