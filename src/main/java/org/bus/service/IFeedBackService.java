package org.bus.service;

import org.bus.model.FeedBack;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IFeedBackService {
    public FeedBack addFeedBack(FeedBack feedback);
    public FeedBack updateFeedBack(FeedBack feedback);
    public FeedBack viewFeedBack(Integer feedbackId);
    public List<FeedBack> viewAllFeedBack();
}
