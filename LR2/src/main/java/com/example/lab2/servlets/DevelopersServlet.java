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
import java.util.List;

@WebServlet(name = "developersServlet", value = "/developers")
public class DevelopersServlet extends HttpServlet {

    @EJB
    private DeveloperService developerService;

    public void init() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String positionField = request.getParameter("position");
        List<Developer> developers;
        if (positionField == null || positionField.equals("")) {
            developers = developerService.getDevelopers();
        } else {
            developers = developerService.filterByPosition(positionField);
        }
        request.setAttribute("developers", developers);
        getServletContext().getRequestDispatcher("/developers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Developer highestPaidDeveloper = developerService.findHighestPaidDeveloper();
        req.setAttribute("highestPaidDeveloperFullName", highestPaidDeveloper.getFullName());
        resp.sendRedirect(req.getRequestURI());
    }

    public void destroy() {
    }
}