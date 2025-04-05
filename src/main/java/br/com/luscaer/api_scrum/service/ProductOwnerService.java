package br.com.luscaer.api_scrum.service;

import br.com.luscaer.api_scrum.entity.ProductOwner;
import br.com.luscaer.api_scrum.repository.ProductOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOwnerService {

    @Autowired
    private ProductOwnerRepository productOwnerRepository;

    public String save(ProductOwner productOwner) {
        this.productOwnerRepository.save(productOwner);
        return "Product Owner saved successfully!";
    }

    public String update(ProductOwner productOwner, Long id) {
        if (!productOwnerRepository.existsById(id)) {
            throw new RuntimeException("ProductOwner not found");
        }
        productOwner.setId(id);
        this.productOwnerRepository.save(productOwner);
        return "Product Owner successfully updated!";
    }

    public String delete(Long id) {
        if (!productOwnerRepository.existsById(id)) {
            throw new RuntimeException("ProductOwner not found");
        }
        this.productOwnerRepository.deleteById(id);
        return "Product Owner deleted successfully!";
    }

    public List<ProductOwner> findAll() {
        return this.productOwnerRepository.findAll();
    }

    public ProductOwner findById(Long id) {
        return productOwnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductOwner not found"));
    }
}
