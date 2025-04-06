package com.bca.quiz.dao;

import com.bca.quiz.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private TestDetailsRepository testRepository;
    private QuestionRepository questionRepository;
    private ChoiceRepository choiceRepository;

    public DataInitializer(PasswordEncoder passwordEncoder, RoleRepository roleRepository, UserRepository userRepository, TestDetailsRepository testRepository, QuestionRepository questionRepository, ChoiceRepository choiceRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
        this.choiceRepository = choiceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(testRepository.count() == 0){
            Role adminRole = new Role("ADMIN");
            Role userRole = new Role("USER");

            roleRepository.save(adminRole);
            roleRepository.save(userRole);

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            adminRoles.add(userRole);

            String password = passwordEncoder.encode("admin123");
            //String password = "admin123";
            User user = new User("arti@gmail.com", password, adminRoles);
            userRepository.save(user);

            TestDetails test1 = new TestDetails("General Knowledge Quiz", "Test your general knowledge with this fun quiz.");
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

            TestDetails test2 = new TestDetails("Science Basics", "A quiz on basic science concepts.");
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
