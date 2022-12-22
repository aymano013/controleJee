package com.match.matchticket.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponseDto {
    private Long id;
    private String reference;
    private Date date;
    private String lieu;
    private String equipe1;
    private String equipe2;
    private List<TicketResponseDto> ticketList;
}
