package com.codeknight.recipeapp.repositories;

import com.codeknight.recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UomRepositoryTestIT {

    @Autowired
    private UomRepository uomRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescription() {
        Optional<UnitOfMeasure> unitOfMeasure = uomRepository.findByDescription("Tablespoon");
        assertEquals("Tablespoon", unitOfMeasure.get().getDescription());
    }
}
