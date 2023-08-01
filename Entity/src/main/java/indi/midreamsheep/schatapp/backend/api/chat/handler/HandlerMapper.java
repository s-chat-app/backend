package indi.midreamsheep.schatapp.backend.api.chat.handler;

import indi.midreamsheep.schatapp.backend.api.chat.handler.annotation.ChatHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandlerMapper {
    private ChatHandler chatHandler;
    private Class<?> aClass;
}
