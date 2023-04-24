package com.example.hospital.controller.UnRegistred;

import com.example.hospital.converter.Converter;
import com.example.hospital.dto.BlockDTO;
import com.example.hospital.dto.DoctorDTO;
import com.example.hospital.entitites.Block;
import com.example.hospital.entitites.Doctor;
import com.example.hospital.services.BlockService;
import com.example.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlockControllerUn {
    @Autowired
    BlockService service;
    Converter converter = new Converter();

    @GetMapping("/all")
    public Iterable<BlockDTO> getAllBlock() {
        Iterable<Block> blocks = service.findAllBlock();
        List<BlockDTO> blockDTOS = new ArrayList<>();

        for (var el : blocks)
            blockDTOS.add(converter.BlockDTOConv(el));
        return blockDTOS;
    }

    @GetMapping("/{id}")
    public BlockDTO getBlock(@PathVariable Long id) {
        return converter.BlockDTOConv(service.findBlock(id));
    }
}


