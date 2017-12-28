/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapemebot;

import static java.lang.Math.toIntExact;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
/////////////////////////////////////////Amasdasd
/**
 *
 * @author Amirabbas
 */
public class EscapeMeIran_bot extends TelegramLongPollingBot {
 
    @Override
    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String user_first_name = update.getMessage().getChat().getFirstName();
            String user_last_name = update.getMessage().getChat().getLastName();
            String user_username = update.getMessage().getChat().getUserName();
            long user_id = update.getMessage().getChat().getId();
            log(user_first_name, user_last_name, Long.toString(user_id), message_text, "");

            if (update.getMessage().getText().equals("/start")) {

                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("You send /start");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("Tesla \n").setCallbackData("Tesla"));
                rowInline.add(new InlineKeyboardButton().setText("Haber").setCallbackData("Haber"));
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }

        } else if (update.hasCallbackQuery()) {
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            if (call_data.equals("Tesla")) {
                           String an  = "Official EscapeMe Bot For User Registarion" ;
                EditMessageText change = new EditMessageText().setChatId(chat_id).setMessageId(toIntExact(message_id)).setText(an);
                        
           
                String answer = "Tesla Time Sheet : ------";
                SendMessage new_message = new SendMessage()
                        .setChatId(chat_id)
                        .setText(answer);
          try {
                      execute(change);
                    execute(new_message);
                  
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
//
//            String user_first_name = update.getMessage().getChat().getFirstName();
//            String user_last_name = update.getMessage().getChat().getLastName();
//            String user_username = update.getMessage().getChat().getUserName();
//            long user_id = update.getMessage().getChat().getId();
//            String message_text = update.getMessage().getText();
//            long chat_id = update.getMessage().getChatId();
//
//            SendMessage message = new SendMessage() // Create a message object object
//                    .setChatId(chat_id)
//                    .setText("به بات <اسکیپ می‌> خوش آمدید");
//            String answer = message.getText();
//            log(user_first_name, user_last_name, Long.toString(user_id), message_text, answer);
//
//            try {
//                execute(message); // Sending our message object to user
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void log(String first_name, String last_name, String user_id, String txt, String bot_answer) {
        System.out.println("\n ----------------------------");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + ") \n Text - " + txt);
        System.out.println("Bot answer: \n Text - " + bot_answer);
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "EscapeMeIran_bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "509543805:AAFV20T0CMmLmyXIUNzRFRVrmexS4XxrgiE";
    }

    public void sentAds() {
                                SendMessage new_message = new SendMessage()
                        .setChatId("236439790")
                        .setText("offer/Tablighat :"
                                + "http://instagram.com/escapeme.ir");
          try {
                      
                    execute(new_message);
                  
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

    }

}
