package lab4.database.service.interfaces;


import lab4.database.entity.DotEntity;

import java.util.List;

public interface IDotsService {
    void saveDot(DotEntity dot);
    void clearDots(String username);
    List<DotEntity> getAllDots(String username);
}
