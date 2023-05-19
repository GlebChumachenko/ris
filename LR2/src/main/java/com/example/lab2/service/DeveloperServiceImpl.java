package com.example.lab2.service;

import com.example.lab2.model.Developer;
import jakarta.ejb.Stateful;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class DeveloperServiceImpl implements DeveloperService {

    private final List<Developer> developers;

    public DeveloperServiceImpl() {
        this.developers = new ArrayList<>();
        developers.add(new Developer("Sobolev Maxim Dmitrievich", "Android developer", 1.0, "Kotlin", 800.0));
        developers.add(new Developer("Demyanchik Andrey Pavlovich", "Java Developer", 1.0, "Spring", 1000.0));
        developers.add(new Developer("Bohushevich Kiril", "Python Developer", 1.0, "Python", 600.0));
    }

    @Override
    public List<Developer> filterByPosition(String position) {
        System.out.printf("Filtering developers by position %s\n", position);
        return developers.stream()
                .filter((developer -> developer.getPosition().equals(position)))
                .collect(Collectors.toList());
    }

    @Override
    public Developer findHighestPaidDeveloper() {
        System.out.println("Finding the highest paid developer...\n");
        return developers.stream()
                .sorted(Comparator.comparingDouble(Developer::getSalary))
                .reduce((first, second) -> second)
                .orElse(null);
    }

    @Override
    public List<Developer> getDevelopers() {
        return developers;
    }
}