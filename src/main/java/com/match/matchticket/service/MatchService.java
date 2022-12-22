package com.match.matchticket.service;

import com.match.matchticket.dto.MatchRequestDto;
import com.match.matchticket.dto.MatchResponseDto;
import com.match.matchticket.model.Match;

import java.util.List;

public interface MatchService {

    List<MatchResponseDto> allMatch();
    MatchResponseDto findById(Long id);
    MatchResponseDto addMatch(MatchRequestDto matchRequestDto);
    MatchResponseDto updateMatch(Long id, MatchRequestDto matchRequestDto);
    void deleteMatch(Long id);
}
