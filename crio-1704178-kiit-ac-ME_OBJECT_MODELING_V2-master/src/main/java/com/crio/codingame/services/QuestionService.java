package com.crio.codingame.services;

import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.repositories.IQuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;
    private int qid=0;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Create and store Question into the repository.

    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
     qid=qid+1;
     String id=Integer.toString(qid);
     Question q=new Question(id,title,level,difficultyScore);
     questionRepository.save(q);
     return q;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
        if(level==null){
            return questionRepository.findAll();
        }else{
            return questionRepository.findAllQuestionLevelWise(level);
        }
    }
    
}
