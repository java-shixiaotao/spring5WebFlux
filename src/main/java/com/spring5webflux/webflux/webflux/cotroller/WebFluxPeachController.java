package com.spring5webflux.webflux.webflux.cotroller;

import com.spring5webflux.webflux.webflux.entity.WebFluxPeach;
import com.spring5webflux.webflux.webflux.service.WebFluxPeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxPeachController {

    @Autowired
    private WebFluxPeachService webFluxPeachService;

    @GetMapping("/peahc/{id}")
    public Mono<WebFluxPeach> getById(@PathVariable Integer id){
        return webFluxPeachService.getById(id);
    }
    @GetMapping("/peachs")
    public Flux<WebFluxPeach> getPeachs(){
        return webFluxPeachService.getPeachs();
    }

    @PostMapping("/save")
    public Mono<Void> savePeach(@RequestBody WebFluxPeach webFluxPeach){
        Mono<WebFluxPeach> peachMono = Mono.just(webFluxPeach);
        return webFluxPeachService.savePeach(peachMono);
    }
}




