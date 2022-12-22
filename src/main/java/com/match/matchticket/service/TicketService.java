package com.match.matchticket.service;

import com.match.matchticket.dto.TicketRequestDto;
import com.match.matchticket.dto.TicketResponseDto;

import java.util.List;

public interface TicketService {


    List<TicketResponseDto> findAll();
    TicketResponseDto addTicket(Long id,TicketRequestDto ticketRequestDto);
    TicketResponseDto findById(Long id);
    TicketResponseDto updateTicket(Long id, TicketRequestDto ticketRequestDto);
    void deleteTicket(Long id);
}
