package com.idlerealms.social_service.infrastructure.adapters.in.rest;

import com.idlerealms.social_service.domain.ports.in.AddGoldToGuildUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/guilds")
@RequiredArgsConstructor
public class GuildController {

    private final AddGoldToGuildUseCase addGoldToGuildUseCase;

    @PostMapping("/add-gold")
    public ResponseEntity<Void> addGold (@RequestParam UUID playerId, @RequestParam long amount) {
        addGoldToGuildUseCase.execute(playerId,amount);
        return ResponseEntity.ok().build();
    }


}
