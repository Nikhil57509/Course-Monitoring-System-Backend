package com.cms.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.demo.courses.Batch;
import com.cms.demo.model.BatchModel;
import com.cms.demo.repo.Batchrepo;

@Service
public class BatchImpl implements BatchService {

    @Autowired
    private Batchrepo batchRepository;

    @Override
    public Batch createBatch(Batch batchDto) {
        BatchModel batchModel = new BatchModel();
        batchModel.setBatchName(batchDto.getBatchName());
        batchModel.setStartDate(LocalDate.parse(batchDto.getStartDate()));
        batchModel.setEndDate(LocalDate.parse(batchDto.getEndDate()));
        batchModel.setCourseName(batchDto.getCourseName());
        batchModel.setInstructorName(batchDto.getInstructorName());
        batchModel.setCapacity(batchDto.getCapacity());
        batchModel.setCurrentEnrollment(batchDto.getCurrentEnrollment());
        batchModel.setStatus(batchDto.getStatus());
        batchModel.setDescription(batchDto.getDescription());
        batchModel.setCreatedDate(LocalDate.now());
        BatchModel savedBatch = batchRepository.save(batchModel);
        return convertToDto(savedBatch);
    }
    








    @Override
    public Batch getBatchById(Long id) {
        BatchModel batch = batchRepository.findById(id)
                .orElseThrow();
        return convertToDto(batch);
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Batch updateBatch(Long id, Batch batchDto) {
        BatchModel batch = batchRepository.findById(id)
                .orElseThrow();
        batch.setBatchName(batchDto.getBatchName());
        batch.setStartDate(LocalDate.parse(batchDto.getStartDate()));
        batch.setEndDate(LocalDate.parse(batchDto.getEndDate()));
        batch.setCourseName(batchDto.getCourseName());
        batch.setInstructorName(batchDto.getInstructorName());
        batch.setCapacity(batchDto.getCapacity());
        batch.setCurrentEnrollment(batchDto.getCurrentEnrollment());
        batch.setStatus(batchDto.getStatus());
        batch.setDescription(batchDto.getDescription());
        batch.setUpdatedDate(LocalDate.now());
        BatchModel updatedBatch = batchRepository.save(batch);
        return convertToDto(updatedBatch);
    }

    @Override
    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }

    private Batch convertToDto(BatchModel batch) {
        Batch batchDto = new Batch();
        batchDto.setId(batch.getId());
        batchDto.setBatchName(batch.getBatchName());
        batchDto.setStartDate(batch.getStartDate().toString());
        batchDto.setEndDate(batch.getEndDate().toString());
        batchDto.setCourseName(batch.getCourseName());
        batchDto.setInstructorName(batch.getInstructorName());
        batchDto.setCapacity(batch.getCapacity());
        batchDto.setCurrentEnrollment(batch.getCurrentEnrollment());
        batchDto.setStatus(batch.getStatus());
        batchDto.setDescription(batch.getDescription());
        batchDto.setCreatedDate(batch.getCreatedDate().toString());
        batchDto.setUpdatedDate(batch.getUpdatedDate() != null ? batch.getUpdatedDate().toString() : null);
        return batchDto;
    }
}
