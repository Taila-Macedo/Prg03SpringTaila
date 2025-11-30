package br.com.ifba.curso.service;

import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CursoService implements CursoIService {
    
    // Uso de @RequiredArgsConstructor para injeção de dependência via construtor
    private final CursoRepository cursoRepository;
    
    // Adicionado Logger para registrar operações do serviço
    private static final Logger log = LoggerFactory.getLogger(CursoService.class);

    @Override
    public List<Curso> findAll() throws RuntimeException {
        log.info("Listando cursos.");
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

        // Log informando operação de salvamento
        log.info("Salvando o objeto curso.");
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

        log.info("Deletando o objeto curso.");
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

        log.info("Atualizando o objeto curso.");
        cursoRepository.delete(curso);
    }

    @Override
    public Curso findById(Long id) throws RuntimeException {
        log.info("Buscando por ID o objeto curso.");
        return cursoRepository.findById(id).orElse(null);

    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException {
        log.info("Cuscando por nome o objeto curso");
        return cursoRepository.findByNome(nome);
    }
}
