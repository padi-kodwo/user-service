package com.userservice.controller.v1;

import com.userservice.model.ControllerResponse;
import com.userservice.model.User;
import com.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "find a user or all users within the passed page and limit")
    public ControllerResponse findUser(@PathVariable String userId,
                                       @RequestParam(required = false) Integer page,
                                       @RequestParam(required = false) Integer limit,
                                       HttpServletRequest httpServletRequest) {

        long start = new Date().getTime();
        String sessionId = httpServletRequest.getSession().getId();

        logger.info("[ " + sessionId + " ] about to request user");

        int code = 400;
        String message = "error";
        List<Object> data = new ArrayList<>();
        long total = 0;

        if (StringUtils.isNotEmpty(userId)) {
            code = 200;
            message = "failed to find any user for " + userId;

            User user = userService.findById(userId, sessionId);

            if (user != null) {
                message = "user found for " + userId;
                data.add(user);
            }
        }

        long duration = new Date().getTime() - start;

        logger.info("[ " + sessionId + " ] done retrieving user: " + duration);

        return new ControllerResponse(code, message, data, total, duration, sessionId);
    }


    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "stores user details")
    public ControllerResponse addUser(@RequestBody User user,
                                      HttpServletRequest httpServletRequest) {

        long start = new Date().getTime();
        String sessionId = httpServletRequest.getSession().getId();

        logger.info("[ " + sessionId + " ] about to add user");

        int code = 400;
        String message = "user was empty ";
        List<Object> data = new ArrayList<>();
        long total = 0;

        if (user != null) {
            code = 200;

             user = userService.add(user);
            if (user != null) {
                message = "user saved ";
                data.add(user);
            }
        }

        long duration = new Date().getTime() - start;

        logger.info("[ " + sessionId + " ] done saving user: " + duration);

        return new ControllerResponse(code, message, data, total, duration, sessionId);
    }
}
