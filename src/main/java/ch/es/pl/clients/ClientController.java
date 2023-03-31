package ch.es.pl.clients;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:9091")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Value("${jwt.secret}")
    private String secretKey;


    @GetMapping(value="/tokens")
    public ResponseEntity<String> requestToken(
            @RequestHeader("login") String login,
            @RequestHeader("password") String password) {
        Optional<ClientEntity> opt= clientRepository.findClientEntityByLogin(login);
        if (opt.isEmpty()) {
            throw new IncorrectLoginException(login);
        }
        ClientEntity clientEntity = opt.get();
        if (! password.equals(clientEntity.getPassword())) {
            throw new IncorrectLoginException(login);
        }
        String token = Jwts.builder()
                .setSubject(clientEntity.getPrenom())
                .claim("age", clientEntity.getAge())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }
}
