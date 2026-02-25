package com.idlerealms.social_service.infrastructure.adapters.in.kafka.dto;

public record PlayerGoldEvent(
   String playerId, long amount
){}