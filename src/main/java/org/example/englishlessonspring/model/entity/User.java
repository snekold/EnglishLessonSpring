package org.example.englishlessonspring.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private long point;

    @ManyToMany()
    @JoinTable(
            name = "user_word"
            ,joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "word_id")
    )
    private List<Word> wordList = new ArrayList<>();



}
