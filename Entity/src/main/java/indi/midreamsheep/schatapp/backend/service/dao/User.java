package indi.midreamsheep.schatapp.backend.service.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private String data;
    private Timestamp time;
}