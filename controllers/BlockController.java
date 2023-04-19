package com.example.hospital.controllers;

import com.example.hospital.entitites.Block;
import com.example.hospital.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("block")
public class BlockController {

    @Autowired
    private  static BlockService blockServ = new BlockService();

    @GetMapping("")
    public Iterable<Block> getAll() {
        return blockServ.findAllBlocks();
    }

    @GetMapping("/{id}")
    public Optional<Block> getDoc(@PathVariable long id) {
        return blockServ.findBlock(id);
    }

    @PostMapping("/add")
    public void addDoc(Block block) {
        blockServ.saveBlock(block);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, String title, String address, Long directorId, String phone) {
        blockServ.updateBlock(id, title, address, directorId, phone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        blockServ.deleteBlock(id);
    }
}
