package com.example.hospital.services;

import com.example.hospital.dao.BlockDAO;
import com.example.hospital.entitites.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlockService {
    @Autowired
    private static BlockDAO blockDAO = new BlockDAO();

    public Optional<Block> findBlock(Long id) {
        return blockDAO.getBlock(id);
    }

    public Iterable<Block> findAllDoc() {
        return blockDAO.getAllBlocks();
    }

    public void saveBlock(Block block) {
        blockDAO.saveBlock(block);
    }

    public void saveBlock(String title, String address, Long directorId, String phone) {
        blockDAO.saveBlock(title, address, directorId, phone);
    }

    public void delete(long id) {

        blockDAO.deleteBlock(id);
    }

    public void deleteBlock(Block block) {
        blockDAO.deleteBlock(block);
    }

    public void updateDoc(long id, String title, String address, Long directorId, String phone) {
        blockDAO.updateBlock(id, title, address, directorId, phone);
    }
}
