package br.com.tecodev.api.plataforma.videos.resources;

import br.com.tecodev.api.plataforma.videos.dto.VideoDto;
import br.com.tecodev.api.plataforma.videos.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    public ResponseEntity<VideoDto> insert(@Valid @RequestBody VideoDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VideoDto> insert(@PathVariable Long id, @Valid @RequestBody VideoDto dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VideoDto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
