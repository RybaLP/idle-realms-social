package com.idlerealms.social_service.infrastructure.adapters.out.persistance;

import com.idlerealms.social_service.domain.model.Guild;
import com.idlerealms.social_service.domain.ports.out.GuildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class SqlGuildAdapter implements GuildRepository {

    private final GuildJpaRepository guildJpaRepository;

    @Override
    public void save(Guild guild) {
        GuildEntity guildEntity = guildJpaRepository.findByOwnerId(guild.getOwnerId())
                .orElse(new GuildEntity());

        guildEntity.setName(guild.getName());
        guildEntity.setGoldVault(guild.getGoldVault());
        guildEntity.setOwnerId(guild.getOwnerId());
        guildEntity.setInstructorLvl(guild.getInstructorLvl());

        guildJpaRepository.save(guildEntity);
    }

    @Override
    public Optional<Guild> findByPlayerId(UUID playerId) {

        return guildJpaRepository.findByOwnerId(playerId)
                .map(entity -> new Guild(
                        entity.getName(),
                        entity.getGoldVault(),
                        entity.getOwnerId(),
                        entity.getInstructorLvl()
                ));
    }

    @Override
    public List<Guild> findAll() {
        return guildJpaRepository.findAll().stream()
                .map(entity -> new Guild(
                        entity.getName(),
                        entity.getGoldVault(),
                        entity.getOwnerId(),
                        entity.getInstructorLvl()
                ))
                .toList();
    }
}