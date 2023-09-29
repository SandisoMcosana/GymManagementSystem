package za.ac.cput.service;

import za.ac.cput.domain.Manager;

import java.util.List;

public interface IManagerService extends IService<Manager, Integer>{
    List<Manager> getAll();
}
