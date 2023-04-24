package com.example.hospital.services;

import com.example.hospital.entitites.Block;
import com.example.hospital.repo.BlocksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    @Autowired
    private  BlocksRepo repo;

    public Block findBlock(Long id) {
        return repo.getById(id);
    }

    public Iterable<Block> findAllBlock() {
        return repo.findAll();
    }

    public void saveBlock(Block block) {
        repo.save(block);
    }

    public void saveBlock(String title, String address, Long directorId, String phone, Integer number) {
        Block block = new Block(title,address,phone,directorId,number);
        repo.save(block);
    }

    public void delete(long id) {

        repo.deleteById(id);
    }

    public void deleteBlock(Block block) {
        repo.delete(block);
    }

    public void updateBlock(long id, String title, String address, Long directorId, String phone,Integer num) {
        Block block = repo.getById(id);
        block.setTitle(title);
        block.setAddress(address);
        block.setPhone(phone);
        block.setDirectorId(directorId);
        block.setNumberOfPlaces(num);
        repo.saveAndFlush(block);
    }
}
