package com.ms.user.exception;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@ControllerAdvice
@AllArgsConstructor // TODO crear tipos de excepciones !!!
public class HandleException {



  @ExceptionHandler(MyHandleException.class)
  public ResponseEntity<Object> handleException(MyHandleException ex){
      log.error(
              "{}{}",
              "Business Exception ",
              ex.getMessage()
      );

      return ResponseEntity
              .badRequest()
              .body("Business Exception :" + ex.getMessage());
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleException(Exception ex){

     log.error(
             "{}{}",
             "System Exception ",
             ex.getMessage()
     );

     return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("System Exception :" + ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List>
  handleValidationException(MethodArgumentNotValidException ex){
      List<String> erros= new ArrayList<>();
      for (FieldError error :  ex.getBindingResult().getFieldErrors()) {
          erros.add(error.getObjectName() + ":"
                  + error.getField() +" " + error.getDefaultMessage());
      }
      log.error(
              "ERROR NEGOCIO" + ":" + "error info : \n{}",erros
      );
      return ResponseEntity.badRequest().body(erros);
  }
}
