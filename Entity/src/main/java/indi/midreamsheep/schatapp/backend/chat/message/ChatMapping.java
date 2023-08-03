package indi.midreamsheep.schatapp.backend.chat.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChatMapping {
    SEND("SEND"),
    EDIT("EDIT"),
    DELETE("DELETE"),
    LOGIN("LOGIN"),;

    public final String mapping;
}
