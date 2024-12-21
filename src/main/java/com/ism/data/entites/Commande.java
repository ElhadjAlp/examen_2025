package com.ism.data.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@Entity
@Table(name = "details")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private double montantTotal;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "commande_id")
    private List<Article> articles;

    
}
