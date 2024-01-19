package lab4.database.service;


import lab4.database.entity.DotEntity;
import lab4.database.repository.IDotsRepository;
import lab4.database.service.interfaces.IDotsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class DotsServiceImpl implements IDotsService {
    private final IDotsRepository repository;

    @Override
    public synchronized void saveDot(DotEntity dot) {
        repository.save(dot);
    }

    @Override
    public synchronized void clearDots(String username) {
        repository.removeAllByOwnerLogin(username);
    }

    @Override
    public List<DotEntity> getAllDots(String username) {
        return repository.getAllByOwnerLogin(username);
    }
}
