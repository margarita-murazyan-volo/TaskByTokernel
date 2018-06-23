package com.example.tokernel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "number")
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "odd_number")
    private int oddNumber;
    @Column(name = "even_number")
    private int evenNumber;
    @ManyToOne
    private User user;

}
