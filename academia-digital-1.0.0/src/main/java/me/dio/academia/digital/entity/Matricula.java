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
@Table(name = "tb_matricula")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL) //Uma matrícula para um aluno
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
