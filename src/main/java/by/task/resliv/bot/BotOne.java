package by.task.resliv.bot;

import by.task.resliv.dto.CityDto;
import by.task.resliv.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@AllArgsConstructor
public class BotOne extends TelegramLongPollingBot {

    private final CityService cityService;
    private static final String TOKEN = "1501246178:AAHUipna9klDndrsse6cGTokw8ZlnFcwx3s";
    private static final String USERNAME = "reslivCityBot";

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            String telegramMessage = String.valueOf(update.getMessage().getText());
            CityDto cityDto = cityService.findByCity(telegramMessage);
            String serverMessage = cityDto != null ? cityDto.getRecommendation() : "Простите, я пока ничего не знаю об этом городе";

            try {
                execute(new SendMessage(String.valueOf(chat_id), serverMessage));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
