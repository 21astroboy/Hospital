package com.example.hospital.controller.Admin;

import com.example.hospital.entitites.Block;
import com.example.hospital.services.BlockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/blocks")
public class BlockController {
    @Autowired
    BlockService service;

    @GetMapping("/all")
    public Iterable<Block> getAllBlock() {
        return service.findAllBlock();
    }

    @GetMapping("/{id}")
    public Block getBlock(@PathVariable Long id) {
        return service.findBlock(id);
    }

    @PostMapping("/add")
    public void saveDoc(Block block) {
        service.saveBlock(block);
    }

    @PutMapping("/{id}/edit")
    public void update(
            @PathVariable Long id,
            String title,
            String address,
            @Valid String phone,
            Long directorId,
            Integer numberOfPlaces
    ) {
        service.updateBlock(id, title, address, directorId, phone, numberOfPlaces);
    }

    @DeleteMapping("/{id}/remove")

    public void delete(@PathVariable Long id) {
        service.deleteBlock(service.findBlock(id));
    }
}
