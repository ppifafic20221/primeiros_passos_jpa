package main;

import domain.Contato;
import domain.Endereco;
import domain.Pessoa;
import domain.Veiculo;
import repository.ContatoRepository;
import repository.PessoaRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class App {

    public static void main(String[] args) {

        PessoaRepository pessoaRepository = new PessoaRepository();
        ContatoRepository contatoRepository = new ContatoRepository();

        Veiculo camaro = Veiculo.builder()
                .anoDeFabricacao(2020)
                .marca("Chevrolet")
                .modelo("Camaro")
                .build();

        Veiculo bmw = Veiculo.builder()
                .anoDeFabricacao(2021)
                .marca("BMW")
                .modelo("Z3")
                .build();

        Pessoa maria = new Pessoa("Maria", "321654");
        maria.setEndereco(Endereco.builder()
                        .uf("CE")
                        .cidade("Fortaleza")
                        .bairro("Iracema")
                        .rua("Santos Dumont")
                        .numero("20")
                .build());
        maria.setContatos(Arrays.asList(
                Contato.builder()
                        .email("maria@gmail.com")
                        .telefone("7777-7777")
                        .build()
        ));
        maria.setVeiculos(Arrays.asList(camaro));

        Pessoa jose = Pessoa.builder()
                .cpf("123456")
                .nome("Jose")
                .endereco(Endereco.builder()
                        .uf("PB")
                        .cidade("Sousa")
                        .bairro("Centro")
                        .rua("Santo Antonio")
                        .numero("30")
                        .build())
                .contatos(Arrays.asList(
                        Contato.builder()
                                .email("jose@gmail.com")
                                .telefone("9999-9999")
                                .build(),
                        Contato.builder()
                                .email("jose@hotmail.com")
                                .telefone("5555-66666")
                                .build()))
                .veiculos(Arrays.asList(camaro,bmw))
                .build();

        Pessoa pedro = Pessoa.builder()
                .cpf("785689")
                .nome("Pedro")
                .endereco(Endereco.builder()
                        .uf("PB")
                        .cidade("Cajazeiras")
                        .bairro("Centro")
                        .rua("Av. Joao Pessoa")
                        .numero("500-A")
                        .build())
                .contatos(Arrays.asList(
                        Contato.builder()
                                .telefone("2222-2222")
                                .email("pedro@yahoo.com")
                                .build()
                ))
                .veiculos(Arrays.asList(bmw))
                .build();

        System.out.println("iniciando operações na base de dados...");

//        pessoaRepository.savePessoa(maria);
//        pessoaRepository.savePessoa(pedro);
//        pessoaRepository.savePessoa(jose);

        //f8f7d055-bec6-469e-8c23-efa3366c0a6f id - Maria
        Contato contato = contatoRepository.contatoById(UUID.fromString("1736e124-f195-4be0-86d3-4bff2753a2c5"));
        Pessoa mariaRecuparada = pessoaRepository.findById(UUID.fromString("f8f7d055-bec6-469e-8c23-efa3366c0a6f"));
        contato.setPessoa(mariaRecuparada);
        contatoRepository.saveOrUpdateContato(contato);


      //  System.out.println(pessoaRepository.findById(UUID.fromString("eb730a4c-72fc-4abd-a262-534b7dcfa1b7")));
      //  System.out.println(pessoaRepository.getAll());
       // System.out.println(pessoaRepository.getStateByUF("PB"));

        System.out.println("operação realizada com sucesso!!!!");
    }


}
