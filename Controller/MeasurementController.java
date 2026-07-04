package com.tailoringmanagementsystem.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tailoringmanagementsystem.Entity.Measurement;
import com.tailoringmanagementsystem.Service.MeasurementService;

@RestController
@RequestMapping("/api/measurements")
@CrossOrigin("*")
public class MeasurementController 
{
    private final MeasurementService service;

    public MeasurementController(
    MeasurementService service)
    {
    this.service = service;
    }
    @PostMapping
    public Measurement createMeasurement(
    @RequestBody Measurement measurement)
    {
    return service.saveMeasurement(measurement);
    }
    @GetMapping
    public List<Measurement> getAll()
    {
    return service.getAllMeasurements();
    }
    @GetMapping("/{id}")
    public Measurement getById( @PathVariable Long id)
    {
    return service.getMeasurementById(id);
    }
    @PutMapping("/{id}")
    public Measurement update(@PathVariable Long id, @RequestBody Measurement measurement)
    {
    return service.updateMeasurement(id,measurement);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
    service.deleteMeasurement(id);
    return "Deleted Successfully";
    }
}

