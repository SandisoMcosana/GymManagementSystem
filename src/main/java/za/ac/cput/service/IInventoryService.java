package za.ac.cput.service;

import za.ac.cput.domain.Inventory;

import java.util.List;

public interface IInventoryService extends IService<Inventory,Integer> {
    List<Inventory> getAll();
}