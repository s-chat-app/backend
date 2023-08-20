package indi.midreamsheep.schatapp.backend.protocol.data.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ResultData {
    int getCode();

    String getMsg();
}