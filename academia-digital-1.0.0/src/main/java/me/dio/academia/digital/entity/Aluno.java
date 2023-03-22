package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok - abstrair getter, setter, equals, hashcode
@NoArgsConstructor //criar construtor vazio, senão hibernate dá erro
@AllArgsConstructor //construtor com todos os atributos
@Entity //Vai persistir no BD e por default define a chave primária
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true) // unique = Atributo que não pode ser repetido
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //Um aluno vai ter muitas avaliações físicas, fetch.LAZY = quando pedir a informação de determinado aluno, vai retornar tudo relacionado àquele aluno somente
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
