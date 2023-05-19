package com.example.lab2.service;

import com.example.lab2.model.Developer;
import jakarta.ejb.Local;

import java.util.List;
import java.util.concurrent.Delayed;

@Local
public interface DeveloperService {

    List<Developer> filterByPosition(String position);

    Developer findHighestPaidDeveloper();

    List<Developer> getDevelopers();
}
