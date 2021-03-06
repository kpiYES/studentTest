package com.app.controller.commands;

import com.app.model.Subject;
import com.app.service.ServiceFactory;
import com.app.service.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class ShowListOfSubjectsQuestionsFragmentCommand implements Command {

    private SubjectService subjectService = ServiceFactory.getSubjectService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Set<Subject> subjectSet = subjectService.findAll();
        request.getSession().setAttribute("subjectSet", subjectSet);
        request.setAttribute("pageFragment", "showListOfSubjectsQuestionsFragment.jsp");
        return "admin.jsp";
    }
}
