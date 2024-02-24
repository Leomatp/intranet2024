package com.Intranet_2024.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Intranet_2024.dto.DtoAuthRespuesta;
import com.Intranet_2024.dto.DtoLogin;
import com.Intranet_2024.model.Rol;
import com.Intranet_2024.model.Usuario;
import com.Intranet_2024.repository.UsuarioRepository;
import com.Intranet_2024.security.JwtGenerador;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/")
public class UsuarioController {
	 @Autowired
    private AuthenticationManager authenticationManager;
	 @Autowired
	 private UsuarioRepository usuarioRepository;
	@Autowired
    private JwtGenerador jwtGenerador;
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	
	
    //Método para poder logear un usuario y obtener un token
    @PostMapping("login")
   public ResponseEntity<DtoAuthRespuesta> login(@RequestBody DtoLogin dtoLogin) {
    	try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    dtoLogin.getUsername(), dtoLogin.getPassword()));
            	SecurityContextHolder.getContext().setAuthentication(authentication);
            	
            	String token = jwtGenerador.generarToken(authentication);
            	return new ResponseEntity<>(new DtoAuthRespuesta(token), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new DtoAuthRespuesta("No existe"), HttpStatus.NOT_FOUND);
		}
    }
    
    @PostMapping("register")
    public ResponseEntity<DtoAuthRespuesta> register(@RequestBody Usuario usuario) {
        try {
            // Verificar si el usuario ya existe
            if (usuarioRepository.findByLogin(usuario.getLogin()) != null) {
                return new ResponseEntity<>(new DtoAuthRespuesta("El usuario ya existe"), HttpStatus.BAD_REQUEST);
            }

            // Guardar el nuevo usuario
            usuario.setClave(passwordEncoder.encode(usuario.getClave()));
            Rol rol=new Rol();
            rol.setCodigoRol(2);
            usuario.setRol(rol);
            Usuario nuevoUsuario = usuarioRepository.save(usuario);

            // Crear la autenticación para el nuevo usuario
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    nuevoUsuario.getLogin(), nuevoUsuario.getClave());

            // Generar el token utilizando la autenticación
            String token = jwtGenerador.generarToken(authentication);

            return new ResponseEntity<>(new DtoAuthRespuesta(token), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new DtoAuthRespuesta("Error al registrar"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
