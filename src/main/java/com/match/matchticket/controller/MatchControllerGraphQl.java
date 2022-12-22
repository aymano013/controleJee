package com.match.matchticket.controller;


import com.match.matchticket.dto.MatchRequestDto;
import com.match.matchticket.dto.MatchResponseDto;
import com.match.matchticket.service.MatchServiceImpl;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MatchControllerGraphQl {

    @Autowired
    MatchServiceImpl matchService;

    @QueryMapping
    public List<MatchResponseDto> getMatchs(){
        return matchService.allMatch();
    }

    @QueryMapping
    public MatchResponseDto getMatchById(@Argument Long id){
        return  matchService.findById(id);
    }

    @MutationMapping
    public  MatchResponseDto addMatch( @Argument MatchRequestDto m){
        return  matchService.addMatch(m);
    }

    @MutationMapping
    public  MatchResponseDto updateMatch(@Argument Long id, @Argument MatchRequestDto m){
        return  matchService.updateMatch(id,m);
    }


    @MutationMapping
    public void deleteMatch( @Argument Long id){
       matchService.deleteMatch(id);
    }
}
