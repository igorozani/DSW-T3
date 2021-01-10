package br.ufscar.dc.dsw;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IMedicoDAO;
import br.ufscar.dc.dsw.dao.IPacienteDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;

import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class LivrariaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, IMedicoDAO medicoDAO, IPacienteDAO pacienteDAO) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setUsername("admin");
			u1.setPassword(encoder.encode("admin"));
			
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
		
			Paciente u2 = new Paciente();
			u2.setUsername("beltrano@email");
			u2.setPassword(encoder.encode("123"));
			u2.setCpf("433.568.969-45");
			u2.setNome("Beltrano");
			u2.setNascimento("15/05/1996");
			u2.setTelefone("3223-5669");
			u2.setSexo("Masculino");
			u2.setRole("ROLE_PA");
			u2.setEnabled(true);
			pacienteDAO.save(u2);
			
			Medico u3 = new Medico();
			u3.setUsername("ciclano@email");
			u3.setPassword(encoder.encode("123"));
			u3.setCrm("45655875-3/BR");
			u3.setName("Ciclano");
			u3.setEspecialidade("Oncologista");
			u3.setRole("ROLE_ME");
			u3.setEnabled(true);
			medicoDAO.save(u3);
//			
//			Usuario u3 = new Usuario();
//			u3.setUsername("fulano@email");
//			u3.setPassword(encoder.encode("123"));
//			
//			u3.setName("Fulano Silva");
//			u3.setRole("ROLE_USER");
//			u3.setEnabled(true);
//			usuarioDAO.save(u3);
//			
//			Medico m1 = new Medico();
//			m1.setName("Ricardo");
//			m1.setUsername("ricardo@email");
//			m1.setPassword("senha");
//			m1.setEnabled(true);
//			m1.setEspecialidade("Clinico Geral");
//			m1.setCrm("456358753-7/BR");
//			
//			medicoDAO.save(m1);
//			Usuario usuario = new Usuario();
//			usuario.setUsername(m1.getUsername());
//			usuario.setPassword(encoder.encode(m1.getPassword()));
//			usuario.setName(m1.getName());
//			usuario.setRole("ROLE_ME");
//			usuario.setEnabled(true);
//			
//			usuarioDAO.save(usuario);
//			
//			Medico m2 = new Medico();
//			m2.setName("Diego");
//			m2.setUsername("diego@email");
//			m2.setPassword("senha");
//			m2.setEnabled(true);
//			m2.setEspecialidade("Gastro");
//			m2.setCrm("45655875-3/BR");
//			
//			medicoDAO.save(m2);
//			
//			Usuario usuario2 = new Usuario();
//			usuario2.setUsername(m2.getUsername());
//			usuario2.setPassword(encoder.encode(m2.getPassword()));
//			usuario2.setName(m2.getName());
//			usuario2.setRole("ROLE_ME");
//			usuario2.setEnabled(true);
//			
//			usuarioDAO.save(usuario2);
//			
//			
//			Medico m3 = new Medico();
//			m3.setName("Elisangela");
//			m3.setUsername("elisangela@email");
//			m3.setPassword("senha");
//			m3.setEnabled(true);
//			m3.setEspecialidade("Otorrino");
//			m3.setCrm("32235875-3/BR");
//			
//			medicoDAO.save(m3);
//			
//			Usuario usuario3 = new Usuario();
//			usuario3.setUsername(m3.getUsername());
//			usuario3.setPassword(encoder.encode(m3.getPassword()));
//			usuario3.setName(m3.getName());
//			usuario3.setRole("ROLE_ME");
//			usuario3.setEnabled(true);
//			
//			usuarioDAO.save(usuario3);
//			
//			Medico m4 = new Medico();
//			m4.setName("Bruna");
//			m4.setUsername("bruna@email");
//			m4.setPassword("senha");
//			m4.setEnabled(true);
//			m4.setEspecialidade("Oftamologista");
//			m4.setCrm("00635875-3/BR");
//			
//			medicoDAO.save(m4);
//			
//			
//			Usuario usuario4 = new Usuario();
//			usuario4.setUsername(m4.getUsername());
//			usuario4.setPassword(encoder.encode(m4.getPassword()));
//			usuario4.setName(m4.getName());
//			usuario4.setRole("ROLE_ME");
//			usuario4.setEnabled(true);
//			
//			usuarioDAO.save(usuario4);
			
		
			
			
		};
	}
}
