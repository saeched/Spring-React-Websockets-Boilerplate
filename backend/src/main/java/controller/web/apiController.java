/***********************************************
 *            gameController.java              *
 *                                             *
 *   Handles requests from the client.         *
 *   It takes requests at web addresses        *
 *   specified in GetMapping annotation        *
 *   gets data from the model to return        *
 *                                             *
 * ********************************************/
 
package controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import java.security.Principal;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;


import java.util.Timer;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

@Controller
@CrossOrigin
public class apiController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

	// Add user to lobby
    @SubscribeMapping("/sampSubscribe")
    void sampleSubscripe(Principal principal) {
        messagingTemplate.convertAndSend("/sampleSend", "here");
    }

        // Add user to lobby

    @MessageMapping("/sampMess")
    @SendTo("/topic/sampMessSend")
    void sampleMessageMapping() {

    }

	@MessageMapping("/ping")
    public void ping(String response) {
		//accept ping to keep WS open
    }

}