import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class NobatBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().isUserMessage()){
            try {
                userHandler(update);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
    public void userHandler(Update update) throws TelegramApiException {
        long chat_id= update.getMessage().getChatId();
        switch (update.getMessage().getText()) {
            case "/menu":
                String message_test="لطفا از بین شیفت ها انتخاب کنید";
                keyboardBuild(chat_id,message_test,"مشاهده شیفت ها","اضافه کردن به شیفت ها",
                        "اصلاح شیفت ها",false);
                break;
            case "مشاهده شیفت ها":

                break;
            case "اضافه کردن به شیفت ها":
                break;
            case "اصلاح شیفت ها":
                break;



        }


    }
    public void keyboardBuild(long chat_id, String message_text, String row1, String row2, String row3,
                              boolean one_time) throws TelegramApiException {
        SendMessage message = new SendMessage() // Create a message object object
                .setChatId(chat_id)
                .setText(message_text);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(row1);
        row.add(row2);
        keyboard.add(row);

        row = new KeyboardRow();
        row.add(row3);
        row.add(row4);
        keyboard.add(row);

        row = new KeyboardRow();
        row.add(row5);
        keyboard.add(row);


        // Set the keyboard to the markup
        keyboardMarkup.setOneTimeKeyboard(one_time);
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        execute(message);

    }

    public void keyboardBuild(long chat_id, String message_text, String row1, String row2, String row3, String row4,
                              String row5, boolean one_time) throws TelegramApiException {
        SendMessage message = new SendMessage() // Create a message object object
                .setChatId(chat_id)
                .setText(message_text);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(row1);
        row.add(row2);
        keyboard.add(row);

        row = new KeyboardRow();
        row.add(row3);
        row.add(row4);
        keyboard.add(row);

        row = new KeyboardRow();
        row.add(row5);
        keyboard.add(row);


        // Set the keyboard to the markup
        keyboardMarkup.setOneTimeKeyboard(one_time);
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);

        execute(message);

    }

    private void messanger(long chat_id, String text) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage()
                .setChatId(chat_id)
                .setText(text);
        execute(sendMessage);

    }

    public String getBotUsername() {
        return "Nobat98_Bot";
    }

    public String getBotToken() {
        return "862157774:AAFWg7zbBUnjVZI1_qUxKX4lx1W-qAQv8EQ";
    }
}
