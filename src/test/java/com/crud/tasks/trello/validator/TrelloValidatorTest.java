package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTest {
    @InjectMocks
    private TrelloValidator validator;

    @Test
    public void testValidateCard() {
        //given
        TrelloCard card = new TrelloCard("test", "test2", "test_pos", "1");
        //when & then
        validator.validateCard(card);
    }
    @Test
    public void shouldValidateTrelloBoards() {
        //given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "Test List", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", trelloLists));
        trelloBoards.add(new TrelloBoard("2", "Course", trelloLists));
        //when
        List<TrelloBoard> filteredBoards = validator.validateTrelloBoards(trelloBoards);
        //then
        assertEquals(1, filteredBoards.size());
    }
}