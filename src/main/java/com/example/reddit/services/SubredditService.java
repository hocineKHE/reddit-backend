package com.example.reddit.services;

import com.example.reddit.dto.SubredditDto;
import com.example.reddit.exceptions.SpringRedditExceptions;
import com.example.reddit.mapper.Subredditmapper;
import com.example.reddit.models.Subreddit;
import com.example.reddit.repositories.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    @Autowired
    private SubredditRepository subredditRepository;

    @Autowired
    private Subredditmapper subredditmapper;


    @Transactional
    public SubredditDto saveSubreddit(SubredditDto subredditDto){
        Subreddit subreddit = subredditRepository.save(subredditmapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(subreddit.getId());
        return subredditDto;
    }


    @Transactional(readOnly = true)
    public List<SubredditDto> getAllSubreddits() {

        return subredditRepository.findAll()
                .stream()
                .map(subredditmapper::mapSubredditToDto)
                .collect(Collectors.toList());
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditExceptions("No subreddit found with ID - " + id));
        return subredditmapper.mapSubredditToDto(subreddit);
    }
}
