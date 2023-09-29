package indi.midreamsheep.schatapp.backend.netty.prototcp;

import lombok.Data;

/**
 * 解决netty半包粘包问题的自定义协议
 * */
@Data
public class MessageProtocol {
    private int len;
    private byte[] content;
}
