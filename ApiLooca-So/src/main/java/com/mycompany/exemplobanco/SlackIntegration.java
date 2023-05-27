package com.mycompany.exemplobanco;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class SlackIntegration {
    
    private static String webHookurl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-5244459468339-5257282549361-mu3Z5y802YDtZSFprutUXFSy";
    private static String slackChannel = "alertas-tecnico-infinitysolutions";
    
    public void enviaMensagemSlack(String mensagem){
        try{
        StringBuilder msgbuilder = new StringBuilder();
        msgbuilder.append(mensagem);
        
        Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
        
        WebhookResponse wbResp = Slack.getInstance().send(webHookurl, payload);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}