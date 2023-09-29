package za.ac.cput.service;

import za.ac.cput.domain.Programme;

import java.util.List;

public interface IProgrammeService extends IService<Programme, Integer> {
    List<Programme> getAll();
}
