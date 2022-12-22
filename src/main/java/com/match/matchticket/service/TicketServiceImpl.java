package com.match.matchticket.service;

import com.match.matchticket.dto.TicketRequestDto;
import com.match.matchticket.dto.TicketResponseDto;
import com.match.matchticket.enums.Status;
import com.match.matchticket.mappers.TicketMapper;
import com.match.matchticket.model.Match;
import com.match.matchticket.model.Ticket;
import com.match.matchticket.repository.MatchRepository;
import com.match.matchticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    MatchRepository matchRepository;

    @Override
    public List<TicketResponseDto> findAll() {
        return ticketRepository.findAll().stream().map(ticket -> ticketMapper.ticketToResponse(ticket)).collect(Collectors.toList());
    }

    @Override
    public TicketResponseDto addTicket(Long id, TicketRequestDto ticketRequestDto) {
        Match match = matchRepository.findById(id).orElseThrow(()->new RuntimeException("Match not Fount"));
        Ticket ticket =TicketMapper.requestToTicket(ticketRequestDto);
        ticket.setReference(UUID.randomUUID().toString());
        ticket.setStatus(Status.ACTIVE);
        ticket.setMatch(match);
        ticketRepository.save(ticket);

        return ticketMapper.ticketToResponse(ticket);
    }

    @Override
    public TicketResponseDto findById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(()->new RuntimeException("Ticket not found"));
        return ticketMapper.ticketToResponse(ticket);
    }

    @Override
    public TicketResponseDto updateTicket(Long id, TicketRequestDto ticketRequestDto) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(()->new RuntimeException("Ticket Not found"));
        ticket.setPrix(ticketRequestDto.getPrix());
        ticketRepository.save(ticket);
        return ticketMapper.ticketToResponse(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);

    }
}
