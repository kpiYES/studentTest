package com.app.service.impl;

import com.app.dao.DAOFactory;
import com.app.dao.IQuestionDAO;
import com.app.model.Question;
import com.app.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
    private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.TypeDB.mySQL);
    private IQuestionDAO questionDAO = daoFactory.getQuestionDAO();


    @Override
    public Long insert(Question question) {
        return questionDAO.insert(question);
    }

    @Override
    public void update(Question question) {
questionDAO.insert(question);
    }

    @Override
    public void delete(Question question) {
questionDAO.delete(question);
    }

    @Override
    public Question getById(Long question_id) {
        return questionDAO.getById(question_id);
    }
}