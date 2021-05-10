package com.userservice.service;

import com.userservice.model.User;
import com.userservice.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  private final RestTemplate restTemplate;
  private final UserRepo userRepo;

  @Value("${news.api.url}")
  private String newsApiUrl;

  @Value("${news.search.path}")
  private String newsSearchPath;

  @Value("${news.page.limit}")
  private Integer newPageLimit;

  @Value("${news.api.key}")
  private String newsApiKey;

  @Value("${news.api.language}")
  private String newsApiLanguage;

  public UserService(RestTemplate restTemplate, UserRepo userRepo) {
    this.restTemplate = restTemplate;
    this.userRepo = userRepo;
  }

  public User findById(String userId, String sessionId) {

    Optional<User> optionalUser = userRepo.findById(userId);
    if (optionalUser.isPresent()) {

      User user = optionalUser.get();
      logger.info("[" + sessionId + "] user found " + user);

      return user;
    }

    return null;
  }
}
