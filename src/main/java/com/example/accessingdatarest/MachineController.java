
package com.example.accessingdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class MachineController {

@Autowired
    MachineRepository machineRepository;

// Get All Machines
    @GetMapping("/machines")
    public List<Machine> getAllMachine() {
        return machineRepository.findAll();
    }

// Create a new Machine
    @PostMapping("/machines")
    public Machine createMachine(@RequestBody Machine machine) {
        return machineRepository.save(machine);
    }

// Get a Single Machine
    @GetMapping("/machines/{id}")
    public Machine getMachineById(@PathVariable(value = "id") Long id) throws MachineNotFoundException {
        return machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException(id));
    }

// Update a Machine
    @PutMapping("/machines/{id}")
    public Machine updateMachine(@PathVariable(value = "id") Long id,
                           @RequestBody Machine bookDetails) throws MachineNotFoundException {

        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException(id));

        book.setBook_name(bookDetails.getBook_name());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setIsbn(bookDetails.getIsbn());

        Machine updatedMachine = machineRepository.save(machine);

        return updatedMachine;
    }

// Delete a Note
    @DeleteMapping("/machines/{id}")
    public ResponseEntity<?> deleteMAchine(@PathVariable(value = "id") Long id) throws MachineNotFoundException {
        Machine machine = machineRepository.findById(id)
                .orElseThrow(() -> new MachineNotFoundException(machineId));

        machineRepository.delete(machine);

        return ResponseEntity.ok().build();
    }
}
