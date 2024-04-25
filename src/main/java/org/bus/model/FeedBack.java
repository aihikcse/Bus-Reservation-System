package org.bus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Entity
@Scope("Prototype")
@Component
public class FeedBack {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer feedBackId;
	@Column(name="driverRating", nullable=false)
    private Integer driverRating;
	@Column(name="serviceRating", nullable=false)
    private Integer serviceRating;
	@Column(name="overallRating", nullable=false)
    private Integer overallRating;
	@Column(name="comments", nullable=false)
    private String comments;
	@Column(name="feedBackDate", nullable=false)
    private LocalDate feedBackDate;
    @OneToOne
    private User user;
    @OneToOne
    private Bus bus;

    public FeedBack() {
    }

    
    public FeedBack(Integer feedBackId, Integer driverRating, Integer serviceRating, Integer overallRating,
                    String comments, LocalDate feedBackDate) {
        this.feedBackId = feedBackId;
        this.driverRating = driverRating;
        this.serviceRating = serviceRating;
        this.overallRating = overallRating;
        this.comments = comments;
        this.feedBackDate = feedBackDate;
    }

    public Integer getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(Integer feedBackId) {
        this.feedBackId = feedBackId;
    }

    public Integer getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(Integer driverRating) {
        this.driverRating = driverRating;
    }

    public Integer getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(Integer serviceRating) {
        this.serviceRating = serviceRating;
    }

    public Integer getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Integer overallRating) {
        this.overallRating = overallRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDate getFeedBackDate() {
        return feedBackDate;
    }

    public void setFeedBackDate(LocalDate feedBackDate) {
        this.feedBackDate = feedBackDate;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "feedBackId=" + feedBackId +
                ", driverRating=" + driverRating +
                ", serviceRating=" + serviceRating +
                ", overallRating=" + overallRating +
                ", comments='" + comments + '\'' +
                ", feedBackDate=" + feedBackDate +
                ", user=" + user +
                ", bus=" + bus +
                '}';
    }
}
