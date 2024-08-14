package com.ms.user.repository;

import com.ms.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IUserRepository  extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findByDocumentAndTypeDocument(String document, String typeDocument);

}
