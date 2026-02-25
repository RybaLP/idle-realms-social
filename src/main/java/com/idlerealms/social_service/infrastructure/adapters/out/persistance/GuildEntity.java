package com.idlerealms.social_service.infrastructure.adapters.out.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "guilds")
@Getter
@Setter
@NoArgsConstructor
public class GuildEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private long goldVault;

    private int instructorLvl;

    private UUID ownerId;
}