package com.example.hospital.entitites;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;

import static com.example.hospital.constants.ModelConstants.SITE_ROLE_PATTERN;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    public Role (String name){
        this.name = name;
    }
    @Override
    public String getAuthority(){
        return StringUtils.isEmpty(name) ?
                null : MessageFormat.format(SITE_ROLE_PATTERN,name);
    }
}
