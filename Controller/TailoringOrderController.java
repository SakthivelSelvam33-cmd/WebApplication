package com.tailoringmanagementsystem.Controller;


import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.tailoringmanagementsystem.Entity.TailoringOrder;
import com.tailoringmanagementsystem.Service.TailoringOrderService;



@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class TailoringOrderController 
{
    private final TailoringOrderService service;
    public TailoringOrderController(TailoringOrderService service)
    {
    this.service = service;
    }
    @PostMapping
    public TailoringOrder createOrder(@RequestBody TailoringOrder order)
    {
    return service.saveOrder(order);
    }
    @GetMapping
    public List<TailoringOrder> viewOrders()
    {
    return service.getAllOrders();
    }
    @PutMapping("/{id}")
    public TailoringOrder updateOrder( @PathVariable Long id,@RequestBody TailoringOrder order)
    {
    return service.updateOrder(id, order);
    }
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id)
    {
    service.deleteOrder(id);
    return "Order Deleted Successfully";
    }
    @PutMapping("/{id}/status")
    public TailoringOrder changeStatus(@PathVariable Long id,@RequestParam String status)
    {
    return service.updateStatus(id,status);
    }
}