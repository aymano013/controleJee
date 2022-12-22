package com.match.matchticket;

import com.match.matchticket.dto.MatchRequestDto;
import com.match.matchticket.dto.TicketRequestDto;
import com.match.matchticket.enums.Status;
import com.match.matchticket.model.Match;
import com.match.matchticket.model.Ticket;
import com.match.matchticket.repository.MatchRepository;
import com.match.matchticket.repository.TicketRepository;
import com.match.matchticket.service.MatchServiceImpl;
import com.match.matchticket.service.TicketServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MatchTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchTicketApplication.class, args);
    }

  /*  @Bean
    CommandLineRunner commandLineRunner(MatchServiceImpl matchService, TicketServiceImpl ticketService){
        return args -> {
            MatchRequestDto matchRequestDto = new MatchRequestDto(new Date(),"A","B","Z");
            matchService.addMatch(matchRequestDto);
            for (int i = 0; i < 10; i++) {
                TicketRequestDto ticketRequestDto = new TicketRequestDto((float) (Math.random()*100));
                ticketService.addTicket(1L,ticketRequestDto);
            }

        };
    }

   */

}
