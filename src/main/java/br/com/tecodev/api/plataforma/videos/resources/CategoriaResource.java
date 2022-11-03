package br.com.tecodev.api.plataforma.videos.resources;

import br.com.tecodev.api.plataforma.videos.dto.CategoriaDto;
import br.com.tecodev.api.plataforma.videos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<CategoriaDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
