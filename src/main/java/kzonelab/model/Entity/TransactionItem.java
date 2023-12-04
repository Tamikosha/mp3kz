package kzonelab.model.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction_items")
public class TransactionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

}
