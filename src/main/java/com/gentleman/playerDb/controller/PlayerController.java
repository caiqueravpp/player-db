package com.gentleman.playerDb.controller;

import com.gentleman.playerDb.model.Player;
import com.gentleman.playerDb.repository.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @PostMapping
    public ResponseEntity<Void>postPlayer (@RequestBody Player playerModel, UriComponentsBuilder uriPlayer){
        Player playerSaved = PlayerRepository.save(playerModel);

        URI uriResponse =uriPlayer.path("/player/{id}").buildAndExpand(playerSaved.getID()).toUri();
        return ResponseEntity.created(uriResponse).build();
    }
}
