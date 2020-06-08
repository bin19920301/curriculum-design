package com.hit.curricelumdesign.context.param.work;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ScoreForWorkParam extends WorkBaseParam {

    /**
     * 评分
     */
    @NotNull
    @Min(value = 0, message = "评分")
    @Max(value = 100, message = "评分")
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreForWorkParam{" +
                "score=" + score +
                '}';
    }
}
