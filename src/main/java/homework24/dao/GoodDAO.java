package homework24.dao;

import homework24.model.Good;

import java.util.List;

public interface GoodDAO {

    List<Good> getAll();

    void update(Good good);

    void delete(Good good);

    void add(Good good);
}
