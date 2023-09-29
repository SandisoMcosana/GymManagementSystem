package za.ac.cput.service;

import za.ac.cput.domain.Gym;

import java.util.List;

public interface IGymService extends IService<Gym,Integer>{
    List<Gym> getAll();

}
