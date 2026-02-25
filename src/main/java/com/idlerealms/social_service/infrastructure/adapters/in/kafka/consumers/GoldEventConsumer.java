package com.idlerealms.social_service.infrastructure.adapters.in.kafka.consumers;

import com.idlerealms.social_service.domain.ports.in.AddGoldToGuildUseCase;
import com.idlerealms.social_service.infrastructure.adapters.in.kafka.dto.PlayerGoldEvent;
import com.idlerealms.social_service.util.IdParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class GoldEventConsumer {

    private final AddGoldToGuildUseCase addGoldToGuildUseCase;

    @KafkaListener(topics = "player-gold-events", groupId = "social-service-group")
    public void consume(PlayerGoldEvent playerGoldEvent) {
        try {
            UUID ownerId = IdParser.toUuid(playerGoldEvent.playerId());
            addGoldToGuildUseCase.execute(ownerId, playerGoldEvent.amount());
        } catch (Exception e) {
            log.error("Error while processing Kafka gold event: {}", e.getMessage(), e);
        }
    }

}