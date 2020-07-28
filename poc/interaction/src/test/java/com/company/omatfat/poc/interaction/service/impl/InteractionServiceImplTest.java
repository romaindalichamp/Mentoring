package com.company.omatfat.poc.interaction.service.impl;

import com.company.omatfat.poc.interaction.dto.InteractionDto;
import com.company.omatfat.poc.interaction.service.api.InteractionServiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@SpringBootTest
public class InteractionServiceImplTest {

    @Autowired
    InteractionServiceApi interactionService;

    @Test
    @DisplayName("GIVEN fake InteractionDto WHEN i get by id THEN i expect the correct infos")
    void getInteractionEntity() {
        // GIVEN - Fake Data
        InteractionDto interactionDto = new InteractionDto();
        interactionDto.setFirstInfo("firstInfo");
        interactionDto.setSecondInfo("secondInfo");
        interactionDto.setThirdInfo("thirdInfo");
        InteractionDto myInteractionDtoCreated = interactionService.addInteractionEntity(interactionDto);

        // WHEN - method to test
        InteractionDto myResult = interactionService.getInteractionEntity(
                myInteractionDtoCreated.getId()
        );

        // THEN - Expected Result
        Assertions.assertTrue(myResult.getFirstInfo().equals("firstInfo"));
        Assertions.assertTrue(myResult.getSecondInfo().equals("secondInfo"));
        Assertions.assertTrue(myResult.getThirdInfo().equals("thirdInfo"));

        // FINALLY - clean
        interactionService.deleteInteractionEntity(myInteractionDtoCreated.getId());
    }
}
