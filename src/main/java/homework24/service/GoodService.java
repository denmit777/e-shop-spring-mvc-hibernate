package homework24.service;

import homework24.model.Good;

import java.util.List;

public interface GoodService {

    List<Good> getAll();

    void add(Good good);
}
