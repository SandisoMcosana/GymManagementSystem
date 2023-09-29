package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;
@Service
public class AddressService implements IAddressService{
    private AddressRepository repository;

    @Autowired
    private AddressService(AddressRepository addressRepository){
        this.repository = addressRepository;
    }



    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }


    @Override
    public Address read(Integer integer) {
        return this.repository.findById(integer).orElse(null);

    }

    @Override
    public Address update(Address address) {
        return this.repository.existsById(address.getAddressId()) ? this.repository.save(address) : null;
    }

    @Override
    public boolean delete(Integer integer) {
        if (this.repository.existsById(integer)) {
            this.repository.deleteById(integer);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> getAll() {
        return this.repository.findAll();
    }
    }


