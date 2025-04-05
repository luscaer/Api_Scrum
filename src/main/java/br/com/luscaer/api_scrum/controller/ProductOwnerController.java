package br.com.luscaer.api_scrum.controller;

import br.com.luscaer.api_scrum.entity.ProductOwner;
import br.com.luscaer.api_scrum.service.ProductOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product-owner")
public class ProductOwnerController {

    @Autowired
    private ProductOwnerService productOwnerService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ProductOwner productOwner) {
        try {
            String message = productOwnerService.save(productOwner);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ProductOwner productOwner, @PathVariable Long id) {
        try {
            String message = productOwnerService.update(productOwner, id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String message = productOwnerService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductOwner>> findAll() {
        try {
            List<ProductOwner> productOwnerList = productOwnerService.findAll();
            return new ResponseEntity<>(productOwnerList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProductOwner> findById(@PathVariable Long id) {
        try {
            ProductOwner productOwner = productOwnerService.findById(id);
            return new ResponseEntity<>(productOwner, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
