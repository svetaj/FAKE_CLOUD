package com.example.accessingdatarest;

public class MachineNotFoundException extends Exception {
private long machine_id;
public MachineNotFoundException(long machine_id) {
        super(String.format("Machine is not found with id : '%s'", machine_id));
        }
}
