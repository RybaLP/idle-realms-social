package com.idlerealms.social_service.application.service;

import com.idlerealms.social_service.domain.model.Guild;
import com.idlerealms.social_service.domain.ports.in.AddGoldToGuildUseCase;
import com.idlerealms.social_service.domain.ports.out.GuildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuildService implements AddGoldToGuildUseCase {

    private final GuildRepository guildRepository;

    @Override
    @Transactional
    public void execute(UUID playerId, long amount) {

        Guild guild = guildRepository.findByPlayerId(playerId)
                .orElseThrow(() -> new RuntimeException("Player with provided id is not in that guild"));

        guild.addGold(amount);

        guildRepository.save(guild);
    }
}
