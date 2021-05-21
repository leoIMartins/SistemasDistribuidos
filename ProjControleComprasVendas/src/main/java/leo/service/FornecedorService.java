package leo.service;

import leo.model.Fornecedor;
import leo.rabbit.FornecedorProducer;
import leo.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorProducer fornecedorProducer;

    public void sendFornecedorRabbit(Fornecedor fornecedor){
        fornecedorProducer.send(fornecedor);
    }

    public void save(Fornecedor fornecedor){
        fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll (){
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(String id){
        return fornecedorRepository.findById(id);
    }

    public void delete(String id){
        fornecedorRepository.deleteById(id);
    }

    public void deleteAll(){
        fornecedorRepository.deleteAll();
    }
}
