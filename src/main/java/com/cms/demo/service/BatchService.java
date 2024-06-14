package com.cms.demo.service;

import java.util.List;

import com.cms.demo.courses.Batch;

public interface BatchService {
    Batch createBatch(Batch batchDto);
    Batch getBatchById(Long id);
    List<Batch> getAllBatches();
    Batch updateBatch(Long id, Batch batchDto);
    void deleteBatch(Long id);
}