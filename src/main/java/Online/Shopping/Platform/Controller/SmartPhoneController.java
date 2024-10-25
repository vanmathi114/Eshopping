package Online.Shopping.Platform.Controller;

import Online.Shopping.Platform.Entity.Smartphone;
import Online.Shopping.Platform.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/smartphones")
public class SmartPhoneController {

    @Autowired
    private ProductService smartPhoneService;

    // Get all smartphones
    @GetMapping
    public List<Smartphone> getAllSmartphones() {
        return smartPhoneService.getAllSmartphone();
    }

    // Get a specific smartphone by ID
    @GetMapping("/{id}")
    public Smartphone getSmartphoneById(@PathVariable String id) {

        return smartPhoneService.findSmartPhoneById(id);
    }

    // Add a new smartphone
    @PostMapping
    public Smartphone addSmartphone(@RequestBody Smartphone smartPhone) {
        return smartPhoneService.addSmartphone(smartPhone);
    }

    // Update the cost of a smartphone (for admin use)
    @PutMapping("/{id}/update-cost")
    public void updateSmartphoneCost(@PathVariable String id, @RequestParam Double cost) {
        smartPhoneService.updateCost(id, cost);
    }

    // Purchase a smartphone (this involves making a payment through the Payment microservice)
    @PostMapping("/purchase")
    public String purchaseSmartphone(@RequestParam Double amount, @RequestParam String currency) {
        return smartPhoneService.purchaseSmartphone(amount, currency).toString();
    }
    
    // Get payment details (test the connection with PaymentService)
    @GetMapping("/payment/{id}")
    public String getPayment(@PathVariable String id) {
        return smartPhoneService.getPayment(id).toString();
    }
}
