package br.com.tecodev.api.plataforma.videos.resources;

import br.com.tecodev.api.plataforma.videos.dto.VideoDto;
import br.com.tecodev.api.plataforma.videos.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/videos")
public class VideoResource {

    @Autowired
    private VideoService service;

    @GetMapping
    public ResponseEntity<List<VideoDto>> findAll() {
        List<VideoDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VideoDto> findById(@PathVariable Long id) {
        VideoDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
