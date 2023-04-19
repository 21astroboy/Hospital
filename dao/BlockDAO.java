package com.example.hospital.dao;

import com.example.hospital.entitites.Block;
import com.example.hospital.entitites.Doctor;
import com.example.hospital.repo.BlocksRepo;

import java.util.Optional;

public class BlockDAO {
    public static BlocksRepo blocksRepo;
    public Optional<Block> getBlock(long id){
        Optional<Block> block = blocksRepo.findById(id);
        return block;
    }
    public Iterable<Block> getAllBlocks(){
        Iterable<Block> blocks = blocksRepo.findAll();
        return blocks;
    }
    public void saveBlock(Block block){
        blocksRepo.save(block);
    }
    public void saveBlock(String title, String address, Long directorId, String phone){
        Block block =new Block(title, address,  phone, directorId);
        blocksRepo.save(block);
    }
    public void deleteBlock(long id){
        blocksRepo.deleteById(id);
    }
    public void deleteBlock(Block block){
        blocksRepo.delete(block);
    }
    public void updateBlock(long id, String title, String address, Long directorId, String phone){
        Block block = blocksRepo.findById(id).orElseThrow();
        if(blocksRepo.existsById(id)){
            block.setAddress(address);
            block.setTitle(title);
            block.setPhone(phone);
            block.setDirectorId(id);
        }
    }
}
