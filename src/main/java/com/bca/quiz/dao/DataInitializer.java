package com.bca.quiz.dao;

import com.bca.quiz.model.Choice;
import com.bca.quiz.model.Question;
import com.bca.quiz.model.QuestionType;
import com.bca.quiz.model.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private TestRepository testRepository;
    private QuestionRepository questionRepository;
    private ChoiceRepository choiceRepository;

    public DataInitializer(TestRepository testRepository, QuestionRepository questionRepository, ChoiceRepository choiceRepository) {
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
        this.choiceRepository = choiceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(testRepository.count() == 0){
            Test test1 = new Test("General Knowledge Quiz", "Test your general knowledge with this fun quiz.");
            testRepository.save(test1);

            Question test1Que1 = new Question(test1, "What is the capital of France?", QuestionType.SINGLE);
            questionRepository.save(test1Que1);

            Choice test1Que1Choice1 = new Choice(test1Que1, "Paris", true);
            Choice test1Que1Choice2 = new Choice(test1Que1, "London", false);
            Choice test1Que1Choice3 = new Choice(test1Que1, "Berlin", false);
            Choice test1Que1Choice4 = new Choice(test1Que1, "Madrid", false);

            choiceRepository.save(test1Que1Choice1);
            choiceRepository.save(test1Que1Choice2);
            choiceRepository.save(test1Que1Choice3);
            choiceRepository.save(test1Que1Choice4);

            Question test1Que2 = new Question(test1, "Which of the following are primary colors?", QuestionType.MULTIPLE);
            questionRepository.save(test1Que2);

            Choice test1Que2Choice1 = new Choice(test1Que2, "Red", true);
            Choice test1Que2Choice2 = new Choice(test1Que2, "Blue", true);
            Choice test1Que2Choice3 = new Choice(test1Que2, "Green", true);
            Choice test1Que2Choice4 = new Choice(test1Que2, "Yellow", false);

            choiceRepository.save(test1Que2Choice1);
            choiceRepository.save(test1Que2Choice2);
            choiceRepository.save(test1Que2Choice3);
            choiceRepository.save(test1Que2Choice4);

            Test test2 = new Test("Science Basics", "A quiz on basic science concepts.");
            testRepository.save(test2);

            Question test2Que1 = new Question(test2, "Is water made up of hydrogen and oxygen", QuestionType.SINGLE);
            questionRepository.save(test2Que1);

            Choice test2Que1Choice1 = new Choice(test2Que1, "Yes", true);
            Choice test2Que1Choice2 = new Choice(test2Que1, "No", false);
            choiceRepository.save(test2Que1Choice1);
            choiceRepository.save(test2Que1Choice2);

            Question test2Que2 = new Question(test2, "Which of these are planets in our solar system?", QuestionType.MULTIPLE);
            questionRepository.save(test2Que2);

            Choice test2Que2Choice1 = new Choice(test2Que2, "Mars", true);
            Choice test2Que2Choice2 = new Choice(test2Que2, "Venus", true);
            Choice test2Que2Choice3 = new Choice(test2Que2, "Pluto", false);
            Choice test2Que2Choice4 = new Choice(test2Que2, "Jupiter", true);

            choiceRepository.save(test2Que2Choice1);
            choiceRepository.save(test2Que2Choice2);
            choiceRepository.save(test2Que2Choice3);
            choiceRepository.save(test2Que2Choice4);
        }
    }
}
