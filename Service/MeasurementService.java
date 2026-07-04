package com.tailoringmanagementsystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tailoringmanagementsystem.Entity.Measurement;
import com.tailoringmanagementsystem.Repo.MeasurementRepository;

@Service
public class MeasurementService 
{
    private final MeasurementRepository repository;
    public MeasurementService(
    MeasurementRepository repository)
    {
        this.repository = repository;
    }
    public Measurement saveMeasurement(
    Measurement measurement)
    {
        return repository.save(measurement);
    }
    public List<Measurement> getAllMeasurements()
    {
        return repository.findAll();
    }
    public Measurement getMeasurementById(Long id)
    {
        return repository.findById(id).orElse(null);
    }
    public Measurement updateMeasurement(Long id,Measurement measurement)
    {
    Measurement old =repository.findById(id).orElse(null);
    if(old!=null)
    {
        old.setOrderId(measurement.getOrderId());

        old.setChest(measurement.getChest());

        old.setWaist(measurement.getWaist());

        old.setShoulder(measurement.getShoulder());

        old.setSleeve(measurement.getSleeve());

        old.setHip(measurement.getHip());

        old.setNeck(measurement.getNeck());

        old.setLength(measurement.getLength());
    return repository.save(old);    
    }
    return null;
    }

    public void deleteMeasurement(Long id)
    {
    repository.deleteById(id);
    }

    }
