package ru.quantick.videoreplacebot.configuration

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.api.botactions.setWebhook
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.quantick.videoreplacebot.implementation.SpringClassManager

@Configuration
class TelegramBotConfiguration(
    @Value("\${app.telegram.token}") val token: String,
    @Value("\${app.telegram.name}") val name: String,
    val springClassManager: SpringClassManager
) {
    @Bean
    fun createBot(): TelegramBot {
        val bot = TelegramBot(
            token
        )
        {
            classManager = springClassManager
        }

        return bot
    }

    companion object : KLogging()
}
