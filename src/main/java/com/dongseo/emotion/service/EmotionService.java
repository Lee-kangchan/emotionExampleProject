package com.dongseo.emotion.service;

import com.dongseo.emotion.entity.Emotion;
import com.dongseo.emotion.repository.EmotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmotionService {
    EmotionRepository emotionRepository;

    public List<Emotion> userEmotionService(String id){
        return emotionRepository.findAllByUser(id);
    }
}
