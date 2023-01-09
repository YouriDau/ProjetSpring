package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Provider;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserDAOTest {
    private UserDAO userDAO;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProviderConverter providerConverter;

    @Before
    public void setUp() {
        userDAO = new UserDAO(userRepository, providerConverter);
    }

    @Test
    public void findByUsername() {
        // la méthode doit retourner un nouveau UserEntity tant qu'elle est appelée avec
        // un paramètre de type string
        User expectedUser = new User();
        UserEntity expectedUserEntity = new UserEntity();
        when(userRepository.findByUsername(anyString())).thenReturn(expectedUserEntity);

        when(providerConverter.userEntityToUserModel(expectedUserEntity)).thenReturn(expectedUser);

        assertEquals(userDAO.findByUsername("pseudoQuelconque"), expectedUser);
    }

    @Test
    public void addUser() {
        User testUser = new User();
        UserEntity expectedUserEntity = new UserEntity();

        // quand on appelle cette méthode avec un user ça doit nous renvoyer un userEntity
        when(providerConverter.userModelToUserEntity(testUser)).thenReturn(expectedUserEntity);
        userDAO.addUser(testUser);

        // vérifie que la méthode save à été appelée avec l'utilisateur
        verify(userRepository).save(expectedUserEntity);
    }
}