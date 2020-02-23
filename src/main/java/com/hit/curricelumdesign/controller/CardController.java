package com.hit.curricelumdesign.controller;

import com.hit.curricelumdesign.context.annotation.HitApi;
import com.hit.curricelumdesign.context.param.card.CardBaseParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/card/getteachercardbyworkid/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getTeacherCardDTOByWorkId(CardBaseParam param) {
        return Result.success(cardService.getTeacherCardDTOByWorkId(param));
    }

    @RequestMapping(value = "/card/getstudentcardbyworkid/", method = RequestMethod.POST)
    @HitApi(checkAdminLogin = true)
    public Result getStudentCardDTOByWorkId(CardBaseParam param) {
        return Result.success(cardService.getStudentCardDTOByWorkId(param));
    }
}
