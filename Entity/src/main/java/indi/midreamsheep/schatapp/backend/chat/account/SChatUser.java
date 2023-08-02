package indi.midreamsheep.schatapp.backend.chat.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.netty.channel.Channel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SChatUser {
    private String username;
    private String privateKey;
    private Channel channel;
}
