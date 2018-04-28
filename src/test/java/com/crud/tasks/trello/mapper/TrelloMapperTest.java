package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {
    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoard() {
        //Given
        List<TrelloBoardDto> boardDtoList = new ArrayList<>();
        TrelloBoardDto boardDto = new TrelloBoardDto("test_board", "test_id", new ArrayList<>());
        boardDtoList.add(boardDto);
        //When
        List<TrelloBoard> boardList = trelloMapper.mapToBoard(boardDtoList);
        //Then
        assertEquals(boardDtoList.size(), boardList.size());
        assertEquals(boardDtoList.get(0).getName(), boardList.get(0).getName());
        assertEquals(boardDtoList.get(0).getId(), boardList.get(0).getId());
        assertEquals(boardDtoList.get(0).getLists(), boardList.get(0).getLists());
    }
    @Test
    public void testMapToBoardDto() {
        //Given
        List<TrelloBoard> boardList = new ArrayList<>();
        TrelloBoard board = new TrelloBoard("test_board", "test_id", new ArrayList<>());
        boardList.add(board);
        //When
        List<TrelloBoardDto> boardListDto = trelloMapper.mapToBoardsDto(boardList);
        //Then
        assertEquals(boardList.size(), boardList.size());
        assertEquals(boardList.get(0).getName(), boardList.get(0).getName());
        assertEquals(boardList.get(0).getId(), boardList.get(0).getId());
        assertEquals(boardList.get(0).getLists(), boardList.get(0).getLists());
    }
    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> listDtoList = new ArrayList<>();
        TrelloListDto listDto = new TrelloListDto("test_list", "test_id", false);
        listDtoList.add(listDto);
        //When
        List<TrelloList> listList = trelloMapper.mapToList(listDtoList);
        //Then
        assertEquals(listDtoList.size(), listList.size());
        assertEquals(listDtoList.get(0).getId(), listList.get(0).getId());
        assertEquals(listDtoList.get(0).getName(), listList.get(0).getName());
        assertEquals(listDtoList.get(0).isClosed(), listList.get(0).isClosed());
    }
    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> listList = new ArrayList<>();
        TrelloList list = new TrelloList("test_list", "test_id", false);
        listList.add(list);
        //When
        List<TrelloListDto> listDtoList = trelloMapper.mapToListDto(listList);
        //Then
        assertEquals(listDtoList.size(), listList.size());
        assertEquals(listDtoList.get(0).getId(), listList.get(0).getId());
        assertEquals(listDtoList.get(0).getName(), listList.get(0).getName());
        assertEquals(listDtoList.get(0).isClosed(), listList.get(0).isClosed());
    }
    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("test name", "test description", "test", "test_id");
        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);
        //Then
        assertEquals(card.getName(), cardDto.getName());
        assertEquals(card.getDescription(), cardDto.getDescription());
        assertEquals(card.getPos(), cardDto.getPos());
        assertEquals(card.getListId(), cardDto.getListId());
    }
    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("test name", "test description", "test", "test_id");
        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);
        //Then
        assertEquals(card.getName(), cardDto.getName());
        assertEquals(card.getDescription(), cardDto.getDescription());
        assertEquals(card.getPos(), cardDto.getPos());
        assertEquals(card.getListId(), cardDto.getListId());
    }
}
