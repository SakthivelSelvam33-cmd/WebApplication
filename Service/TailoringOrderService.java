package com.tailoringmanagementsystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tailoringmanagementsystem.Entity.TailoringOrder;
import com.tailoringmanagementsystem.Repo.TailoringOrderRepository;

@Service
public class TailoringOrderService 
{
    private final TailoringOrderRepository repository;
    public TailoringOrderService( TailoringOrderRepository repository)
    {
        this.repository = repository;
    }
    public TailoringOrder saveOrder(TailoringOrder order)
    {
        return repository.save(order);
    }
    public List<TailoringOrder> getAllOrders()
    {
        return repository.findAll();
    }
    public TailoringOrder updateOrder(Long id,TailoringOrder newOrder)
    {
        TailoringOrder oldOrder =repository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found"));
        oldOrder.setCustomerName(newOrder.getCustomerName());
        oldOrder.setPhone(newOrder.getPhone());
        oldOrder.setDressType(newOrder.getDressType());
        oldOrder.setCategory(newOrder.getCategory());
        oldOrder.setDeliveryDate(newOrder.getDeliveryDate());
        oldOrder.setTotalAmount(newOrder.getTotalAmount());
        oldOrder.setAdvanceAmount(newOrder.getAdvanceAmount());
        oldOrder.setBalanceAmount(newOrder.getBalanceAmount());
        oldOrder.setStatus(newOrder.getStatus());
        return repository.save(oldOrder);
    }

    public void deleteOrder(Long id)
    {
        repository.deleteById(id);
    }
    public TailoringOrder updateStatus(Long id,String status)
    {
        TailoringOrder order =repository.findById(id).orElseThrow();
        order.setStatus(status);
        return repository.save(order);
    }

}





