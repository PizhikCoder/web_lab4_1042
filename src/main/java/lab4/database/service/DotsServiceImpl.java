package lab4.database.service;


import lab4.database.entity.DotEntity;
import lab4.database.repository.IDotsRepository;
import lab4.database.service.interfaces.IDotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DotsServiceImpl implements IDotsService {
    private final IDotsRepository repository;

    @Autowired
    public DotsServiceImpl(IDotsRepository repository){
        this.repository = repository;
    }

    @Override
    public void saveDot(DotEntity dot) {
        repository.save(dot);
    }
}
