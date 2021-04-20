package br.com.controller;

import br.com.constant.Constant;
import br.com.model.Album;
import br.com.model.Artista;
import br.com.service.AlbumService;
import br.com.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistaService artistaService;

    @PostMapping(Constant.API_ALBUM)
    public void save(@RequestBody Album album){
        Optional<Artista> artista = artistaService.findById(album.getArtista().getId());
        album.setArtista(artista.get());
        albumService.save(album);
    }

    @GetMapping(Constant.API_ALBUM)
    public List<Album> findAll(){
        return albumService.findAll();
    }

    @PutMapping(Constant.API_ALBUM)
    public void update (@RequestBody Album album){
        Optional<Artista> artista = artistaService.findById(album.getArtista().getId());
        album.setArtista(artista.get());
        albumService.save(album);
    }

    @DeleteMapping(Constant.API_ALBUM + "/{id}")
    public void delete(@PathVariable("id") String id){
        albumService.delete(id);
    }

    @GetMapping(Constant.API_ALBUM + "/{id}")
    public Optional<Album> findById(@PathVariable("id") String id){
        return albumService.findById(id);
    }
}
