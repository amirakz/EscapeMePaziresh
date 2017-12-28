/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escapemebot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author Amirabbas
 */
public class EscapeMeBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          ApiContextInitializer.init();
                  TelegramBotsApi botsApi = new TelegramBotsApi();
                  
 try {
     EscapeMeIran_bot Amir = new EscapeMeIran_bot();
            botsApi.registerBot(Amir);
            Amir.sentAds();
            System.out.println("Connected");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
}
