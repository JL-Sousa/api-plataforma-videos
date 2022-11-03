package br.com.tecodev.api.plataforma.videos.dto;

import br.com.tecodev.api.plataforma.videos.entities.Categoria;
import br.com.tecodev.api.plataforma.videos.entities.Video;

import java.io.Serial;
import java.io.Serializable;

public class CategoriaDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private String cor;

    public CategoriaDto() {}

    public CategoriaDto(Long id, String titulo, String cor) {
        this.id = id;
        this.titulo = titulo;
        this.cor = cor;
    }

    public CategoriaDto(Categoria entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.cor = entity.getCor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
