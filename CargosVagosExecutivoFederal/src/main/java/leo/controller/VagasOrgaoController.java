package leo.controller;

import leo.constant.Constant;
import leo.model.VagasOrgao;
import leo.service.VagasOrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VagasOrgaoController {

    @Autowired
    private VagasOrgaoService vagasOrgaoService;

    @PostMapping(Constant.API_VAGASORGAO)
    public void save(@RequestBody VagasOrgao vagasOrgao){
        vagasOrgao.setVAGAS(vagasOrgao.getAPROVADA() - vagasOrgao.getOCUPADA());
        vagasOrgaoService.sendVagasOrgaoRabbit(vagasOrgao);
    }

    @GetMapping(Constant.API_VAGASORGAO)
    public List<VagasOrgao> findAll(){
        return vagasOrgaoService.findAll();
    }

    @PutMapping(Constant.API_VAGASORGAO)
    public void update (@RequestBody VagasOrgao vagasOrgao){
        vagasOrgaoService.save(vagasOrgao);
    }

    @DeleteMapping(Constant.API_VAGASORGAO + "/{id}")
    public void delete(@PathVariable("id") String id){
        vagasOrgaoService.delete(id);
    }

    @GetMapping(Constant.API_VAGASORGAO + "/{id}")
    @Cacheable("vagas_orgao")
    public Optional<VagasOrgao> findById(@PathVariable("id") String id){
        System.out.println("Find Information... " + id);
        return vagasOrgaoService.findById(id);
    }
}
