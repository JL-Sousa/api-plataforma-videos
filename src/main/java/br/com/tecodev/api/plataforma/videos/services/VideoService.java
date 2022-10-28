package br.com.tecodev.api.plataforma.videos.services;

import br.com.tecodev.api.plataforma.videos.dto.VideoDto;
import br.com.tecodev.api.plataforma.videos.entities.Video;
import br.com.tecodev.api.plataforma.videos.repository.VideoRepository;
import br.com.tecodev.api.plataforma.videos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repository;

    @Transactional(readOnly = true)
    public List<VideoDto> findAll() {
        List<Video> list = repository.findAll();
        return list.stream().map(x -> new VideoDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VideoDto findById(Long id) {
        Optional<Video> obj = repository.findById(id);
        Video entity = obj.orElseThrow(() -> new ResourceNotFoundException("Não encontrado."));
        return new VideoDto(entity);
    }

    @Transactional
    public VideoDto insert(VideoDto dto) {
        Video entity = new Video();
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setUrl(dto.getUrl());
        entity = repository.save(entity);
        return new VideoDto(entity);
    }

    @Transactional
    public VideoDto update(Long id, VideoDto dto) {
        try {
            Video entity = repository.getReferenceById(id);
            entity.setTitulo(dto.getTitulo());
            entity.setDescricao(dto.getDescricao());
            entity.setUrl(dto.getUrl());
            entity = repository.save(entity);
            return new VideoDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id nao encontrado " + id);
        }

    }
}
