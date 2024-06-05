package com.fiap.app.app.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fiap.app.app.models.Drone;
import com.fiap.app.app.models.Garbage;
import com.fiap.app.app.repositories.DroneRepository;
import com.fiap.app.app.repositories.GarbageRepository;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private GarbageRepository garbageRepository;

    @Override
    public void run(String... args) throws Exception {
        Drone drone1= new Drone();
        drone1.setDroneId(1L);
        drone1.setType("Alpha");
        drone1.setLocation("Atlantic Ocean");

        Drone drone2= new Drone();
        drone2.setDroneId(2L);
        drone2.setType("Alpha");
        drone2.setLocation("Pacific Ocean");

        Drone drone3= new Drone();
        drone3.setDroneId(3L);
        drone3.setType("Gamma");
        drone3.setLocation("Atlantic Ocean");

        Drone drone4= new Drone();
        drone4.setDroneId(4L);
        drone4.setType("Beta");
        drone4.setLocation("Indian Ocean");

        Drone drone5 = new Drone();
        drone5.setDroneId(5L);
        drone5.setType("Gamma");
        drone5.setLocation("Arctic Ocean");

        Drone drone6 = new Drone();
        drone6.setDroneId(6L);
        drone6.setType("Beta");
        drone6.setLocation("Southern Ocean");

        Drone drone7 = new Drone();
        drone7.setDroneId(7L);
        drone7.setType("Delta");
        drone7.setLocation("Mediterranean Sea");

        Drone drone8 = new Drone();
        drone8.setDroneId(8L);
        drone8.setType("Alpha");
        drone8.setLocation("Caribbean Sea");

        Drone drone9 = new Drone();
        drone9.setDroneId(9L);
        drone9.setType("Alpha");
        drone9.setLocation("Baltic Sea");

        Drone drone10 = new Drone();
        drone10.setDroneId(10L);
        drone10.setType("Beta");
        drone10.setLocation("Black Sea");

        Garbage garbage1 = new Garbage();
        garbage1.setLatitude(32.3078);
        garbage1.setLongitude(64.7505);
        garbage1.setDepth(5.000);
        garbage1.setDate(LocalDate.parse("2023-01-01"));
        garbage1.setDrone(drone1);

        Garbage garbage2 = new Garbage();
        garbage2.setLatitude(19.8968);
        garbage2.setLongitude(155.5828);
        garbage2.setDepth(9.800);
        garbage2.setDate(LocalDate.parse("2023-01-15"));
        garbage2.setDrone(drone2); 

        Garbage garbage3 = new Garbage();
        garbage3.setLatitude(-20.0);
        garbage3.setLongitude(-30.0);
        garbage3.setDepth(5.000);
        garbage3.setDate(LocalDate.parse("2023-02-01"));
        garbage3.setDrone(drone1);

        Garbage garbage4 = new Garbage();
        garbage4.setLatitude(3.2028);
        garbage4.setLongitude(73.2207);
        garbage4.setDepth(3.900);
        garbage4.setDate(LocalDate.parse("2023-02-10"));
        garbage4.setDrone(drone4);

        Garbage garbage5 = new Garbage();
        garbage5.setLatitude(-18.2871);
        garbage5.setLongitude(147.6992);
        garbage5.setDepth(35.000);
        garbage5.setDate(LocalDate.parse("2023-02-20"));
        garbage5.setDrone(drone2);

        Garbage garbage6 = new Garbage();
        garbage6.setLatitude(11.344);
        garbage6.setLongitude(142.199);
        garbage6.setDepth(10.994);
        garbage6.setDate(LocalDate.parse("2023-03-05"));
        garbage6.setDrone(drone3);

        Garbage garbage7 = new Garbage();
        garbage7.setLatitude(-3.2028);
        garbage7.setLongitude(73.2207);
        garbage7.setDepth(25.000);
        garbage7.setDate(LocalDate.parse("2023-03-20"));
        garbage7.setDrone(drone3); 

        Garbage garbage8 = new Garbage();
        garbage8.setLatitude(71.4154);
        garbage8.setLongitude(179.1686);
        garbage8.setDepth(1000.000); 
        garbage8.setDate(LocalDate.parse("2023-04-10"));
        garbage8.setDrone(drone4);

        Garbage garbage9 = new Garbage();
        garbage9.setLatitude(-13.1631);
        garbage9.setLongitude(-72.545);
        garbage9.setDepth(50.000);
        garbage9.setDate(LocalDate.parse("2023-04-15"));
        garbage9.setDrone(drone5);

        Garbage garbage10 = new Garbage();
        garbage10.setLatitude(37.7749);
        garbage10.setLongitude(-122.4194);
        garbage10.setDepth(15.000);
        garbage10.setDate(LocalDate.parse("2023-05-01"));
        garbage10.setDrone(drone6);

        Garbage garbage11 = new Garbage();
        garbage11.setLatitude(55.7558);
        garbage11.setLongitude(37.6176);
        garbage11.setDepth(5.500);
        garbage11.setDate(LocalDate.parse("2023-05-10"));
        garbage11.setDrone(drone7);

        Garbage garbage12 = new Garbage();
        garbage12.setLatitude(34.0522);
        garbage12.setLongitude(-118.2437);
        garbage12.setDepth(20.000);
        garbage12.setDate(LocalDate.parse("2023-05-20"));
        garbage12.setDrone(drone8);

        Garbage garbage13 = new Garbage();
        garbage13.setLatitude(35.6895);
        garbage13.setLongitude(139.6917);
        garbage13.setDepth(7.800);
        garbage13.setDate(LocalDate.parse("2023-06-01"));
        garbage13.setDrone(drone9);

        Garbage garbage14 = new Garbage();
        garbage14.setLatitude(51.5074);
        garbage14.setLongitude(-0.1278);
        garbage14.setDepth(30.000);
        garbage14.setDate(LocalDate.parse("2023-06-15"));
        garbage14.setDrone(drone10);

        Garbage garbage15 = new Garbage();
        garbage15.setLatitude(-33.8688);
        garbage15.setLongitude(151.2093);
        garbage15.setDepth(45.000);
        garbage15.setDate(LocalDate.parse("2023-06-20"));
        garbage15.setDrone(drone6);
        

        droneRepository.save(drone1);
        droneRepository.save(drone2);
        droneRepository.save(drone3);
        droneRepository.save(drone4);
        droneRepository.save(drone5);
        droneRepository.save(drone6);
        droneRepository.save(drone7);
        droneRepository.save(drone8);
        droneRepository.save(drone9);
        droneRepository.save(drone10);    

        garbageRepository.save(garbage1);
        garbageRepository.save(garbage2);
        garbageRepository.save(garbage3);
        garbageRepository.save(garbage4);
        garbageRepository.save(garbage5);
        garbageRepository.save(garbage6);
        garbageRepository.save(garbage7);
        garbageRepository.save(garbage8);
        garbageRepository.save(garbage9);
        garbageRepository.save(garbage10);
        garbageRepository.save(garbage11);
        garbageRepository.save(garbage12);
        garbageRepository.save(garbage13);
        garbageRepository.save(garbage14);
        garbageRepository.save(garbage15);
    }
    
}
