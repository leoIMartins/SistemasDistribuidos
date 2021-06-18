package leo.service;

import leo.model.VagasOrgao;
import leo.rabbit.VagasOrgaoProducer;
import leo.repository.VagasOrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagasOrgaoService {

    @Autowired
    private VagasOrgaoRepository vagasOrgaoRepository;

    @Autowired
    private VagasOrgaoProducer vagasOrgaoProducer;

    public void sendVagasOrgaoRabbit(VagasOrgao vagasOrgao){
        vagasOrgaoProducer.send(vagasOrgao);
    }

    public void save(VagasOrgao vagasOrgao){
        vagasOrgaoRepository.save(vagasOrgao);
    }

    public List<VagasOrgao> findAll(){
        return vagasOrgaoRepository.findAll();
    }

    public Optional<VagasOrgao> findById(String id){
        return vagasOrgaoRepository.findById(id);
    }

    public void delete(String id){
        vagasOrgaoRepository.deleteById(id);
    }

    public void deleteAll(){
        vagasOrgaoRepository.deleteAll();
    }
}
