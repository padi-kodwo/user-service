package com.userservice.controller.v1;

import com.userservice.model.Interest;
import com.userservice.model.User;
import com.userservice.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;

    private User user;


    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setDob("13/06/1995");
        user.setFirstName("Padi");
        user.setOtherName("Kodwo");
        user.setLastName("Amu");
        List<Interest> interests = new ArrayList<>();
        interests.add(Interest.NEWS);
        user.setInterests(interests);

        this.user = user;
    }

    @Test
    public void findUser() {
    }

    @Test
    public void addUser() {


    }
}