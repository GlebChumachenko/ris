package com.example.lab2.servlets;

import com.example.lab2.model.Developer;
import com.example.lab2.service.DeveloperService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "highestPaidDeveloperServlet", value = "/highestPaidDeveloper")
public class HighestPaidDeveloperServlet extends HttpServlet {

    @EJB
    private DeveloperService developerService;

    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Developer highestPaidDeveloper = developerService.findHighestPaidDeveloper();
        request.setAttribute("developers", List.of(highestPaidDeveloper));
        getServletContext().getRequestDispatcher("/developers.jsp").forward(request, response);
    }
}
