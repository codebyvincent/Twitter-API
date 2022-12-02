package com.cooksys.server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Announcements {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private Timestamp date = Timestamp.valueOf(LocalDateTime.now());

    private String title;

    private String message;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Users author;

}
