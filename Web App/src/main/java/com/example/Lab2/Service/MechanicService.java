package com.example.Lab2.Service;

import com.example.Lab2.Model.DTOs.MechanicDTO;
import com.example.Lab2.Model.Mechanic;
import com.example.Lab2.Repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MechanicService implements IMechanicService{
    @Autowired private MechanicRepository mechanicRepository;

    @Override
    public Mechanic saveMechanic(Mechanic mechanic) {
        return this.mechanicRepository.save(mechanic);
    }

    @Override
    public List<Mechanic> fetchMechanicList() {
        return this.mechanicRepository.findAll();
    }

    @Override
    public long fetchMechanicCount(){return this.mechanicRepository.count();}

    @Override
    public List<MechanicDTO> fetchMechanicListPaginated(int pageNr){
        long start_id = (pageNr-1) * 10 + 1;
        long max_id = start_id + 10;
        List<MechanicDTO> mechanicDTOS = new ArrayList<>();
        List<Mechanic> mechanicList = new ArrayList<>();
        while(start_id < max_id){
            try{
                Mechanic m = mechanicRepository.findById(start_id).get();
                mechanicList.add(m);
                start_id += 1;
            }
            catch (java.util.NoSuchElementException e){
                start_id += 1;
            }
        }

        for(Mechanic mechanic: mechanicList){
            MechanicDTO mechanicDTO = new MechanicDTO();
            mechanicDTO.setId(mechanic.getMechanicID());
            mechanicDTO.setName(mechanic.getName());
            mechanicDTO.setExperience(mechanic.getExperience());
            mechanicDTO.setAddress(mechanic.getAddress());
            mechanicDTO.setCnp(mechanic.getCnp());
            mechanicDTO.setFavouriteCarBrand(mechanic.getFavouriteCarBrand());
            mechanicDTOS.add(mechanicDTO);
        }
        return mechanicDTOS;
    }

    @Override
    public Mechanic one(Long mechanicID) {
        return this.mechanicRepository.findById(mechanicID).get();
    }

    @Override
    public MechanicDTO oneDTO(Long mechanicID){
        Mechanic mechanic = this.mechanicRepository.findById(mechanicID).get();
        MechanicDTO mechanicDTO = new MechanicDTO();
        mechanicDTO.setId(mechanic.getMechanicID());
        mechanicDTO.setName(mechanic.getName());
        mechanicDTO.setExperience(mechanic.getExperience());
        mechanicDTO.setAddress(mechanic.getAddress());
        mechanicDTO.setCnp(mechanic.getCnp());
        mechanicDTO.setFavouriteCarBrand(mechanic.getFavouriteCarBrand());
        return mechanicDTO;
    }

    @Override
    public Mechanic updateMechanic(Mechanic mechanic, Long mechanicID) {
        Mechanic mechanic1 = this.mechanicRepository.findById(mechanicID).get();
        mechanic1.setName(mechanic.getName());
        mechanic1.setCnp(mechanic.getCnp());
        mechanic1.setAddress(mechanic.getAddress());
        mechanic1.setExperience(mechanic.getExperience());
        mechanic1.setFavouriteCarBrand(mechanic.getFavouriteCarBrand());

        return this.mechanicRepository.save(mechanic1);
    }

    @Override
    public void deleteMechanic(Long mechanicID) {
        this.mechanicRepository.deleteById(mechanicID);
    }
}
