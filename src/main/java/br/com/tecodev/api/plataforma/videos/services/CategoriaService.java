package br.com.tecodev.api.plataforma.videos.services;

import br.com.tecodev.api.plataforma.videos.dto.CategoriaDto;
import br.com.tecodev.api.plataforma.videos.dto.VideoDto;
import br.com.tecodev.api.plataforma.videos.entities.Categoria;
import br.com.tecodev.api.plataforma.videos.entities.Video;
import br.com.tecodev.api.plataforma.videos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<CategoriaDto> findAll() {
        List<Categoria> list = repository.findAll();
        return list.stream().map(x -> new CategoriaDto(x)).collect(Collectors.toList());
    }
}
