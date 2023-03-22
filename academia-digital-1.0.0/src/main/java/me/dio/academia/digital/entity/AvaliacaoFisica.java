package me.dio.academia.digital.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok - abstrair getter, setter, equals, hashcode
@NoArgsConstructor //criar construtor vazio, senão hibernate dá erro
@AllArgsConstructor //construtor com todos os atributos
@Entity //Vai persistir no BD e já pega a chave primária
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL) //Podem ter muitas avaliações para um aluno
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual")
  private double peso;

  @Column(name = "altura_atual")
  private double altura;

}
