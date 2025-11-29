package br.com.ifba.curso.service;

import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CursoService implements CursoIService {
    
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() throws RuntimeException {
        return cursoRepository.findAll();
    }

    @Override
    public Curso save(Curso curso) throws RuntimeException {
        if (curso == null) {
            throw new RuntimeException("Curso informado não existe.");
        }

        // ID deve ser null ao salvar → gerado pelo banco via @GeneratedValue
        if (curso.getId() != null) {
            throw new RuntimeException("Para salvar um novo curso, o ID deve ser null.");
        }

        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) throws RuntimeException {
        if (curso == null) {
            throw new RuntimeException("Dados do curso não preenchidos.");
        }

        if (curso.getId() == null) {
            throw new RuntimeException("Não é possível atualizar: curso sem ID.");
        }

        return cursoRepository.save(curso);
        
        
    }

    @Override
    public void delete(Curso curso) throws RuntimeException {
        if (curso == null) {
            throw new RuntimeException("Curso informado não existe.");
        }

        if (curso.getId() == null) {
            throw new RuntimeException("Curso não existe no banco de dados.");
        }

        cursoRepository.delete(curso);
    }

    @Override
    public Curso findById(Long id) throws RuntimeException {
        return cursoRepository.findById(id).orElse(null);

    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {
        return cursoRepository.findByNome(nome);
    }
}
