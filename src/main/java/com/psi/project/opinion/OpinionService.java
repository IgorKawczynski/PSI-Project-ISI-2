package com.psi.project.opinion;

import com.psi.project.opinion.dtos.OpinionRequestDTO;
import com.psi.project.opinion.dtos.OpinionResponseDTO;
import com.psi.project.opinion.valueobjects.DescriptionValidator;
import com.psi.project.opinion.valueobjects.RateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OpinionService {

    private final static Integer PAGESIZE = 5;
    private final OpinionRepository opinionRepository;
    private final OpinionMapper opinionMapper;

    @Autowired
    public OpinionService(OpinionRepository opinionRepository, OpinionMapper opinionMapper) {
        this.opinionRepository = opinionRepository;
        this.opinionMapper = opinionMapper;
    }

    public List<OpinionResponseDTO> getOpinions(Integer page) {
        Pageable sortedByRate = PageRequest.of(
                page, PAGESIZE, Sort.by(Sort.Direction.ASC, "rate")
        );

        var opinions = opinionRepository.findAll(sortedByRate);

        return opinionMapper.fromOpinionEntityListToOpinionResponseList(opinions.get().collect(Collectors.toList()));
    }

    public OpinionResponseDTO getOpinionById(Long id) {
        var opinion = opinionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Opinion with id: " + id + "does not exist!"));
        return opinionMapper.fromOpinionEntityToOpinionResponseDTO(opinion);
    }

    public String addOpinion(OpinionRequestDTO opinionRequestDTO) {
        var opinion = opinionMapper.fromOpinionRequestDTOToOpinionEntity(opinionRequestDTO);
        opinionRepository.save(opinion);
        return "Opinion added successfully!";
    }

    public String updateOpinionById(Long id, Integer rate, String description) {
        var opinion = opinionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Opinion with id: " + id + " does not exist!"));
        opinion.setRate(new RateValidator(rate));
        opinion.setDescription(new DescriptionValidator(description));
        opinionRepository.save(opinion);
        return "Opinion with id: " + id + " updated successfully!";
    }

    public String deleteOpinion(Long id) {
        var opinion = opinionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Opinion with id: " + id + " does not exist!"));
        opinionRepository.delete(opinion);
        return "Opinion with id: " + id + " deleted successfully!";
    }
}
