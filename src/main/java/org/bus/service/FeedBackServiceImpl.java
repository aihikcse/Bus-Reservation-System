package org.bus.service;

import org.bus.model.FeedBack;
import org.bus.repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FeedBackServiceImpl implements IFeedBackService{
    @Autowired
    private FeedBackRepository feedBackRepository;
    @Override
    public FeedBack addFeedBack(FeedBack feedback) {
        return feedBackRepository.save(feedback);
    }

    @Override
    public FeedBack updateFeedBack(FeedBack feedback) {
        return feedBackRepository.save(feedback);
    }

    @Override
    public FeedBack viewFeedBack(Integer feedbackId) {
        Optional<FeedBack> opt = feedBackRepository.findById(feedbackId);
        if(opt.isPresent()){
            FeedBack feedBack = opt.get();
            feedBackRepository.findById(feedbackId);
            return feedBack;
        }
        return null;
    }

    @Override
    public List<FeedBack> viewAllFeedBack() {
        return feedBackRepository.findAll();
    }
}
