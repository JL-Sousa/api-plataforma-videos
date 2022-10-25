package br.com.tecodev.api.plataforma.videos.dto;

import br.com.tecodev.api.plataforma.videos.entities.Video;

import java.io.Serial;
import java.io.Serializable;

public class VideoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    public VideoDto() {}

    public VideoDto(Long id, String titulo, String descricao, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    public VideoDto(Video entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
        this.url = entity.getUrl();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
