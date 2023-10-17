package com.library.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.project.entity.Cart;
import com.library.project.repository.CartRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class CartController {

      @Autowired
      private CartRepository cartRepository;
      
      @GetMapping("/cart/{id}")
      public List<Cart> getCartItemsByStudentId(@PathVariable("id") Long id) {
          return cartRepository.findByid(id);
      }
      
       @PostMapping("/cart")
     public Cart saveToCart(@RequestBody Cart cart) {
                   return cartRepository.save(cart);
     }
      
       /*@DeleteMapping("/cart") 
       public void deleteUser(@javax.validation.Valid @pathvariable long id @RequestBody Cart cart) { 

              cartRepository.deleteById(id);
      } */
      
       @DeleteMapping("/cart/{bookId}")
          public ResponseEntity<String> deleteDueBookByBookId(@PathVariable Long bookId) {
              try {
                  // Find the DueBooks entry by bookId
                  Optional<Cart> dueBook = cartRepository.findByBookId(bookId);

                  // If the entry exists, delete it
                  if (dueBook.isPresent()) {
                        cartRepository.delete(dueBook.get());
                      return ResponseEntity.ok("DueBook deleted successfully.");
                  } else {
                      return ResponseEntity.notFound().build();
                  }
              } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting DueBook.");
              }
          }
       @DeleteMapping("/cart")
       public ResponseEntity<String> deleteCart() {

       if(cartRepository.findAll().equals(null)) {
       return ResponseEntity.notFound().build();
       }
       cartRepository.deleteAll();
       return ResponseEntity.ok("successful");

       }
      
}//package com.library.project.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.library.project.entity.Cart;
//import com.library.project.repository.CartRepository;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/v1")
//public class CartController {
//
//              @Autowired
//              private CartRepository cartRepository;
//
//              @GetMapping("/cart")
//              public String sample() {
//                             return "This is my cart";
//              } 
//               
//              @PostMapping("/cart")
//                             public Cart saveToCart(@RequestBody Cart cart) {
//                                           return cartRepository.save(cart);
//                             }
//              
//               @DeleteMapping("/cart") 
//               public void deleteUser(@RequestBody Cart cart) { 
//                      cartRepository.delete(cart);
//              } 
//               
//}

