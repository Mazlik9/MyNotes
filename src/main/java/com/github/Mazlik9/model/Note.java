package com.github.Mazlik9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Заголовок не может быть пустым")
    @Size(max = 100, message = "Заголовок не может быть длиннее 100 символов")
    private String title;

    @NotBlank(message = "Содержание не может быть пустым")
    private String content;
}